SQL> @/home/ju/JetBrainsProjects/IdeaProjects/INF5180/tp2_localhost/script/InsertTable.sql
Insert into SPECIALITE Values (1, NULL, 'Facial')
                                  *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."SPECIALITE"."TITRE")



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into SALLE Values (1, NULL)
                             *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."SALLE"."NOM")



1 row created.


1 row created.


1 row created.


1 row created.

Insert into CATEGORIES Values (1, NULL, 'comprime')
                                  *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."CATEGORIES"."NOM")



1 row created.


1 row created.


1 row created.

Insert into TYPECHIRURGIE Values (1, NULL, 'Facial')
                                     *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."TYPECHIRURGIE"."NOM")



1 row created.


1 row created.


1 row created.

Insert into ORDONNANCE Values (1, 'test', 'erreur', '2001-01-01', 1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.ORDONNANCE_CHK) violated


Insert into ORDONNANCE Values (2, 'boire de l eau', 'Chirurgie', '2002-02-02', -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.ORDONNANCE_CHK2) violated



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into DOCTEUR Values (1, NULL, 'Phil', 1, 'NY', 'ici', 'Docteur', 1)
                               *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."DOCTEUR"."NOMM")


Insert into DOCTEUR Values (2, 'McGraw', NULL, 2, 'NY', 'ici', 'Docteur', 2)
                                         *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."DOCTEUR"."PRENOMM")


Insert into DOCTEUR Values (3, 'McGraw', 'Phil', 3, 'NY', 'ici', 'Docteur', -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.DOCTEUR_CHK) violated


Insert into DOCTEUR Values (4, 'McGraw', 'Phil', 4, 'NY', 'ici', 'Docteur', 4)
*
ERROR at line 1:
ORA-02291: integrity constraint (JU.DOCTEUR_FK) violated - parent key not found


Insert into DOCTEUR Values (5, 'McGraw', 'Phil', 4, 'NY', 'ici', 'tv', 4)
*
ERROR at line 1:
ORA-02290: check constraint (JU.DOCTEUR_CHK2) violated



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into DOSSIERPATIENT Values (1, NULL, 'inette', 'M', 1, '2001-01-01', '2001-01-01', 1, 1)
                                      *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."DOSSIERPATIENT"."NOMP")


Insert into DOSSIERPATIENT Values (2, 'bob', NULL, 'M', 2, '2002-02-02', '2002-02-02', 2, 2)
                                             *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."DOSSIERPATIENT"."PRENOMP")


Insert into DOSSIERPATIENT Values (3, 'bob', 'inette', 'M', 3, '2003-03-03', '2003-03-03', 3, -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.DOSSIERPATIENT_CHK2) violated


Insert into DOSSIERPATIENT Values (4, 'bob', 'inette', 'T', 4, '2004-04-04', '2004-04-04', 4, 4)
*
ERROR at line 1:
ORA-02290: check constraint (JU.DOSSIERPATIENT_CHK) violated



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into DOSSIERPATIENT Values (16, 'smith', 'john', 'F', 15, '2012-12-12', '2011-12-12', 15, default)
*
ERROR at line 1:
ORA-00001: unique constraint (JU.DOSSIERPATIENT_UN) violated


Insert into CONSULTATION Values (1, 1, '2001-01-01', NULL, 1)
                                                     *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."CONSULTATION"."DIAGNOSTIC")



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into Chirurgie Values (1, 1, 1, '2001-01-01', -1, 1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.CHIRURGIE_CHK) violated


Insert into Chirurgie Values (2, 2, 2, '2002-02-02', 0, -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.CHIRURGIE_CHK2) violated



1 row created.


1 row created.


1 row created.

Insert into ORDONNANCECHIRURGIE Values (1, 1, -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.ORDONNANCECHIRURGIE_CHK1) violated



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

Insert into MEDICAMENT Values (1, NULL, 1.11, 1)
                                  *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("JU"."MEDICAMENT"."NOMMED")


Insert into MEDICAMENT Values (2, 'vortex', -2.22, 2)
*
ERROR at line 1:
ORA-02290: check constraint (JU.MEDICAMENT_CHK) violated



1 row created.


1 row created.


1 row created.

Insert into ORDONNANCEMEDICAMENTS Values (1, 1, -1)
*
ERROR at line 1:
ORA-02290: check constraint (JU.ORDONNANCEMEDICAMENTS_CHK) violated



1 row created.


1 row created.


1 row created.


1 row created.


1 row created.

SQL>
