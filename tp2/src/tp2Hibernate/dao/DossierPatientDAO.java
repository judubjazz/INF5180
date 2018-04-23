package tp2Hibernate.dao;

import tp2Hibernate.entite.Dossierpatient;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DossierPatientDAO {

    static Session session = null;

    public static void insert(Dossierpatient dp) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(dp);
        tx.commit();
//        session.close();

    }

    public static void update(Dossierpatient dp, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();

//        dp.setNom(name);
        session.update(dp);
        tx.commit();
//        session.close();

    }

    public static void delete(Dossierpatient dp) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(dp);
        tx.commit();
//        session.close();

    }
}
