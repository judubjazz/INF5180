/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2Hibernate.dao;

import tp2Hibernate.entite.Salle;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 * @author Zied Zaier < Zaier.Zied at uqam.ca>
 */
public class SalleDAO {


    static Session session = null;

    public static void insert(Salle s) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
//        session.close();

    }

    public static void update(Salle s, String name) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();

        s.setNom(name);;
        session.update(s);
        tx.commit();
//        session.close();

    }

    public static void delete(Salle s) {
        session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
//        session.close();

    }
}
