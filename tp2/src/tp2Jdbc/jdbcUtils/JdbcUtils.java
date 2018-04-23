package tp2Jdbc.jdbcUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;

import tp2Jdbc.jdbc.*;

public class JdbcUtils {

    private static java.sql.Date setDate(Calendar cal, int year, int month, int day){
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return new java.sql.Date(cal.getTime().getTime());
    }

    public static void populateTables(Connection conn) throws SQLException{

        Calendar cal =Calendar.getInstance();
        Date date1 = setDate(cal,2010,10,10);
        Date date2 = setDate(cal,2011,11,11);
        Date date3 = setDate(cal,2012,12,12);
        Date date4 = setDate(cal,2013,13,13);
        //Insertion
        SpecialiteJDBC.insert(conn,new BigDecimal(10),"esthetique", "facial" );
        SpecialiteJDBC.insert(conn,new BigDecimal(11),"urgentiste", "accident" );
        SpecialiteJDBC.insert(conn,new BigDecimal(12),"ophtamologiste", "chirurgie" );
        SpecialiteJDBC.insert(conn,new BigDecimal(13),"chirurgiem", "facial" );
        SpecialiteJDBC.insert(conn,new BigDecimal(14),"pediatre", "accident" );
        SpecialiteJDBC.insert(conn,new BigDecimal(15),"psychologue", "chirurgie" );

        SalleJDBC.insert(conn,new BigDecimal(10),"wilfred");
        SalleJDBC.insert(conn,new BigDecimal(11),"calixa");
        SalleJDBC.insert(conn,new BigDecimal(12),"abraham");

        CategoriesJDBC.insert(conn, new BigDecimal(10), "comprimé", "comprimé");
        CategoriesJDBC.insert(conn, new BigDecimal(11), "comprimé", "gelule");
        CategoriesJDBC.insert(conn, new BigDecimal(12), "comprimé", "sirop");

        TypeChirurgieJDBC.insert(conn, new BigDecimal(10), "chirurgie dentaire", "bouche");
        TypeChirurgieJDBC.insert(conn, new BigDecimal(11), "chirurgie plastique", "yeux");
        TypeChirurgieJDBC.insert(conn, new BigDecimal(12), "chirurgie dentaire", "bouche");


        OrdonnanceJDBC.insert(conn, new BigDecimal(10), "rien manger", "Médicaments", date1,new BigDecimal(10));
        OrdonnanceJDBC.insert(conn, new BigDecimal(11), "rien boire", "Médicaments", date2,new BigDecimal(11));
        OrdonnanceJDBC.insert(conn, new BigDecimal(12), "rien faire", "Médicaments", date3,new BigDecimal(12));
        OrdonnanceJDBC.insert(conn, new BigDecimal(13), "prier", "Médicaments", date1,new BigDecimal(13));
        OrdonnanceJDBC.insert(conn, new BigDecimal(14), "rien manger", "Médicaments", date1,new BigDecimal(10));
        OrdonnanceJDBC.insert(conn, new BigDecimal(15), "rien boire", "Chirurgie", date2,new BigDecimal(11));
        OrdonnanceJDBC.insert(conn, new BigDecimal(16), "rien faire", "Chirurgie", date3,new BigDecimal(12));
        OrdonnanceJDBC.insert(conn, new BigDecimal(17), "prier", "Chirurgie", date1,new BigDecimal(13));

        DocteurJDBC.insert(conn, new BigDecimal(10), "House", "Dr", new BigDecimal(10), "babylon", "1234", "Étudiant", new BigDecimal(10));
        DocteurJDBC.insert(conn, new BigDecimal(11), "Evil", "Dr", new BigDecimal(11), "babylon", "1234", "Interne", new BigDecimal(11));
        DocteurJDBC.insert(conn, new BigDecimal(12), "Greenthumb", "Dr", new BigDecimal(12), "babylon", "1234", "Docteur", new BigDecimal(12));
        DocteurJDBC.insert(conn, new BigDecimal(13), "smith", "john", new BigDecimal(13), "babylon", "1234", "Étudiant", new BigDecimal(13));
        DocteurJDBC.insert(conn, new BigDecimal(14), "smith", "john", new BigDecimal(14), "babylon", "1234", "Interne", new BigDecimal(14));
        DocteurJDBC.insert(conn, new BigDecimal(15), "smith", "john", new BigDecimal(15), "babylon", "1234", "Docteur", new BigDecimal(15));

        DossierPatientJDBC.insert(conn, new BigDecimal(10), "lafleur", "guy", "M", new BigDecimal(10), date1, date1, new BigDecimal(10), new BigDecimal(10) );
        DossierPatientJDBC.insert(conn, new BigDecimal(11), "dryden", "ken", "M", new BigDecimal(11), date2, date2, new BigDecimal(11), new BigDecimal(11) );
        DossierPatientJDBC.insert(conn, new BigDecimal(12), "roy", "patrick", "M", new BigDecimal(12), date3, date3, new BigDecimal(12), new BigDecimal(12) );
        DossierPatientJDBC.insert(conn, new BigDecimal(13), "smith", "john", "M", new BigDecimal(13), date1, date1, new BigDecimal(10), new BigDecimal(13) );
        DossierPatientJDBC.insert(conn, new BigDecimal(14), "smith", "john", "M", new BigDecimal(14), date2, date2, new BigDecimal(11), new BigDecimal(14) );
        DossierPatientJDBC.insert(conn, new BigDecimal(15), "smith", "john", "M", new BigDecimal(15), date3, date3, new BigDecimal(12), new BigDecimal(15) );


        ConsultationJDBC.insert(conn, new BigDecimal(10), new BigDecimal(10),  date1,"urgent", new BigDecimal(10));
        ConsultationJDBC.insert(conn, new BigDecimal(10), new BigDecimal(11),  date2,"mort certaine", new BigDecimal(11));
        ConsultationJDBC.insert(conn, new BigDecimal(10), new BigDecimal(12),  date3,"mort certaine", new BigDecimal(12));
        ConsultationJDBC.insert(conn, new BigDecimal(11), new BigDecimal(13),  date4,"mort certaine", new BigDecimal(13));
        ConsultationJDBC.insert(conn, new BigDecimal(12), new BigDecimal(10),  date1,"urgent", new BigDecimal(14));
        ConsultationJDBC.insert(conn, new BigDecimal(13), new BigDecimal(11),  date2,"mort certaine", new BigDecimal(15));
        ConsultationJDBC.insert(conn, new BigDecimal(14), new BigDecimal(12),  date3,"mort certaine", new BigDecimal(16));
        ConsultationJDBC.insert(conn, new BigDecimal(14), new BigDecimal(13),  date4,"mort certaine", new BigDecimal(17));

        ChirurgieJDBC.insert(conn, new BigDecimal(15), new BigDecimal(10),  new BigDecimal(10), date1, new BigDecimal(13), new BigDecimal(13));
        ChirurgieJDBC.insert(conn, new BigDecimal(16), new BigDecimal(11),  new BigDecimal(11), date2, new BigDecimal(13), new BigDecimal(13));
        ChirurgieJDBC.insert(conn, new BigDecimal(17), new BigDecimal(12),  new BigDecimal(12), date3, new BigDecimal(14), new BigDecimal(14));


        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(15), new BigDecimal(15), new BigDecimal(15));
        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(16), new BigDecimal(16), new BigDecimal(16));
        OrdonnanceChirurgieJDBC.insert (conn, new BigDecimal(17), new BigDecimal(17), new BigDecimal(17));

        SpecialisationSalleJDBC.insert(conn, new BigDecimal(10), new BigDecimal(10), date1);
        SpecialisationSalleJDBC.insert(conn, new BigDecimal(11), new BigDecimal(11), date2);
        SpecialisationSalleJDBC.insert(conn, new BigDecimal(12), new BigDecimal(12), date3);

        MedicamentJDBC.insert( conn, new BigDecimal(10), "gumbaloun", new BigDecimal(10), new BigDecimal(12));
        MedicamentJDBC.insert( conn, new BigDecimal(11), "ratatat", new BigDecimal(11), new BigDecimal(11));
        MedicamentJDBC.insert( conn, new BigDecimal(12), "cortisone", new BigDecimal(12), new BigDecimal(10));

        OrdonnanceMedicamentsJDBC.insert(conn,new BigDecimal(10), new BigDecimal(10), new BigDecimal(10));
        OrdonnanceMedicamentsJDBC.insert(conn,new BigDecimal(11), new BigDecimal(10), new BigDecimal(10));
        OrdonnanceMedicamentsJDBC.insert(conn,new BigDecimal(12), new BigDecimal(10), new BigDecimal(10));
        OrdonnanceMedicamentsJDBC.insert(conn,new BigDecimal(13), new BigDecimal(10), new BigDecimal(10));
        OrdonnanceMedicamentsJDBC.insert(conn,new BigDecimal(14), new BigDecimal(10), new BigDecimal(10));
    }

    public static void printIntStringStringInt(ResultSet rs, String header) throws SQLException{
        System.out.print(header);
        System.out.print("\n");
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
        System.out.print("\n");
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
        System.out.print("\n");
        while(rs.next()){
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
