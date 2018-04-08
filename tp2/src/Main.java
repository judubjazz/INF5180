import dao.SalleDAO;
import entite.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import static java.sql.Types.NULL;

public class Main {
    private static final SessionFactory ourSessionFactory;

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

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            BigDecimal id10 = new BigDecimal(10);
            BigDecimal id11 = new BigDecimal(11);
            BigDecimal id12 = new BigDecimal(12);
            BigDecimal id13 = new BigDecimal(13);
            BigDecimal id100 = new BigDecimal(100);
            BigDecimal v0 = new BigDecimal(0);
            BigDecimal v100 = new BigDecimal(100);

            Date date1 = new Date();
            Date date2 = new Date();
            Date date3 = new Date();

//            Specialite specialite1 = new Specialite(id10,"Esthetique","Facial");
//            Specialite specialite2 = new Specialite(id11,"Urgentiste","Accident");
//            Specialite specialite3 = new Specialite(id12,"Opthamologiste","Chirurgie");
            Specialite specialite1 = new Specialite(id10,"Esthetique");
            Specialite specialite2 = new Specialite(id11,"Urgentiste");
            Specialite specialite3 = new Specialite(id12,"Opthamologiste");

            Salle salle1 = new Salle(id10, "wilfred");
            Salle salle2 = new Salle(id11, "calixa");
            Salle salle3 = new Salle(id12, "abraham");

//            Categories categories1 = new Categories(id10, "comprime", "comprime");
//            Categories categories2 = new Categories(id11, "gelule", "gelule");
//            Categories categories3 = new Categories(id12, "sirop", "sirop");
            Categories categories1 = new Categories(id10, "comprime");
            Categories categories2 = new Categories(id11, "gelule");
            Categories categories3 = new Categories(id12, "sirop");

//            Typechirurgie typechirurgie1 = new Typechirurgie(id10,"chirugie dentaire", "bouche");
//            Typechirurgie typechirurgie2 = new Typechirurgie(id11,"chirugie plastique", "esthetique");
//            Typechirurgie typechirurgie3 = new Typechirurgie(id12,"occulaire", "yeux");
            Typechirurgie typechirurgie1 = new Typechirurgie(id10,"chirugie dentaire");
            Typechirurgie typechirurgie2 = new Typechirurgie(id11,"chirugie plastique");
            Typechirurgie typechirurgie3 = new Typechirurgie(id12,"occulaire");



            //TODO doit changer la date
//            Ordonnance ordonnance1 = new Ordonnance(id10, "ne pas manger", "medicaments", date1, v0);
//            Ordonnance ordonnance2 = new Ordonnance(id11, "ne pas boire", "chirurgie", date1, v0);
//            Ordonnance ordonnance3 = new Ordonnance(id12, "ne rien faire", "chirurgie", date1, v0);
//            Ordonnance ordonnance4 = new Ordonnance(id13, "ne rien faire", "medicaments", date1, v0);
//
//            Ordonnance ordonnance5 = new Ordonnance(id100, "prier", "medicaments", date1, v100);

            Ordonnance ordonnance1 = new Ordonnance(id10);
            Ordonnance ordonnance2 = new Ordonnance(id11);
            Ordonnance ordonnance3 = new Ordonnance(id12);
            Ordonnance ordonnance4 = new Ordonnance(id13);

            Ordonnance ordonnance5 = new Ordonnance(id100);

            Docteur docteur1 = new Docteur(id10,"Dr", "Evil");
            Docteur docteur2 = new Docteur(id11,"Dr", "House");
            Docteur docteur3 = new Docteur(id11,"Dr", "Green Thumb");

            Dossierpatient dossierpatient1 = new Dossierpatient(id10, "bob", "inette");
            Dossierpatient dossierpatient2 = new Dossierpatient(id11, "bob", "inette");
            Dossierpatient dossierpatient3 = new Dossierpatient(id12, "bob", "inette");

            Dossierpatient dossierpatient100 = new Dossierpatient(id100, "micheal", "jackson");

            ConsultationId consultationId1= new ConsultationId(id10,id10,date1);
            ConsultationId consultationId2= new ConsultationId(id11,id11,date2);
            ConsultationId consultationId3= new ConsultationId(id12,id12,date3);
            Consultation consultation1 = new Consultation(consultationId1,docteur1,dossierpatient1,"inflamation" );
            Consultation consultation2 = new Consultation(consultationId2,docteur2,dossierpatient2,"coupure" );
            Consultation consultation3 = new Consultation(consultationId3,docteur3,dossierpatient3,"fracture" );
            Consultation consultation100 = new Consultation(consultationId1,docteur3,dossierpatient3,"infection" );

            Set consultationSet = new HashSet();
            consultationSet.add(consultation1);
            consultationSet.add(consultation2);
            consultationSet.add(consultation3);
            consultationSet.add(consultation100);


            Chirurgie chirurgie1 = new Chirurgie(id10);
            Chirurgie chirurgie2 = new Chirurgie(id11);
            Chirurgie chirurgie3 = new Chirurgie(id12);

            OrdonnancechirurgieId ordonnancechirurgieId1= new OrdonnancechirurgieId(id10,id10);
            OrdonnancechirurgieId ordonnancechirurgieId2= new OrdonnancechirurgieId(id11,id11);
            OrdonnancechirurgieId ordonnancechirurgieId3= new OrdonnancechirurgieId(id11,id11);
            Ordonnancechirurgie ordonnancechirurgie1 = new Ordonnancechirurgie(ordonnancechirurgieId1,ordonnance1,chirurgie1);
            Ordonnancechirurgie ordonnancechirurgie2 = new Ordonnancechirurgie(ordonnancechirurgieId2,ordonnance2,chirurgie2);
            Ordonnancechirurgie ordonnancechirurgie3 = new Ordonnancechirurgie(ordonnancechirurgieId3,ordonnance3,chirurgie3);

            SpecialisationsalleId specialisationsalleId1= new SpecialisationsalleId(id10,id10);
            SpecialisationsalleId specialisationsalleId2= new SpecialisationsalleId(id11,id11);
            SpecialisationsalleId specialisationsalleId3= new SpecialisationsalleId(id12,id12);
            Specialisationsalle specialisationsalle1 = new Specialisationsalle(specialisationsalleId1,salle1,typechirurgie1);
            Specialisationsalle specialisationsalle2 = new Specialisationsalle(specialisationsalleId2,salle2,typechirurgie2);
            Specialisationsalle specialisationsalle3 = new Specialisationsalle(specialisationsalleId3,salle3,typechirurgie3);

            Medicament medicament1 = new Medicament(id10,"colax");
            Medicament medicament2 = new Medicament(id11,"flex");
            Medicament medicament3 = new Medicament(id10,"mirem");

            OrdonnancemedicamentsId ordonnancemedicamentsId1 = new OrdonnancemedicamentsId(id10,id10);
            OrdonnancemedicamentsId ordonnancemedicamentsId2 = new OrdonnancemedicamentsId(id11,id11);
            OrdonnancemedicamentsId ordonnancemedicamentsId3 = new OrdonnancemedicamentsId(id12,id12);
            Ordonnancemedicaments ordonnancemedicaments1 = new Ordonnancemedicaments(ordonnancemedicamentsId1,ordonnance1,medicament1);
            Ordonnancemedicaments ordonnancemedicaments2 = new Ordonnancemedicaments(ordonnancemedicamentsId2,ordonnance2,medicament2);
            Ordonnancemedicaments ordonnancemedicaments3 = new Ordonnancemedicaments(ordonnancemedicamentsId3,ordonnance3,medicament3);





        } finally {
            session.close();
        }
    }
}
