package tp2Hibernate.dao;

import tp2Hibernate.entite.Specialisationsalle;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SpecialisationSalleDAO {

    static Session session = null;

    public static void insert(Specialisationsalle s) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
//        session.close();

    }

    public static void update(Specialisationsalle s, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

//        s.setNom(name);;
        session.update(s);
        tx.commit();
//        session.close();

    }

    public static void delete(Specialisationsalle s) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
//        session.close();

    }
}
