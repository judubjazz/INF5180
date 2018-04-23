package tp2Hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import tp2Hibernate.dao.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import tp2Hibernate.entite.*;

import java.util.*;

public class Tp2Hibernate {
    private static final SessionFactory ourSessionFactory;
    private static final String REQ1 = "1) AFFICHER LE NOMBRE DE CHIRURGIES PAR DOCTEUR";
    private static final String REQ2 = "2) AFFICHER LE NOMBRE DE CONSULTATIONS PAR DOCTEUR";
    private static final String REQ3 = "3) AFFICHER LE NOMBRE DE CONSULTATIONS PAR ANNÉE";
    private static final String REQ4 = "4) AFFICHER LE NOMBRE DE MÉDICAMENTS PRESCRITS PAR DOCTEUR";
    private static final String REQ5 = "5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MÉDICAMENTEUX PAR ANNEES";

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    private static  void printNbrChirurgieParDocteur(Session session){
        //            -- 1a) Afficher le nombre de chirurgies par docteur
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

        System.out.println("ID----Nom------Prenom------nbrChirurgies");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }

    }

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

        System.out.println("-- 2a) Afficher le nombre de consultations par docteurs");
        System.out.println("ID----Nom------Prenom------nbrConsultations");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }
    }

    private static void printNbrConsultationParAnnee(Session session){
        //            -- 3a) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE
        List results;
        Criteria criteria;
        criteria = session.createCriteria(Consultation.class, "c")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("c.id"))
                        .add(Projections.rowCount())
                );

        results = criteria.list();

        System.out.println("-- 3a) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE");
        System.out.println("Annees----nbrConsultations");
        Map<Integer, Object> anneeConsultation = new HashMap<>();
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            ConsultationId cid = (ConsultationId) donnees[0];
            java.util.Date date = cid.getDatec();
            Integer count = (Integer) anneeConsultation.get(date.getYear());
            if (count == null) {
                anneeConsultation.put(date.getYear(), 1);
            } else {
                anneeConsultation.put(date.getYear(), ++count);
            }
        }

        for (Map.Entry<Integer, Object> entry : anneeConsultation.entrySet()) {
            System.out.println(entry.getKey() + "         " + entry.getValue());
        }
    }

    private static void printNbrMedicamentsPrescritParDocteur (Session session){
        //            -- 4a) Afficher le nombre de medicaments prescrits par docteur
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

        System.out.println("-- 4a) Afficher le nombre de medicaments prescrits par docteur");
        System.out.println("ID----Nom------Prenom------nbrmedicaments");
        for (Object result : results) {
            Object[] donnees = (Object[]) result;
            System.out.println(donnees[0] + "    " + donnees[1] + "     " + donnees[2] + "         " + donnees[3]);
        }
    }

    private static  void printRatioChirurgiesVsTraitementsMedicamenteuxParAnnees (Session session){
        //    -- 5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES.
        List results;
        Criteria criteria;
        criteria = session.createCriteria(Chirurgie.class, "c")
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("c.datechirurgie"))
                        .add(Projections.rowCount())
                );

        List chirurgiepardateList = criteria.list();

        criteria = session.createCriteria(Ordonnance.class, "o")
                .add(Restrictions.eq("o.type", "Médicaments"))
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("o.datec"))
                        .add(Projections.rowCount())
                );

        List traitementMedicamenteuxList = criteria.list();


        Map<Integer, Object> chirurgiepardateMap = DbUtil.listToMap(chirurgiepardateList);
        Map<Integer, Object> traitementMedicamenteuxMap = DbUtil.listToMap(traitementMedicamenteuxList);
        Map<Integer, Integer> resultat = new HashMap<>();


        for (Map.Entry<Integer, Object> entry : chirurgiepardateMap.entrySet()) {
            for (Map.Entry<Integer, Object> entry2 : traitementMedicamenteuxMap.entrySet()) {
                if (entry.getKey().equals(entry2.getKey())) {
                    Integer l = (Integer) entry.getValue();
                    Integer l2 = (Integer) entry2.getValue();
                    resultat.put(entry.getKey(), l / l2);
                }
            }
        }

        System.out.println("-- 5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES");
        System.out.println("Annees----ratio");
        for (Map.Entry<Integer, Integer> entry : resultat.entrySet()) {
            System.out.println(entry.getKey() + "         " + entry.getValue());
        }
    }

    public static void main(final String[] args) {
        final Session session = getSession();

        try {
            DbUtil.populateTables();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            printNbrChirurgieParDocteur(session);
            printNbrConsultationParDocteur(session);
            printNbrConsultationParAnnee(session);
//            printNbrMedicamentsPrescritParDocteur(session);
//            printRatioChirurgiesVsTraitementsMedicamenteuxParAnnees(session);
            session.close();
            ourSessionFactory.close();
        }
    }
}
