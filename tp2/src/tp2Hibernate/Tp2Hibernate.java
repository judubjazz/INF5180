package tp2Hibernate;

import dao.*;
import entite.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class Tp2Hibernate {
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

    private static Date setDate(Calendar cal, int year,int month, int day){
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
            BigDecimal big10 = new BigDecimal(10);
            BigDecimal big11 = new BigDecimal(11);
            BigDecimal big12 = new BigDecimal(12);
            BigDecimal big13 = new BigDecimal(13);
            BigDecimal big14 = new BigDecimal(14);
            BigDecimal big15 = new BigDecimal(15);
            BigDecimal big16 = new BigDecimal(16);
            BigDecimal big17 = new BigDecimal(17);
            BigDecimal big18 = new BigDecimal(18);
            BigDecimal big19 = new BigDecimal(19);
            BigDecimal big100 = new BigDecimal(100);
            BigDecimal big0 = new BigDecimal(0);
            BigDecimal big1 = new BigDecimal(1);
            BigDecimal big2 = new BigDecimal(2);
            BigDecimal big3 = new BigDecimal(3);
            BigDecimal v100 = new BigDecimal(100);

            /**Set date**/
            Calendar cal = Calendar.getInstance();

            Date date1=setDate(cal,2014,10, 14);
            Date date2=setDate(cal,2015,11, 15);
            Date date3=setDate(cal,2016,11, 16);
            Date dateNaissance=setDate(cal,2000,1, 1);


//            Specialite(BigDecimal code, String titre, String description, Set docteurs
            Specialite specialite1 = new Specialite(big14,"Esthetique","Facial", new HashSet());
            Specialite specialite2 = new Specialite(big15,"Urgentiste","Accident",new HashSet());
            Specialite specialite3 = new Specialite(big16,"Opthamologiste","Chirurgie", new HashSet());


//            Salle(BigDecimal idsalle, String nom, Set specialisationsalles, Set chirurgies
            Salle salle1 = new Salle(big14, "wilfred", new HashSet(), new HashSet());
            Salle salle2 = new Salle(big15, "calixa", new HashSet(), new HashSet());
            Salle salle3 = new Salle(big16, "abraham", new HashSet(), new HashSet());


//            Categories(BigDecimal idcategorie, String nom, String description, Set medicaments
            Categories categories1 = new Categories(big14, "comprime", "comprime", new HashSet());
            Categories categories2 = new Categories(big15, "gelule", "gelule",new HashSet());
            Categories categories3 = new Categories(big16, "sirop", "sirop",new HashSet());


//            Typechirurgie(BigDecimal idtype, String nom, String description, Set chirurgies, Set specialisationsalle
            Typechirurgie typechirurgie1 = new Typechirurgie(big14,"chirugie dentaire", "bouche",new HashSet(),new HashSet());
            Typechirurgie typechirurgie2 = new Typechirurgie(big15,"chirugie plastique", "esthetique",new HashSet(),new HashSet());
            Typechirurgie typechirurgie3 = new Typechirurgie(big16,"occulaire", "yeux",new HashSet(),new HashSet());


//            Ordonnance(BigDecimal numord, String recommandations, String type, Date datec, BigDecimal nbrmedicaments, Set ordonnancemedicamentses, Set consultations, Set ordonnancechirurgies
            Ordonnance ordonnance1 = new Ordonnance(big14, "ne pas manger", "Médicaments", date1, big14,new HashSet(),new HashSet(),new HashSet());
            Ordonnance ordonnance2 = new Ordonnance(big15, "ne pas boire", "Chirurgie", date2, big15,new HashSet(),new HashSet(),new HashSet());
            Ordonnance ordonnance3 = new Ordonnance(big16, "ne rien faire", "Chirurgie", date3, big16,new HashSet(),new HashSet(),new HashSet());


//            BigDecimal matricule, Specialite specialite, String nomm, String prenomm, String ville, String adresse, String niveau, BigDecimal nbrpatients, BigDecimal nbrmoyenmedicaments, Set consultations, Set dossierpatients
            Docteur docteur1 = new Docteur(big14,specialite1, "Dr", "House","NY", "10 dix","Étudiant",big14,new HashSet(), new HashSet() );
            Docteur docteur2 = new Docteur(big15,specialite2, "Dr", "Evil","NY", "11 onze","Interne",big15,new HashSet(), new HashSet());
            Docteur docteur3 = new Docteur(big16,specialite3, "Dr", "Green Thumb","NY", "12 douze","Docteur",big16,new HashSet(), new HashSet());

//            public Dossierpatient(BigDecimal numdos, Docteur docteur, String nomp, String prenomp, String sexe, BigDecimal numas, Date datenaiss, Date datec, BigDecimal nbrconsultation, Set consultations)
            Dossierpatient dossierpatient1 = new Dossierpatient(big14,docteur1, "bob", "inette", "M", big14,dateNaissance,date1,big14,new HashSet());
            Dossierpatient dossierpatient2 = new Dossierpatient(big15,docteur2, "guy", "lafleur", "M", big15,dateNaissance,date2,big15,new HashSet());
            Dossierpatient dossierpatient3 = new Dossierpatient(big16,docteur3, "jojo", "savard", "F", big16,dateNaissance,date3,big16,new HashSet());


            ConsultationId consultationId1= new ConsultationId(big14,big14,date1);
            ConsultationId consultationId2= new ConsultationId(big15,big15,date2);
            ConsultationId consultationId3= new ConsultationId(big16,big16,date3);
//                      (ConsultationId id, Ordonnance ordonnance, Docteur docteur, Dossierpatient dossierpatient, String diagnostic)
            Consultation consultation1 = new Consultation(consultationId1,ordonnance1,docteur1,dossierpatient1,"inflamation" );
            Consultation consultation2 = new Consultation(consultationId2,ordonnance2,docteur2,dossierpatient2,"coupure" );
            Consultation consultation3 = new Consultation(consultationId3,ordonnance3,docteur3,dossierpatient3,"fracture" );
            Consultation consultation100 = new Consultation(consultationId1,ordonnance3,docteur3,dossierpatient3,"infection" );



//            Chirurgie(BigDecimal idchir, Salle salle, Typechirurgie typechirurgie, Date datechirurgie, BigDecimal heuredebut, BigDecimal heurefin, Set ordonnancechirurgies)
            Chirurgie chirurgie1 = new Chirurgie(big14,salle1,typechirurgie1,date1,big14,big15,new HashSet());
            Chirurgie chirurgie2 = new Chirurgie(big15,salle2,typechirurgie2,date2,big16,big17,new HashSet());
            Chirurgie chirurgie3 = new Chirurgie(big16,salle3,typechirurgie3,date3,big18,big19,new HashSet());
//            Chirurgie chirurgie3 = new Chirurgie(big12);

            OrdonnancechirurgieId ordonnancechirurgieId1= new OrdonnancechirurgieId(big14,big14);
            OrdonnancechirurgieId ordonnancechirurgieId2= new OrdonnancechirurgieId(big15,big15);
            OrdonnancechirurgieId ordonnancechirurgieId3= new OrdonnancechirurgieId(big16,big16);
//            Ordonnancechirurgie(OrdonnancechirurgieId id, Ordonnance ordonnance, Chirurgie chirurgie, BigDecimal rang)
            Ordonnancechirurgie ordonnancechirurgie1 = new Ordonnancechirurgie(ordonnancechirurgieId1,ordonnance1,chirurgie1,big14);
            Ordonnancechirurgie ordonnancechirurgie2 = new Ordonnancechirurgie(ordonnancechirurgieId2,ordonnance2,chirurgie2,big15);
            Ordonnancechirurgie ordonnancechirurgie3 = new Ordonnancechirurgie(ordonnancechirurgieId3,ordonnance3,chirurgie3,big16);


            SpecialisationsalleId specialisationsalleId1= new SpecialisationsalleId(big14,big14);
            SpecialisationsalleId specialisationsalleId2= new SpecialisationsalleId(big15,big15);
            SpecialisationsalleId specialisationsalleId3= new SpecialisationsalleId(big16,big16);
//            Specialisationsalle(SpecialisationsalleId id, Salle salle, Typechirurgie typechirurgie, Date datec
            Specialisationsalle specialisationsalle1 = new Specialisationsalle(specialisationsalleId1,salle1,typechirurgie1,date1);
            Specialisationsalle specialisationsalle2 = new Specialisationsalle(specialisationsalleId2,salle2,typechirurgie2,date2);
            Specialisationsalle specialisationsalle3 = new Specialisationsalle(specialisationsalleId3,salle3,typechirurgie3,date3);


//            Medicament(BigDecimal idmed, Categories categories, String nommed, BigDecimal prix, Set ordonnancemedicaments
            Medicament medicament1 = new Medicament(big14,categories1,"colax",big16,new HashSet());
            Medicament medicament2 = new Medicament(big15,categories2,"flex",big15,new HashSet());
            Medicament medicament3 = new Medicament(big16,categories3,"mirem", big14, new HashSet());


            OrdonnancemedicamentsId ordonnancemedicamentsId1 = new OrdonnancemedicamentsId(big14,big14);
            OrdonnancemedicamentsId ordonnancemedicamentsId2 = new OrdonnancemedicamentsId(big15,big15);
            OrdonnancemedicamentsId ordonnancemedicamentsId3 = new OrdonnancemedicamentsId(big16,big16);
//            Ordonnancemedicaments(OrdonnancemedicamentsId id, Ordonnance ordonnance, Medicament medicament, BigDecimal nbboites
            Ordonnancemedicaments ordonnancemedicaments1 = new Ordonnancemedicaments(ordonnancemedicamentsId1,ordonnance1,medicament1,big14);
            Ordonnancemedicaments ordonnancemedicaments2 = new Ordonnancemedicaments(ordonnancemedicamentsId2,ordonnance2,medicament2,big15);
            Ordonnancemedicaments ordonnancemedicaments3 = new Ordonnancemedicaments(ordonnancemedicamentsId3,ordonnance3,medicament3,big16);


/**SET CREATION**/
//            Set <Docteur> docteurSet = new HashSet<>();
//            docteurSet.add(docteur1);
//            docteurSet.add(docteur2);
//            docteurSet.add(docteur3);
//
//            specialite1.setDocteurs(docteurSet);
//            specialite2.setDocteurs(docteurSet);
//            specialite3.setDocteurs(docteurSet);
//
//
//            Set <Specialisationsalle> specialisationSalleSet = new HashSet<>();
//            specialisationSalleSet.add(specialisationsalle1);
//            specialisationSalleSet.add(specialisationsalle2);
//            specialisationSalleSet.add(specialisationsalle3);
//
//            typechirurgie1.setSpecialisationsalles(specialisationSalleSet);
//            typechirurgie2.setSpecialisationsalles(specialisationSalleSet);
//            typechirurgie3.setSpecialisationsalles(specialisationSalleSet);
//
//            salle1.setSpecialisationsalles(specialisationSalleSet);
//            salle2.setSpecialisationsalles(specialisationSalleSet);
//            salle3.setSpecialisationsalles(specialisationSalleSet);
//
//
//            Set <Dossierpatient> dossierPatientSet = new HashSet<>();
//            dossierPatientSet.add(dossierpatient1);
//            dossierPatientSet.add(dossierpatient2);
//            dossierPatientSet.add(dossierpatient3);
//
//            docteur1.setDossierpatients(dossierPatientSet);
//            docteur2.setDossierpatients(dossierPatientSet);
//            docteur3.setDossierpatients(dossierPatientSet);
//
//
//            Set <Consultation> consultationSet = new HashSet<>();
//            consultationSet.add(consultation1);
//            consultationSet.add(consultation2);
//            consultationSet.add(consultation3);
//            consultationSet.add(consultation100);
//
//            dossierpatient1.setConsultations(consultationSet);
//            dossierpatient2.setConsultations(consultationSet);
//            dossierpatient3.setConsultations(consultationSet);
//
//            ordonnance1.setConsultations(consultationSet);
//            ordonnance2.setConsultations(consultationSet);
//            ordonnance3.setConsultations(consultationSet);
//            ordonnance4.setConsultations(consultationSet);
//
//            docteur1.setConsultations(consultationSet);
//            docteur2.setConsultations(consultationSet);
//            docteur3.setConsultations(consultationSet);
//
//            Set <Ordonnancemedicaments> ordonnanceMedicamentSet1 = new HashSet<>();
//            Set ordonnanceMedicamentSet2 = new HashSet<Ordonnancemedicaments>();
//            Set ordonnanceMedicamentSet3 = new HashSet<Ordonnancemedicaments>();
//            ordonnanceMedicamentSet1.add(ordonnancemedicaments1);
//            ordonnanceMedicamentSet1.add(ordonnancemedicaments2);
//            ordonnanceMedicamentSet1.add(ordonnancemedicaments3);
//
//            ordonnance1.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//            ordonnance2.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//            ordonnance3.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//            ordonnance4.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//
//            medicament1.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//            medicament2.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//            medicament3.setOrdonnancemedicamentses(ordonnanceMedicamentSet1);
//
//
//
//            Set <Medicament> medicamentSet1 = new HashSet<>();
//            Set medicamentSet2 = new HashSet<Medicament>();
//            Set medicamentSet3 = new HashSet<Medicament>();
//            medicamentSet1.add(medicament1);
//            medicamentSet1.add(medicament2);
//            medicamentSet1.add(medicament3);
//
//            categories1.setMedicaments(medicamentSet1);
//            categories2.setMedicaments(medicamentSet1);
//            categories3.setMedicaments(medicamentSet1);
//
//            Set <Chirurgie> chirurgiesSet = new HashSet<>();
//            chirurgiesSet.add(chirurgie1);
//            chirurgiesSet.add(chirurgie2);
//            chirurgiesSet.add(chirurgie3);
//
//            typechirurgie1.setChirurgies(chirurgiesSet);
//            typechirurgie2.setChirurgies(chirurgiesSet);
//            typechirurgie3.setChirurgies(chirurgiesSet);
//
//            salle1.setChirurgies(chirurgiesSet);
//            salle2.setChirurgies(chirurgiesSet);
//            salle3.setChirurgies(chirurgiesSet);
//
//
//            Set <Ordonnancechirurgie> ordonnanceChirurgieSet1 = new HashSet<>();
//            Set ordonnanceChirurgieSet2 = new HashSet<Ordonnancechirurgie>();
//            Set ordonnanceChirurgieSet3 = new HashSet<Ordonnancechirurgie>();
//            ordonnanceChirurgieSet1.add(ordonnancechirurgie1);
//            ordonnanceChirurgieSet1.add(ordonnancechirurgie2);
//            ordonnanceChirurgieSet1.add(ordonnancechirurgie3);
//
//            chirurgie1.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//            chirurgie2.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//            chirurgie3.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//
//            ordonnance1.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//            ordonnance2.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//            ordonnance3.setOrdonnancechirurgies(ordonnanceChirurgieSet1);
//            ordonnance4.setOrdonnancechirurgies(ordonnanceChirurgieSet1);


/**INSERTION**/

            SpecialiteDAO.insert(specialite1);
            SpecialiteDAO.insert(specialite2);
            SpecialiteDAO.insert(specialite3);

            SalleDAO.insert(salle1);
            SalleDAO.insert(salle2);
            SalleDAO.insert(salle3);

            CategoriesDAO.insert(categories1);
            CategoriesDAO.insert(categories2);
            CategoriesDAO.insert(categories3);

            TypeChirurgieDAO.insert(typechirurgie1);
            TypeChirurgieDAO.insert(typechirurgie2);
            TypeChirurgieDAO.insert(typechirurgie3);

            OrdonnanceDAO.insert(ordonnance1);
            OrdonnanceDAO.insert(ordonnance2);
            OrdonnanceDAO.insert(ordonnance3);

            DocteurDAO.insert(docteur1);
            DocteurDAO.insert(docteur2);
            DocteurDAO.insert(docteur3);

            DossierPatientDAO.insert(dossierpatient1);
            DossierPatientDAO.insert(dossierpatient2);
            DossierPatientDAO.insert(dossierpatient3);

            ConsultationDAO.insert(consultation1);
            ConsultationDAO.insert(consultation2);
            ConsultationDAO.insert(consultation3);

            ChirurgieDAO.insert(chirurgie1);
            ChirurgieDAO.insert(chirurgie2);
            ChirurgieDAO.insert(chirurgie3);

            OrdonnanceChirurgieDAO.insert(ordonnancechirurgie1);
            OrdonnanceChirurgieDAO.insert(ordonnancechirurgie2);
            OrdonnanceChirurgieDAO.insert(ordonnancechirurgie3);

            SpecialisationSalleDAO.insert(specialisationsalle1);
            SpecialisationSalleDAO.insert(specialisationsalle2);
            SpecialisationSalleDAO.insert(specialisationsalle3);

            MedicamentDAO.insert(medicament1);
            MedicamentDAO.insert(medicament2);
            MedicamentDAO.insert(medicament3);

            OrdonnanceMedicamentsDAO.insert(ordonnancemedicaments1);
            OrdonnanceMedicamentsDAO.insert(ordonnancemedicaments2);
            OrdonnanceMedicamentsDAO.insert(ordonnancemedicaments3);


        } finally {
            session.close();
        }
    }
}
