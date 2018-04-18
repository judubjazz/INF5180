package tp2Jdbc.jdbcUtils;

import java.math.BigDecimal;
import java.sql.*;
import tp2Jdbc.jdbc.*;

public class JdbcUtils {
    public static void populateTables(Connection conn) throws SQLException{
        //Insertion
        SpecialiteJDBC.insert(conn,new BigDecimal(13),"esthetique", "facial" );
        SpecialiteJDBC.insert(conn,new BigDecimal(14),"urgentiste", "accident" );
        SpecialiteJDBC.insert(conn,new BigDecimal(15),"ophtamologiste", "chirurgie" );

        SalleJDBC.insert(conn,new BigDecimal(13),"babylon");
        SalleJDBC.insert(conn,new BigDecimal(14),"jerusalem");
        SalleJDBC.insert(conn,new BigDecimal(15),"istanbul");

        CategoriesJDBC.insert(conn, new BigDecimal(13), "comprimé", "comprimé");
        CategoriesJDBC.insert(conn, new BigDecimal(14), "comprimé", "comprimé");
        CategoriesJDBC.insert(conn, new BigDecimal(15), "comprimé", "comprimé");

        TypeChirurgieJDBC.insert(conn, new BigDecimal(13), "chirurgie dentaire", "bouche");
        TypeChirurgieJDBC.insert(conn, new BigDecimal(14), "chirurgie plastique", "yeux");
        TypeChirurgieJDBC.insert(conn, new BigDecimal(15), "chirurgie dentaire", "bouche");

        OrdonnanceJDBC.insert(conn, new BigDecimal(13), "prier", "Médicaments", new Date(2013-10-13),new BigDecimal(13));
        OrdonnanceJDBC.insert(conn, new BigDecimal(14), "prier", "Médicaments", new Date(2014-10-14),new BigDecimal(14));
        OrdonnanceJDBC.insert(conn, new BigDecimal(15), "prier", "Médicaments", new Date(2015-10-15),new BigDecimal(15));

        DocteurJDBC.insert(conn, new BigDecimal(13), "smith", "john", new BigDecimal(13), "babylon", "1234", "Étudiant", new BigDecimal(13));
        DocteurJDBC.insert(conn, new BigDecimal(14), "smith", "john", new BigDecimal(14), "babylon", "1234", "Interne", new BigDecimal(14));
        DocteurJDBC.insert(conn, new BigDecimal(15), "smith", "john", new BigDecimal(15), "babylon", "1234", "Docteur", new BigDecimal(15));

        DossierPatientJDBC.insert(conn, new BigDecimal(13), "smith", "john", "M", new BigDecimal(13), new Date(2013-10-13), new Date(2013-10-13), new BigDecimal(13), new BigDecimal(13) );
        DossierPatientJDBC.insert(conn, new BigDecimal(14), "smith", "john", "M", new BigDecimal(14), new Date(2013-10-13), new Date(2013-10-13), new BigDecimal(14), new BigDecimal(14) );
        DossierPatientJDBC.insert(conn, new BigDecimal(15), "smith", "john", "M", new BigDecimal(15), new Date(2013-10-13), new Date(2013-10-13), new BigDecimal(15), new BigDecimal(15) );

        ConsultationJDBC.insert(conn, new BigDecimal(13), new BigDecimal(13),  new Date(2013-10-13),"mort certaine", new BigDecimal(13));
        ConsultationJDBC.insert(conn, new BigDecimal(14), new BigDecimal(14),  new Date(2014-10-14),"mort certaine", new BigDecimal(14));
        ConsultationJDBC.insert(conn, new BigDecimal(15), new BigDecimal(15),  new Date(2015-10-15),"mort certaine", new BigDecimal(15));

        ChirurgieJDBC.insert(conn, new BigDecimal(13), new BigDecimal(13),  new BigDecimal(13), new Date(2013-10-13), new BigDecimal(13), new BigDecimal(13));
        ChirurgieJDBC.insert(conn, new BigDecimal(14), new BigDecimal(14),  new BigDecimal(14), new Date(2014-10-14), new BigDecimal(14), new BigDecimal(14));
        ChirurgieJDBC.insert(conn, new BigDecimal(15), new BigDecimal(15),  new BigDecimal(15), new Date(2015-10-15), new BigDecimal(15), new BigDecimal(15));

        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(13), new BigDecimal(13), new BigDecimal(13));
        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(14), new BigDecimal(14), new BigDecimal(14));
        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(15), new BigDecimal(15), new BigDecimal(15));

        MedicamentJDBC.insert( conn, new BigDecimal(13), "gumbaloun", new BigDecimal(13), new BigDecimal(13));
        MedicamentJDBC.insert( conn, new BigDecimal(14), "ratatat", new BigDecimal(14), new BigDecimal(14));
        MedicamentJDBC.insert( conn, new BigDecimal(15), "cortisone", new BigDecimal(15), new BigDecimal(15));
    }

    public static void printIntStringStringInt(ResultSet rs, String header) throws SQLException{
        System.out.print(header);
        System.out.print("\n\n");
        while(rs.next()){
                //Retrouver  par le nom de la colonne
                int id  = rs.getInt(1);
                String nomM = rs.getString(2);
                String prenomM = rs.getString(3);
                int nbr = rs.getInt(4);

                //Afficher les valeurs

                System.out.print("   ");
                System.out.print(id);
                System.out.print("         ");
                System.out.print(nomM);
                System.out.print("         ");
                System.out.print(prenomM);
                System.out.print("          ");
                System.out.print(nbr);
                System.out.print("\n\n");
            }
    }

    public static void printStringInt(ResultSet rs, String header) throws SQLException{
        System.out.print(header);
        System.out.print("\n\n");
        while(rs.next()){
            String s = rs.getString(1);
            int nbr = rs.getInt(2);

            //Afficher les valeurs

            System.out.print("   ");
            System.out.print(s);
            System.out.print("         ");
            System.out.print(nbr);
            System.out.print("\n\n");
        }
    }

    public static void printIntBigdecimal(ResultSet rs, String header) throws SQLException{
        System.out.print(header);
        System.out.print("\n\n");
        while(rs.next()){ ;
            int nbr = rs.getInt(1);
            BigDecimal big = rs.getBigDecimal(2);

            //Afficher les valeurs

            System.out.print("   ");
            System.out.print(nbr);
            System.out.print("         ");
            System.out.print(big);
            System.out.print("\n\n");
        }
    }
}
