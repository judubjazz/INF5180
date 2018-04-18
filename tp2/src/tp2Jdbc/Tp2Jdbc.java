package tp2Jdbc;//STEP 1. Importer les packages necessaires
import java.math.BigDecimal;
import java.sql.*;
import tp2Jdbc.jdbcUtils.*;

public class Tp2Jdbc {
    //  driver JDBC nom et URL BD
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
//    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    //  identifiants de connexion BD
//    static final String USER = "ju";
//    static final String PASS = "ju";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        final String DB_URL = args[0];
        final String USER = args[1];
        final String PASS = args[2];


        try{
            //STEP 2: enregistrement du  driver JDBC
            Class.forName(JDBC_DRIVER);

            //STEP 3: Ouvrir une connexion
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            try {
                JdbcUtils.populateTables(conn);
            } catch (SQLException e) {
                System.err.println(e);
            }

            stmt = conn.createStatement();
            String sql;
            //STEP 4: Executer une requete
            System.out.println("1) Afficher le nombre de chirurgies par docteur");

            sql = "Select D.matricule, D.nomM, D.prenomM, count(chi.idChir) AS nbr " +
                    "From DOCTEUR D, CONSULTATION cons, ORDONNANCECHIRURGIE OC, CHIRURGIE chi " +
                    "Where D.matricule = cons.CodeDocteur And cons.numOrd = OC.numOrd AND OC.IDCHIR=chi.IDCHIR " +
                    "Group By D.matricule, D.nomM, D.prenomM";
            ResultSet rs = stmt.executeQuery(sql);
            //Extraction des  donnees du result set
            JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrChirurgie\n");


            System.out.println("2) Afficher le nombre de consultations par docteurs");
            sql = "SELECT D.matricule, D.nomM, D.prenomM, count(*) AS nbr " +
                    "FROM CONSULTATION C, DOCTEUR D " +
                    "Where C.CodeDocteur = D.matricule " +
                    "GROUP BY D.matricule, D.nomM, D.prenomM";
            rs = stmt.executeQuery(sql);
            JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrConsultations\n");


            System.out.println("3) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE");
            sql = "Select extract (year from dateC) AS annee, count(*) AS nbr " +
                    "From Consultation c  " +
                    "group by extract (year from dateC)";
            rs = stmt.executeQuery(sql);
            JdbcUtils.printStringInt(rs,"---annee------nbrConsultations\n");


            System.out.println("4) Afficher le nombre de medicaments prescrits par docteur");
            sql = "Select D.matricule, D.nomM, D.prenomM, sum(nbrMedicaments) AS nbr " +
                    "From DOCTEUR D, CONSULTATION C, ORDONNANCE O " +
                    "Where D.matricule = C.CodeDocteur And C.numOrd = O.numOrd " +
                    "Group By D.matricule, D.nomM, D.prenomM";
            rs = stmt.executeQuery(sql);
            JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrmedicaments\n");


            System.out.println("5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES.");

            sql = "Select extract (year from o.DATEC) AS annee, (select count(*) from chirurgie )/(SELECT COUNT(*) from ORDONNANCE o WHERE o.TYPE = 'Médicaments') as ratio " +
                    "from CHIRURGIE chi , ORDONNANCE o " +
                    "where extract(YEAR from chi.DATECHIRURGIE) = extract (year from o.DATEC) " +
                    "group by extract (year from o.DATEC)";
            rs = stmt.executeQuery(sql);
            JdbcUtils.printIntBigdecimal(rs,"---annee------ratio\n");


//            //STEP 6: Executer un Update - Insert
//            sql = "insert into client values(5,'zaier','51455555555')";
//            int number = stmt.executeUpdate(sql);
//            System.out.println(" the change 1: " + number);
//
//            //STEP 7: Executer un Update - Update
//            sql = "update client set notelephone = '9999999999' where noclient=5";
//            number = stmt.executeUpdate(sql);
//            System.out.println(" the change 2: " + number);
//
//            //STEP 8: Executer un Update - Delete
//            sql = "Delete from client where noclient=5";
//            number = stmt.executeUpdate(sql);
//            System.out.println(" the change 3: " + number);

            //STEP 9: Clean-up de l'environnementement
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Gerer les erreur pour JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Gerer les erreur pour  Class.forName
            e.printStackTrace();
        }

        System.out.println("\nGoodbye!");
    }//fin main
}//fin FirstExample
