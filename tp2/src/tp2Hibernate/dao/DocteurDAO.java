package tp2Hibernate.dao;

import tp2Hibernate.entite.Docteur;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class DocteurDAO {

    static Session session = null;

    public static void insert(Docteur d) {
        session =HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(d);
        tx.commit();
//        session.close();

    }

    public static void update(Docteur d, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
//
//        d.setNom(name);
        session.update(d);
        tx.commit();
//        session.close();

    }

    public static void delete(Docteur d) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(d);
        tx.commit();
//        session.close();

    }
}
