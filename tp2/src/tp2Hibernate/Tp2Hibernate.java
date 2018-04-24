package tp2Hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import tp2Hibernate.dao.HibernateUtil;
import tp2Hibernate.entite.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class Tp2Hibernate {
    static SessionFactory sessionFactory = null;
    private static final String REQ1 = "1) AFFICHER LE NOMBRE DE CHIRURGIES PAR DOCTEUR";
    private static final String REQ2 = "2) AFFICHER LE NOMBRE DE CONSULTATIONS PAR DOCTEUR";
    private static final String REQ3 = "3) AFFICHER LE NOMBRE DE CONSULTATIONS PAR ANNÉE";
    private static final String REQ4 = "4) AFFICHER LE NOMBRE DE MÉDICAMENTS PRESCRITS PAR DOCTEUR";
    private static final String REQ5 = "5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MÉDICAMENTEUX PAR ANNEES";



    public static Session getSession() { return sessionFactory.isOpen()? sessionFactory.openSession(): sessionFactory.getCurrentSession(); }
    public static void closeSession(){ sessionFactory.close(); }

    /**
     * Affiche le nombre de chirurgies pas docteur
     * @param session la session hibernate
     */
    private static  void printNbrChirurgieParDocteur(Session session){

        List results;
        Criteria criteria;
        criteria = session.createCriteria(Docteur.class, "d")
                .createCriteria("consultations", "cons")
                .createCriteria("ordonnance", "ord")
                .createCriteria("ordonnancechirurgies", "ordchir")
                .createCriteria("chirurgie", "chir")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("d.matricule"))
                        .add(Projections.groupProperty("d.nomm"))
                        .add(Projections.groupProperty("d.prenomm"))
                        .add(Projections.count("ordchir.ordonnance"))
                );

        results = criteria.list();

        System.out.println(REQ1);
        System.out.println("ID----Nom------Prenom------nbrChirurgies");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }
        System.out.println("\n");
    }

    /**
     * Affiche le nombre de consultations pas docteur
     * @param session la session hibernate
     */
    private  static  void printNbrConsultationParDocteur(Session session){

        List results;
        Criteria criteria;
        criteria = session.createCriteria(Docteur.class, "d")
                .createCriteria("consultations", "cons")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("d.matricule"))
                        .add(Projections.groupProperty("d.nomm"))
                        .add(Projections.groupProperty("d.prenomm"))
                        .add(Projections.count("cons.ordonnance"))
                );

        results = criteria.list();

        System.out.println(REQ2);
        System.out.println("ID----Nom------Prenom------nbrConsultations");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }
        System.out.println("\n");
    }

    /**
     * Affiche le nombre de consultations par année
     * @param session la session hibernate
     */
    private static void printNbrConsultationParAnnee(Session session){

        List results;
        Criteria criteria;
        criteria = session.createCriteria(Consultation.class, "c")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("c.id"))
                        .add(Projections.rowCount())
                );

        results = criteria.list();

        System.out.println(REQ3);
        System.out.println("Annees----nbrConsultations");
        Map<Integer, Object> anneeConsultation = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            ConsultationId cid = (ConsultationId) donnees[0];
            java.util.Date date = cid.getDatec();
            calendar.setTime(date);
            Integer count = (Integer) anneeConsultation.get(calendar.get(Calendar.YEAR));
            if (count == null) {
                anneeConsultation.put(calendar.get(Calendar.YEAR), 1);
            } else {
                anneeConsultation.put(calendar.get(Calendar.YEAR), ++count);
            }
        }

        for (Map.Entry<Integer, Object> entry : anneeConsultation.entrySet()) {
            System.out.println(entry.getKey() + "         " + entry.getValue());
        }
        System.out.println("\n");
    }

    /**
     * Affiche le nombre de de médicaments prescrits pas docteur
     * @param session la session hibernate
     */
    private static void printNbrMedicamentsPrescritParDocteur (Session session){

        List results;
        Criteria criteria;
        criteria = session.createCriteria(Docteur.class, "d")
                .createCriteria("consultations", "cons")
                .createCriteria("ordonnance", "ord")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("d.matricule"))
                        .add(Projections.groupProperty("d.nomm"))
                        .add(Projections.groupProperty("d.prenomm"))
                        .add(Projections.sum("ord.nbrmedicaments"))
                );

        results = criteria.list();

        System.out.println(REQ4);
        System.out.println("ID----Nom------Prenom------nbrmedicaments");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }
        System.out.println("\n");
    }

    /**
     * Affiche le nombre de chirurgies vs le nbr de traitements médicamenteux par années
     * @param session la session hibernate
     */
    private static  void printRatioChirurgiesVsTraitementsMedicamenteuxParAnnees (Session session){

        List results;
        Criteria criteria;

        //list all completed cirurgies
        criteria = session.createCriteria(Chirurgie.class, "c")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("c.datechirurgie"))
                        .add(Projections.rowCount())
                );

        List chirurgiepardateList = criteria.list();

        //list all drugs prescriptions
        criteria = session.createCriteria(Ordonnance.class, "o")
                .add(Restrictions.eq("o.type", "Médicaments"))
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("o.datec"))
                        .add(Projections.rowCount())
                );

        List traitementMedicamenteuxList = criteria.list();

        //map the list
        Map<Integer, Object> chirurgiepardateMap = HibernateUtil.listToMap(chirurgiepardateList);
        Map<Integer, Object> traitementMedicamenteuxMap = HibernateUtil.listToMap(traitementMedicamenteuxList);Map<Integer, Integer> resultat = new HashMap<>();


        //map results
        for (Map.Entry<Integer, Object> entry : chirurgiepardateMap.entrySet()) {
            for (Map.Entry<Integer, Object> entry2 : traitementMedicamenteuxMap.entrySet()) {
                if (entry.getKey().equals(entry2.getKey())) {
                    Integer l = (Integer) entry.getValue();
                    Integer l2 = (Integer) entry2.getValue();
                    resultat.put(entry.getKey(), l / l2);
                }
            }
        }

        //print results
        System.out.println(REQ5);
        System.out.println("Annees----ratio");
        for (Map.Entry<Integer, Integer> entry : resultat.entrySet()) {
            System.out.println(entry.getKey() + "         " + entry.getValue());
        }
        System.out.println("\n");
    }


    public static void main(final String[] args) {


        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .setProperty("hibernate.connection.url", args[0])
                    .setProperty("hibernate.connection.username", args[1])
                    .setProperty("hibernate.connection.password", args[2])
                    .buildSessionFactory();

            //disable log
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

        Session session = null;
        try {
            session = sessionFactory.openSession();
            HibernateUtil.populateTables();

            //wait to print stack trace before finally
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                printNbrChirurgieParDocteur(session);
                printNbrConsultationParDocteur(session);
                printNbrConsultationParAnnee(session);

                //ne pas évaluer
//            printNbrMedicamentsPrescritParDocteur(session);
//            printRatioChirurgiesVsTraitementsMedicamenteuxParAnnees(session);

                //clean up
                session.close();
                sessionFactory.close();
            }
        }
    }
}
