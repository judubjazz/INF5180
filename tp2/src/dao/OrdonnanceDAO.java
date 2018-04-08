package dao;

import entite.Ordonnance;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdonnanceDAO {

    static Session session = null;

    public static void insert(Ordonnance o) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
//        session.close();

    }

    public static void update(Ordonnance o, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();

//        o.setNom(name);
        session.update(o);
        tx.commit();
//        session.close();

    }

    public static void delete(Ordonnance o) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
//        session.close();

    }
}
