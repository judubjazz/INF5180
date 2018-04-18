package tp2Jdbc.jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class DossierPatientJDBC {

    static PreparedStatement ps = null;
    static String sql = null;
    static ResultSet rs = null;

    public static void insert(Connection conn, BigDecimal numdos, String nom, String prenom, String sexe, BigDecimal numAs, Date dateNaiss, Date datec, BigDecimal matricule, BigDecimal nbrConsultation

                              ) throws SQLException {

        sql = "insert into DOSSIERPATIENT values (?, ?, ?,?, ?, ?, ?, ?, ?)";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,numdos);
        ps.setString(2, nom);
        ps.setString(3, prenom);
        ps.setString(4,sexe);
        ps.setBigDecimal(5, numAs);
        ps.setDate(6, dateNaiss);
        ps.setDate(7, datec);
        ps.setBigDecimal(8,matricule);
        ps.setBigDecimal(9, nbrConsultation);
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

    public static void delete(Connection conn, BigDecimal numdos ) throws SQLException{
        sql = "delete from DOSSIERPATIENT where NUMDOS= ?";
        ps =conn.prepareStatement(sql);
        ps.setBigDecimal(1,numdos);
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
