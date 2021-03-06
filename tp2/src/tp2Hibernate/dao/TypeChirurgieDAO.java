package tp2Hibernate.dao;

import tp2Hibernate.entite.Typechirurgie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeChirurgieDAO {

    static Session session = null;

    public static void insert(Typechirurgie tc) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(tc);
        tx.commit();
//        session.close();

    }

    public static void update(Typechirurgie tc, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

        tc.setNom(name);;
        session.update(tc);
        tx.commit();
//        session.close();

    }

    public static void delete(Typechirurgie tc) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(tc);
        tx.commit();
//        session.close();

    }
}
