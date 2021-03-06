-- 1a) Afficher le nombre de chirurgies par docteur

Select D.matricule, D.nomM, D.prenomM, count(chi.idChir) as nbrChirurgies
From DOCTEUR D, CONSULTATION cons, ORDONNANCECHIRURGIE oc, CHIRURGIE chi
Where D.matricule = cons.CodeDocteur And cons.numOrd = oc.numOrd AND oc.IDCHIR = chi.IDCHIR
Group By D.matricule, D.nomM, D.prenomM;

--1b)afficher le nombre de chirurgies par salle
-- Select S.IDSALLE, S.nom, count(OC.idChir) as nbrChirurgies
-- from SALLE S, CHIRURGIE C, ORDONNANCECHIRURGIE OC
-- where s.IDSALLE = c.IDSALLE And c.IDCHIR = oc.IDCHIR
-- group by s.IDSALLE, s.NOM;

-- --1c)afficher le nombre de chirurgies par type.
-- Select TC.IDTYPE, TC.nom, count(*) as nbrChirurgies
-- from CHIRURGIE C, ORDONNANCECHIRURGIE OC, TYPECHIRURGIE TC
-- where C.IDCHIR = OC.IDCHIR And c.IDType = TC.IDTYPE
-- group by TC.IDTYPE, TC.nom;

-- 2a) Afficher le nombre de consultations par docteurs

Select d.matricule, d.nomM, d.prenomM, count(*) as nbrConsultation
From Consultation c, Docteur d
Where c.CodeDocteur = d.matricule
Group By d.matricule, d.nomM, d.prenomM;

--2b)afficher le nombre de consultations par spécialité.
-- Select S.Code, S.Titre, Count(*) as nbrConsultation
-- from SPECIALITE S, DOCTEUR D, CONSULTATION C
-- Where C.CODEDOCTEUR = D.MATRICULE And D.SPECIALITE = S.CODE
-- GROUP BY s.CODE,s.TITRE;

-- 3a) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE

Select extract (year from dateC) AS annee, count(*) AS nbrConsultations
From Consultation c
group by extract (year from dateC);

-- 3b) afficher le nombre de consultations par mois.
-- select extract (MONTH from dateC) As month, count(*) as nbrConsultations
-- From CONSULTATION C
-- group by extract (MONTH from dateC);


-- 4a) Afficher le nombre de medicaments prescrits par docteur

Select D.matricule, D.nomM, D.prenomM, Sum(o.nbrMedicaments)
From DOCTEUR D, CONSULTATION C, ORDONNANCE O
Where D.matricule = C.CodeDocteur And C.numOrd = O.numOrd
Group By D.matricule, D.nomM, D.prenomM;

-- 4b) afficher le nombre moyen de médicaments prescrits par mois

-- Select extract ( month from C.dateC) as mois, Sum(o.nbrMedicaments)/12 as nbrMoyenMedicamentsParMois
-- From CONSULTATION C, ORDONNANCE O
-- Where C.NUMORD = o.NUMORD
-- Group By extract ( month from C.dateC);



-- -- 5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES.
create or replace view TRAITEMENTMEDICAMENTEUX (annee, nbr) AS
  Select  extract (year from o.DATEC) as annee, count(*) as nbr
  from ORDONNANCE o , CHIRURGIE c
  where o.type = 'Médicaments' AND extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC)
  group by o.DATEC
  ORDER BY annee;

create or replace view CHIRURGIECOMPLETE (annee, nbr) AS
  Select  extract (year from o.DATEC) as annee, count(*) as nbr
  from ORDONNANCE o , CHIRURGIE c
  where extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC)
  group by o.DATEC
  ORDER BY annee;


select CHIRURGIECOMPLETE.annee, count(CHIRURGIECOMPLETE.nbr)/count(TRAITEMENTMEDICAMENTEUX.nbr) as ratio
from CHIRURGIECOMPLETE JOIN TRAITEMENTMEDICAMENTEUX on CHIRURGIECOMPLETE.annee = TRAITEMENTMEDICAMENTEUX.annee
group by CHIRURGIECOMPLETE.annee, CHIRURGIECOMPLETE.nbr, TRAITEMENTMEDICAMENTEUX.annee, TRAITEMENTMEDICAMENTEUX.nbr;



