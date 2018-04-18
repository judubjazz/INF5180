package tp2Jdbc.jdbc;


import java.math.BigDecimal;
import java.sql.*;

public class ChirurgieJDBC {

    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal idchir, BigDecimal idtype, BigDecimal idsalle, Date dateChirurgie, BigDecimal hd , BigDecimal hf) throws SQLException {

        sql = "insert into CHIRURGIE values (?, ?, ?, ?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idchir);
        ps.setBigDecimal(2, idtype);
        ps.setBigDecimal(3, idsalle);
        ps.setDate(4,dateChirurgie);
        ps.setBigDecimal(5,hd);
        ps.setBigDecimal(6,hf);
        ps.executeUpdate();
    }
//
//    public static void update(Connection conn, BigDecimal numord, String recommandations, String type, Date date, BigDecimal nbrMedicaments ) throws SQLException{
//        sql = "update CHIRURGIE set RECOMMANDATIONS = ?, TYPE = ?, DATEC = ?, NBRMEDICAMENTS=? where NUMORD=?";
//        ps =conn.prepareStatement(sql);
//        ps.setBigDecimal(5,numord);
//        ps.setString(1, recommandations);
//        ps.setString(2, type);
//        ps.setDate(3,date);
//        ps.setBigDecimal(4,nbrMedicaments);
//        ps.executeUpdate();
//
//    }

    public static void delete(Connection conn, BigDecimal idchir ) throws SQLException{
        sql = "delete from CHIRURGIE where IDCHIR = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idchir);
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
