package tp2Jdbc.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocteurJDBC {

    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal matricule, String nom, String prenom, BigDecimal specialite, String ville, String adresse, String niveau, BigDecimal nbrPatient ) throws SQLException {

        sql = "insert into DOCTEUR values (?, ?, ?,?, ?, ?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,matricule);
        ps.setString(2, nom);
        ps.setString(3, prenom);
        ps.setBigDecimal(4,specialite);
        ps.setString(5, ville);
        ps.setString(6, adresse);
        ps.setString(7, niveau);
        ps.setBigDecimal(8,nbrPatient);
        ps.executeUpdate();
    }
//
//    public static void update(Connection conn, BigDecimal matricule, String nom, String prenom, BigDecimal specialite, String ville, String adresse, String niveau, BigDecimal nbrPatient ) throws SQLException{
//        sql = "update DOCTEUR set nom = ?, description = ? where IDTYPE=?";
//        ps =conn.prepareStatement(sql);
//        ps.setBigDecimal(3,idtype);
//        ps.setString(1, nom);
//        ps.setString(2, description);
//        ps.executeUpdate();
//
//    }

    public static void delete(Connection conn, BigDecimal matricule ) throws SQLException{
        sql = "delete from DOCTEUR where MATRICULE = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,matricule);
        ps.executeUpdate();

    }

//    public static void printAll(ResultSet rs) throws SQLException{
//        System.out.print("---code------titre------description\n");
//        while(rs.next()){
//            //Retrouver  par le nom de la colonne
//            int id  = rs.getInt(1);
//            String string1 = rs.getString(2);
//            String string2 = rs.getString(3);
//
//            //Afficher les valeurs
//
//            System.out.print("   ");
//            System.out.print(id);
//            System.out.print("         ");
//            System.out.print(string1);
//            System.out.print("         ");
//            System.out.print(string2);
//            System.out.print("          ");
//            System.out.print("\n\n");
//        }
//
//    }
}
