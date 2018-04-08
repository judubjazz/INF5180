package dao;

import entite.Consultation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultationDAO {

    static Session session = null;

    public static void insert(Consultation c) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
//        session.close();

    }

    public static void update(Consultation c, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();

//        c.setNom(name);
        session.update(c);
        tx.commit();
//        session.close();

    }

    public static void delete(Consultation c) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
//        session.close();

    }
}
