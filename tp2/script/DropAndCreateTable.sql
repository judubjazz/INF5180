DROP TABLE ORDONNANCEMEDICAMENTS;
DROP TABLE MEDICAMENT;
DROP TABLE SPECIALISATIONSALLE;
DROP TABLE ORDONNANCECHIRURGIE;
DROP TABLE CHIRURGIE;
DROP TABLE CONSULTATION;
DROP TABLE DOSSIERPATIENT;
DROP TABLE DOCTEUR;
DROP TABLE ORDONNANCE;
DROP TABLE TYPECHIRURGIE;
DROP TABLE CATEGORIES;
DROP TABLE SALLE;
DROP TABLE SPECIALITE;

----CREATION------
alter SESSION set NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

CREATE TABLE SPECIALITE
(
 code        INTEGER,
 titre       VARCHAR2(20) NOT NULL,
 description VARCHAR2(20),
 CONSTRAINT SPECIALITE_PK PRIMARY KEY (code)
)
/

CREATE TABLE SALLE
(
 idSalle INTEGER,
 nom     VARCHAR2(20) NOT NULL,
 CONSTRAINT SALLE_PK PRIMARY KEY (idSalle)
)
/

CREATE TABLE CATEGORIES
(
 IdCategorie INTEGER,
 nom         VARCHAR2(20) NOT NULL,
 Description VARCHAR2(20),
 CONSTRAINT CATEGORIES_PK PRIMARY KEY (IdCategorie)
)
/

CREATE TABLE TYPECHIRURGIE
(
 IdType      INTEGER,
 nom         VARCHAR2(20) NOT NULL,
 Description VARCHAR2(200),
 CONSTRAINT TYPECHIRURGIE_PK PRIMARY KEY (IdType)
)
/

CREATE TABLE ORDONNANCE
(
 numOrd          INTEGER,
 recommandations VARCHAR2(20),
 type            VARCHAR2(20),
 dateC           DATE,
 nbrMedicaments  INTEGER DEFAULT 0,
 CONSTRAINT ORDONNANCE_PK PRIMARY KEY (numOrd),
 CONSTRAINT ORDONNANCE_CHK CHECK (type IN ('Chirurgie', 'Médicaments')),
 CONSTRAINT ORDONNANCE_CHK2 CHECK (nbrMedicaments >= 0)
)
/

CREATE TABLE DOCTEUR
(
 matricule           INTEGER,
 nomM                VARCHAR2(20) NOT NULL,
 prenomM             VARCHAR2(20) NOT NULL,
 specialite          INTEGER,
 ville               VARCHAR2(20),
 adresse             VARCHAR2(100),
 niveau              VARCHAR2(20),
 nbrPatients         INTEGER DEFAULT 0,
 CONSTRAINT DOCTEUR_PK PRIMARY KEY (matricule),
 CONSTRAINT DOCTEUR_FK FOREIGN KEY (specialite) REFERENCES SPECIALITE (code),
 CONSTRAINT DOCTEUR_CHK CHECK (nbrPatients >= 0),
 CONSTRAINT DOCTEUR_CHK3 CHECK (niveau IN ('Étudiant', 'Interne', 'Docteur'))
)
/

CREATE TABLE DOSSIERPATIENT
(
 numDos          INTEGER,
 nomP            VARCHAR2(20) NOT NULL,
 prenomP         VARCHAR2(20) NOT NULL,
 sexe            VARCHAR2(1),
 numAS           INTEGER,
 dateNaiss       DATE,
 dateC           DATE,
 matricule       INTEGER,
 nbrConsultation INTEGER DEFAULT 0,
 CONSTRAINT DOSSIERPATIENT_PK PRIMARY KEY (numDos),
 CONSTRAINT DOSSIERPATIENT_FK FOREIGN KEY (matricule) REFERENCES DOCTEUR (matricule) ON DELETE SET NULL,
 CONSTRAINT DOSSIERPATIENT_CHK CHECK (sexe IN ('M', 'F')),
 CONSTRAINT DOSSIERPATIENT_CHK2 CHECK (nbrConsultation >= 0),
 CONSTRAINT DOSSIERPATIENT_UN UNIQUE (numAS)
)
/

CREATE TABLE CONSULTATION
(
 CodeDocteur INTEGER,
 numDos      INTEGER,
 dateC       DATE,
 diagnostic  VARCHAR2(200) NOT NULL,
 numOrd      INTEGER,
 CONSTRAINT CONSULTATION_PK PRIMARY KEY (CodeDocteur, numDos, dateC),
 CONSTRAINT CONSULTATION_FK FOREIGN KEY (CodeDocteur) REFERENCES DOCTEUR (matricule) ON DELETE CASCADE,
 CONSTRAINT CONSULTATION_FK2 FOREIGN KEY (numOrd) REFERENCES ORDONNANCE (numOrd),
 CONSTRAINT CONSULTATION_FK3 FOREIGN KEY (numDos) REFERENCES DOSSIERPATIENT (numDos) ON DELETE CASCADE
)
/

CREATE TABLE CHIRURGIE
(
 idChir        INTEGER,
 idType        INTEGER,
 idSalle       INTEGER,
 dateChirurgie DATE,
 HeureDebut    INTEGER,
 HeureFin      INTEGER,
 CONSTRAINT CHIRURGIE_PK PRIMARY KEY (idChir),
 CONSTRAINT CHIRURGIE_FK FOREIGN KEY (IdType) REFERENCES TYPECHIRURGIE (IdType),
 CONSTRAINT CHIRURGIE_FK2 FOREIGN KEY (idSalle) REFERENCES SALLE (idSalle),
 CONSTRAINT CHIRURGIE_CHK CHECK (HeureDebut >= 0),
 CONSTRAINT CHIRURGIE_CHK2 CHECK (HeureFin >= 0)
)
/

CREATE TABLE ORDONNANCECHIRURGIE
(
 numOrd INTEGER,
 idChir INTEGER,
 rang   INTEGER DEFAULT 0,
 CONSTRAINT ORDONNANCECHIRURGIE_PK PRIMARY KEY (numOrd, idChir),
 CONSTRAINT ORDONNANCECHIRURGIE_FK FOREIGN KEY (idChir) REFERENCES CHIRURGIE (idChir),
 CONSTRAINT ORDONNANCECHIRURGIE_FK2 FOREIGN KEY (numOrd) REFERENCES ORDONNANCE (numOrd),
 CONSTRAINT ORDONNANCECHIRURGIE_UNI UNIQUE (numOrd, idChir, rang),
 CONSTRAINT ORDONNANCECHIRURGIE_CHK1 CHECK (rang >= 0)
)
/

CREATE TABLE SPECIALISATIONSALLE
(
 IdType  INTEGER,
 idSalle INTEGER,
 dateC   DATE,
 CONSTRAINT SPECIALISATIONSALLE_PK PRIMARY KEY (IdType, idSalle),
 CONSTRAINT SPECIALISATIONSALLE_FK FOREIGN KEY (IdType) REFERENCES TYPECHIRURGIE (IdType),
 CONSTRAINT SPECIALISATIONSALLE_FK2 FOREIGN KEY (idSalle) REFERENCES SALLE (idSalle)
)
/

CREATE TABLE MEDICAMENT
(
 idMed     INTEGER,
 nomMed    VARCHAR2(20) NOT NULL,
 prix      NUMBER(6, 2) DEFAULT 0,
 categorie INTEGER,
 CONSTRAINT MEDICAMENT_PK PRIMARY KEY (idMed),
 CONSTRAINT MEDICAMENT_FK FOREIGN KEY (categorie) REFERENCES CATEGORIES (IdCategorie),
 CONSTRAINT MEDICAMENT_CHK CHECK (prix >= 0),
 CONSTRAINT MEDICAMENT_UNI UNIQUE (idMed, categorie)
)
/

CREATE TABLE ORDONNANCEMEDICAMENTS
(
 numOrd   INTEGER,
 idMed    INTEGER,
 nbBoites INTEGER DEFAULT 0,
 CONSTRAINT ORDONNANCEMEDICAMENTS_PK PRIMARY KEY (numOrd, idMed),
 CONSTRAINT ORDONNANCEMEDICAMENTS_FK FOREIGN KEY (numOrd) REFERENCES ORDONNANCE (numOrd),
 CONSTRAINT ORDONNANCEMEDICAMENTS_FK2 FOREIGN KEY (idMed) REFERENCES MEDICAMENT (idMed),
 CONSTRAINT ORDONNANCEMEDICAMENTS_CHK CHECK (nbBoites >= 0)
)
/