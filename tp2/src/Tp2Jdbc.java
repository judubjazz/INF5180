//STEP 1. Importer les packages necessaires
import java.sql.*;

public class Tp2Jdbc {
    //  driver JDBC nom et URL BD
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    //  identifiants de connexion BD
    static final String USER = "ju";
    static final String PASS = "ju";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: enregistrement du  driver JDBC
            Class.forName(JDBC_DRIVER);

            //STEP 3: Ouvrir une connexion
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Executer une requete
            System.out.println("1) Afficher le nombre de chirurgies par docteur");
            stmt = conn.createStatement();
            String sql;
            sql = "Select D.matricule, D.nomM, D.prenomM, count(OC.idChir) AS nbr " +
                    "From DOCTEUR D, CONSULTATION C, ORDONNANCECHIRURGIE OC " +
                    "Where D.matricule = C.CodeDocteur And C.numOrd = OC.numOrd " +
                    "Group By D.matricule, D.nomM, D.prenomM";
            ResultSet rs = stmt.executeQuery(sql);


            //Extraction des  donnees du result set
            System.out.print("---ID------nomM------prenomM----nbrChirurgie\n");
            while(rs.next()){
                //Retrouver  par le nom de la colonne
                int id  = rs.getInt("matricule");
                String nomM = rs.getString("nomM");
                String prenomM = rs.getString("prenomM");
                int nbr = rs.getInt("nbr");

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

            System.out.println("2) Afficher le nombre de consultations par docteurs");
            stmt = conn.createStatement();
            sql = "SELECT D.matricule, D.nomM, D.prenomM, count(*) AS nbr " +
                    "FROM CONSULTATION C, DOCTEUR D " +
                    "Where C.CodeDocteur = D.matricule " +
                    "GROUP BY D.matricule, D.nomM, D.prenomM";
            rs = stmt.executeQuery(sql);


            //Extraction des  donnees du result set
            System.out.print("---ID------nomM------prenomM----nbrConsultations\n");
            while(rs.next()){
                //Retrouver  par le nom de la colonne
                int id  = rs.getInt("matricule");
                String nomM = rs.getString("nomM");
                String prenomM = rs.getString("prenomM");
                int nbr = rs.getInt("nbr");

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

            System.out.println("3) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE");
            stmt = conn.createStatement();
            sql = "Select extract (year from dateC) AS annee, count(*) AS nbr " +
                    "From Consultation c  " +
                    "group by extract (year from dateC)";
            rs = stmt.executeQuery(sql);


            //Extraction des  donnees du result set
            System.out.print("---annee------nbrConsultations\n");
            while(rs.next()){
                //Retrouver  par le nom de la colonne
                String d  = rs.getString("annee");
                int nbr = rs.getInt("nbr");

                //Afficher les valeurs

                System.out.print("   ");
                System.out.print(d);
                System.out.print("         ");
                System.out.print(nbr);
                System.out.print("\n\n");
            }

            System.out.println("4) Afficher le nombre de medicaments prescrits par docteur");
            stmt = conn.createStatement();
            sql = "Select D.matricule, D.nomM, D.prenomM, sum(nbrMedicaments) AS nbr " +
                    "From DOCTEUR D, CONSULTATION C, ORDONNANCE O " +
                    "Where D.matricule = C.CodeDocteur And C.numOrd = O.numOrd " +
                    "Group By D.matricule, D.nomM, D.prenomM";
            rs = stmt.executeQuery(sql);


            //Extraction des  donnees du result set
            System.out.print("---ID------nomM------prenomM----nbrmedicaments\n");
            while(rs.next()){
                //Retrouver  par le nom de la colonne
                int id  = rs.getInt("matricule");
                String nomM = rs.getString("nomM");
                String prenomM = rs.getString("prenomM");
                int nbr = rs.getInt("nbr");

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

            System.out.println("5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES.");
            stmt = conn.createStatement();
            sql = "create or replace view tab (annee, nbr) AS " +
                    "Select  o.DATEC, count(*)" +
                    "from ORDONNANCE o , CHIRURGIE c " +
                    "where o.type = 'Médicaments' AND extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC) " +
                    "group by o.DATEC  ";
            rs = stmt.executeQuery(sql);

            sql = "Select extract (year from c.DATECHIRURGIE) AS annee, (select count(*) from chirurgie c, tab where extract (year from c.DATECHIRURGIE) = extract (year from tab.annee)) / (select count (*) from ordonnance o where o.type = 'Médicaments') as ratio " +
                    "from chirurgie c , tab " +
                    "where extract (year from c.DATECHIRURGIE) = extract (year from tab.annee) " +
                    "group by extract (year from c.DATECHIRURGIE)";

            rs = stmt.executeQuery(sql);


            //Extraction des  donnees du result set
            System.out.print("---annee------ratio\n");
            while(rs.next()){
                //Retrouver  par le nom de la colonne
                int id  = rs.getInt("annee");
                int nbr = rs.getInt("ratio");

                //Afficher les valeurs

                System.out.print("   ");
                System.out.print(id);
                System.out.print("         ");
                System.out.print(nbr);
                System.out.print("\n\n");
            }

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
