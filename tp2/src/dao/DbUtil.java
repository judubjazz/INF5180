package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;

public class DbUtil {
    static Session session = null;

    public static void dropTable(){
        Query q = new Query();
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        tx.commit();
    }


}
