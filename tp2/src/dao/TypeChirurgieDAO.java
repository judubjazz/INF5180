package dao;

import entite.Typechirurgie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeChirurgieDAO {

    static Session session = null;

    public static void insert(Typechirurgie tc) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(tc);
        tx.commit();
//        session.close();

    }

    public static void update(Typechirurgie tc, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();

        tc.setNom(name);;
        session.update(tc);
        tx.commit();
//        session.close();

    }

    public static void delete(Typechirurgie tc) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(tc);
        tx.commit();
//        session.close();

    }
}
