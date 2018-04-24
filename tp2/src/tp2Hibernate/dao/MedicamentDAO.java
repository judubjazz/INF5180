package tp2Hibernate.dao;

import tp2Hibernate.entite.Medicament;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicamentDAO {

    static Session session = null;

    public static void insert(Medicament m) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
//        session.close();

    }

    public static void update(Medicament medicament, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();

//        medicament.setNom(name);
        session.update(medicament);
        tx.commit();
//        session.close();

    }

    public static void delete(Medicament m) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(m);
        tx.commit();
//        session.close();

    }
}
