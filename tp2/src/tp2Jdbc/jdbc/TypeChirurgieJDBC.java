package tp2Jdbc.jdbc;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeChirurgieJDBC {

    static Session session = null;
    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal idtype, String nom, String description ) throws SQLException {

        sql = "insert into TYPECHIRURGIE values (?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idtype);
        ps.setString(2, nom);
        ps.setString(3, description);
        ps.executeUpdate();
    }

    public static void update(Connection conn, BigDecimal idtype, String nom, String description ) throws SQLException{
        sql = "update TYPECHIRURGIE set nom = ?, description = ? where IDTYPE=?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(3,idtype);
        ps.setString(1, nom);
        ps.setString(2, description);
        ps.executeUpdate();

    }

    public static void delete(Connection conn, BigDecimal idtype ) throws SQLException{
        sql = "delete from TYPECHIRURGIE where IDTYPE = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idtype);
        ps.executeUpdate();

    }

    public static void printAll(ResultSet rs) throws SQLException{
        System.out.print("---code------titre------description\n");
        while(rs.next()){
            //Retrouver  par le nom de la colonne
            int id  = rs.getInt(1);
            String string1 = rs.getString(2);
            String string2 = rs.getString(3);

            //Afficher les valeurs

            System.out.print("   ");
            System.out.print(id);
            System.out.print("         ");
            System.out.print(string1);
            System.out.print("         ");
            System.out.print(string2);
            System.out.print("          ");
            System.out.print("\n\n");
        }

    }
}
