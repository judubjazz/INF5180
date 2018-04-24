package tp2Hibernate.dao;

import tp2Hibernate.entite.Ordonnancechirurgie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdonnanceChirurgieDAO {

    static Session session = null;

    public static void insert(Ordonnancechirurgie oc) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(oc);
        tx.commit();
//        session.close();

    }

    public static void update(Ordonnancechirurgie oc, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

//        oc.setNom(name);
        session.update(oc);
        tx.commit();
//        session.close();

    }

    public static void delete(Ordonnancechirurgie oc) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(oc);
        tx.commit();
//        session.close();

    }
}
