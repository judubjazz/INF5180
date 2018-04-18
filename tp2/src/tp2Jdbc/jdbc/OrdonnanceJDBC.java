package tp2Jdbc.jdbc;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;


public class OrdonnanceJDBC {

    static Session session = null;
    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal numord, String recommandations, String type, Date date, BigDecimal nbrMedicaments ) throws SQLException {

        sql = "insert into ORDONNANCE values (?, ?, ?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,numord);
        ps.setString(2, recommandations);
        ps.setString(3, type);
        ps.setDate(4,date);
        ps.setBigDecimal(5,nbrMedicaments);
        ps.executeUpdate();
    }

    public static void update(Connection conn, BigDecimal numord, String recommandations, String type, Date date, BigDecimal nbrMedicaments ) throws SQLException{
        sql = "update ORDONNANCE set RECOMMANDATIONS = ?, TYPE = ?, DATEC = ?, NBRMEDICAMENTS=? where NUMORD=?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(5,numord);
        ps.setString(1, recommandations);
        ps.setString(2, type);
        ps.setDate(3,date);
        ps.setBigDecimal(4,nbrMedicaments);
        ps.executeUpdate();

    }

    public static void delete(Connection conn, BigDecimal numord ) throws SQLException{
        sql = "delete from ORDONNANCE where NUMORD = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,numord);
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
//    }

}
