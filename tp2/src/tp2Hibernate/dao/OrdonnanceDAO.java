package tp2Hibernate.dao;

import tp2Hibernate.entite.Ordonnance;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdonnanceDAO {

    static Session session = null;

    public static void insert(Ordonnance o) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
//        session.close();

    }

    public static void update(Ordonnance o, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

//        o.setNom(name);
        session.update(o);
        tx.commit();
//        session.close();

    }

    public static void delete(Ordonnance o) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
//        session.close();

    }
}
