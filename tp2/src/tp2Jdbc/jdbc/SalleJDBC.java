/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2Jdbc.jdbc;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zied Zaier < Zaier.Zied at uqam.ca>
 */
public class SalleJDBC {



    static Session session = null;
    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal idsalle, String nom ) throws SQLException {

        sql = "insert into SALLE values (?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idsalle);
        ps.setString(2, nom);
        ps.executeUpdate();
    }

    public static void update(Connection conn, BigDecimal idsalle, String nom ) throws SQLException{
        sql = "update salle set nom = ? where IDSALLE= ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(2,idsalle);
        ps.setString(1, nom);
        ps.executeUpdate();

    }

    public static void delete(Connection conn, BigDecimal idsalle ) throws SQLException{
        sql = "delete from salle where IDSALLE = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idsalle);
        ps.executeUpdate();

    }

    public static void printAll(ResultSet rs) throws SQLException{
        System.out.print("---idsalle------nom---\n");
        while(rs.next()){
            //Retrouver  par le nom de la colonne
            int id  = rs.getInt(1);
            String string1 = rs.getString(2);

            //Afficher les valeurs

            System.out.print("   ");
            System.out.print(id);
            System.out.print("         ");
            System.out.print(string1);
            System.out.print("          ");
            System.out.print("\n\n");
        }

    }



}
