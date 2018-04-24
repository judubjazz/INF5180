package tp2Hibernate.dao;

import tp2Hibernate.entite.Chirurgie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChirurgieDAO {

    static Session session = null;

    public static void insert(Chirurgie c) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
//        session.close();

    }

    public static void update(Chirurgie c, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

//        c.setNom(name);
        session.update(c);
        tx.commit();
//        session.close();

    }

    public static void delete(Chirurgie c) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
//        session.close();

    }
}
