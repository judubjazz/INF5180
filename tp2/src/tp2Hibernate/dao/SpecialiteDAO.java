package tp2Hibernate.dao;

import tp2Hibernate.entite.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class SpecialiteDAO {

    static Session session = null;

    public static void insert(Specialite s) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
//        session.close();

    }

    public static void update(Specialite s, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

        s.setDescription(name);;
        session.update(s);
        tx.commit();
//        session.close();

    }

    public static void delete(Specialite s) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
//        session.close();

    }
}
