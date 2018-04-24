package tp2Hibernate.dao;

import tp2Hibernate.entite.Ordonnancemedicaments;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdonnanceMedicamentsDAO {

    static Session session = null;

    public static void insert(Ordonnancemedicaments om) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.save(om);
        tx.commit();
//        session.close();

    }

    public static void update(Ordonnancemedicaments om, String name) {
        session = tp2Hibernate.Tp2Hibernate.getSession();;

        Transaction tx = session.beginTransaction();

//        om.setMedicament(name);
        session.update(om);
        tx.commit();
//        session.close();

    }

    public static void delete(Ordonnancemedicaments om) {
        session = tp2Hibernate.Tp2Hibernate.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(om);
        tx.commit();
//        session.close();

    }
}
