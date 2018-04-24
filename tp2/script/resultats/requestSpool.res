SQL> @/home/ju/JetBrainsProjects/IdeaProjects/INF5180/tp2_localhost/script/RequestTp2.sql

 MATRICULE NOMM 		PRENOMM 	     NBRCHIRURGIES
---------- -------------------- -------------------- -------------
	15 smith		john				 3


 MATRICULE NOMM 		PRENOMM 	     NBRCONSULTATION
---------- -------------------- -------------------- ---------------
	10 Dr			House				   1
	13 smith		john				   1
	12 Dr			Green Thumb			   1
	14 smith		john				   1
	11 Dr			Evil				   1
	15 smith		john				   3

6 rows selected.


     ANNEE NBRCONSULTATIONS
---------- ----------------
      2010		  1
      2011		  1
      2012		  6


 MATRICULE NOMM 		PRENOMM 	     SUM(O.NBRMEDICAMENTS)
---------- -------------------- -------------------- ---------------------
	10 Dr			House					10
	13 smith		john					13
	12 Dr			Green Thumb				 0
	14 smith		john					14
	11 Dr			Evil					11
	15 smith		john					48

6 rows selected.


View created.


View created.


     ANNEE	RATIO
---------- ----------
      2011	    1
      2010	    1
      2012	    1

SQL>
