package tp2Jdbc.jdbc;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesJDBC {

    static Session session = null;
    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal idcategorie, String nom, String description ) throws SQLException {

        sql = "insert into CATEGORIES values (?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idcategorie);
        ps.setString(2, nom);
        ps.setString(3, description);
        ps.executeUpdate();
    }

    public static void update(Connection conn, BigDecimal idcategorie, String nom, String description ) throws SQLException{
        sql = "update CATEGORIES set nom = ?, description = ? where IDCATEGORIE=?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(3,idcategorie);
        ps.setString(1, nom);
        ps.setString(2, description);
        ps.executeUpdate();

    }

    public static void delete(Connection conn, BigDecimal idcategorie ) throws SQLException{
        sql = "delete from CATEGORIES where IDCATEGORIE = ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,idcategorie);
        ps.executeUpdate();

    }

    public static void printAll(ResultSet rs) throws SQLException{
        System.out.print("---idcategorie------nom------description\n");
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
