/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import dao.HibernateUtil;
import dao.SalleDAO;
import entite.Salle;
import java.math.BigDecimal;
/**
 *
 * @author Zied Zaier < Zaier.Zied at uqam.ca>
 */
public class tp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Salle salle1=new Salle(new BigDecimal(3),"test");

        SalleDAO.insert(salle1);

        HibernateUtil.closeSession();

//        Salle salle3=new Salle(3,"calixa");
//        Salle salle4=new Salle(4,"calixa");
//
//        SalleDAO.delete(salle3);
    }
    
}
