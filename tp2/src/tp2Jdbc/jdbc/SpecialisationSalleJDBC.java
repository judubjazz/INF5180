package tp2Jdbc.jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class SpecialisationSalleJDBC {
    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal idtype, BigDecimal idsalle, Date datec ) throws SQLException {

        sql = "insert into SPECIALISATIONSALLE values (?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idtype);
        ps.setBigDecimal(2, idsalle);
        ps.setDate(3, datec);
        ps.executeUpdate();
    }

//    public static void update(Connection conn, BigDecimal code, String titre, String description ) throws SQLException{
//        sql = "update SPECIALISATIONSALLE set titre = ?, description = ? where CODE=?";
//        ps =conn.prepareStatement(sql);
//        ps.setBigDecimal(3,code);
//        ps.setString(1, titre);
//        ps.setString(2, description);
//        ps.executeUpdate();
//
//    }

    public static void delete(Connection conn, BigDecimal idtype, BigDecimal idsalle ) throws SQLException{
        sql = "delete from SPECIALISATIONSALLE where IDTYPE = ? and IDSALLE = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idtype);
        ps.setBigDecimal(2,idsalle);
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
