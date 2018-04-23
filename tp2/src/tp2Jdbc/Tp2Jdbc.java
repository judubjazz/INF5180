package tp2Jdbc;//STEP 1. Importer les packages necessaires
import java.sql.*;
import tp2Jdbc.jdbcUtils.*;

public class Tp2Jdbc {
    //  driver JDBC nom et URL BD
    static private final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

    private static final String REQ1 = "1) AFFICHER LE NOMBRE DE CHIRURGIES PAR DOCTEUR";
    private static final String REQ2 = "2) AFFICHER LE NOMBRE DE CONSULTATIONS PAR DOCTEUR";
    private static final String REQ3 = "3) AFFICHER LE NOMBRE DE CONSULTATIONS PAR ANNÉE";
    private static final String REQ4 = "4) AFFICHER LE NOMBRE DE MÉDICAMENTS PRESCRITS PAR DOCTEUR";
    private static final String REQ5 = "5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MÉDICAMENTEUX PAR ANNEES";

    private static void requete1 (Statement stmt) throws SQLException{
        System.out.println(REQ1);
        String sql = "Select D.matricule, D.nomM, D.prenomM, count(chi.idChir) AS nbr " +
                "From DOCTEUR D, CONSULTATION cons, ORDONNANCECHIRURGIE OC, CHIRURGIE chi " +
                "Where D.matricule = cons.CodeDocteur And cons.numOrd = OC.numOrd AND OC.IDCHIR=chi.IDCHIR " +
                "Group By D.matricule, D.nomM, D.prenomM";
        ResultSet rs = stmt.executeQuery(sql);
        JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrChirurgie\n");
        rs.close();
    }

    private static void requete2 (Statement stmt) throws SQLException{
        System.out.println(REQ2);
        String sql = "SELECT D.matricule, D.nomM, D.prenomM, count(*) AS nbr " +
                "FROM CONSULTATION C, DOCTEUR D " +
                "Where C.CodeDocteur = D.matricule " +
                "GROUP BY D.matricule, D.nomM, D.prenomM";
        ResultSet rs = stmt.executeQuery(sql);
        JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrConsultations\n");
        rs.close();
    }

    private static void requete3 (Statement stmt) throws SQLException{
        System.out.println(REQ3);
        String sql = "Select extract (year from dateC) AS annee, count(*) AS nbr " +
                "From Consultation c  " +
                "group by extract (year from dateC)";
        ResultSet rs = stmt.executeQuery(sql);
        JdbcUtils.printStringInt(rs,"---annee------nbrConsultations\n");
        rs.close();
    }

    private static void requete4 (Statement stmt) throws SQLException{
        System.out.println(REQ4);
        String sql = "Select D.matricule, D.nomM, D.prenomM, sum(nbrMedicaments) AS nbr " +
                "From DOCTEUR D, CONSULTATION C, ORDONNANCE O " +
                "Where D.matricule = C.CodeDocteur And C.numOrd = O.numOrd " +
                "Group By D.matricule, D.nomM, D.prenomM";
        ResultSet rs = stmt.executeQuery(sql);
        JdbcUtils.printIntStringStringInt(rs,"---ID------nomM------prenomM----nbrmedicaments\n");
        rs.close();
    }

    private static void requete5 (Statement stmt) throws SQLException{
        System.out.println(REQ5);
        String sql = "create or replace view TRAITEMENTMEDICAMENTEUX (annee, nbr) AS " +
                "Select  extract (year from o.DATEC) as annee, count(*) as nbr " +
                "from ORDONNANCE o , CHIRURGIE c " +
                "where o.type = 'Médicaments' AND extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC) " +
                "group by o.DATEC " +
                "ORDER BY annee";
        stmt.executeQuery(sql);

        sql = "create or replace view CHIRURGIECOMPLETE (annee, nbr) AS " +
                "Select  extract (year from o.DATEC) as annee, count(*) as nbr " +
                "from ORDONNANCE o , CHIRURGIE c " +
                "where extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC) " +
                "group by o.DATEC " +
                "ORDER BY annee";
        stmt.executeQuery(sql);

        sql = "  select CHIRURGIECOMPLETE.annee, count(CHIRURGIECOMPLETE.nbr)/count(TRAITEMENTMEDICAMENTEUX.nbr) as ratio " +
                "from CHIRURGIECOMPLETE JOIN TRAITEMENTMEDICAMENTEUX on CHIRURGIECOMPLETE.annee = TRAITEMENTMEDICAMENTEUX.annee " +
                "group by CHIRURGIECOMPLETE.annee, CHIRURGIECOMPLETE.nbr, TRAITEMENTMEDICAMENTEUX.annee, TRAITEMENTMEDICAMENTEUX.nbr";
        ResultSet rs = stmt.executeQuery(sql);
        JdbcUtils.printIntBigdecimal(rs,"---annee------ratio\n");
        rs.close();
    }

    public static void main(String[] args) {
        Connection conn ;
        Statement stmt ;

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
                e.printStackTrace();
            }

            stmt = conn.createStatement();

            requete1(stmt);
            requete2(stmt);
            requete3(stmt);
            requete4(stmt);
            requete5(stmt);

            //clean up
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
