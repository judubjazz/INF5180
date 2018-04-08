-- 1) Afficher le nombre de chirurgies par docteur

Select D.matricule, D.nomM, D.prenomM, count(OC.idChir)
From DOCTEUR D, CONSULTATION C, ORDONNANCECHIRURGIE OC
Where D.matricule = C.CodeDocteur And C.numOrd = OC.numOrd
Group By D.matricule, D.nomM, D.prenomM;

-- 2) Afficher le nombre de consultations par docteurs

Select d.matricule, d.nomM, d.prenomM, count(*)
From Consultation c, Docteur d
Where c.CodeDocteur = d.matricule 
Group By d.matricule, d.nomM, d.prenomM;


-- 3) AFFICHER LE NOMBRE DE CONSULTATION PAR ANNEE

Select extract (year from dateC) AS annee, count(*) AS nbrConsultation
From Consultation c 
group by extract (year from dateC)

/

-- 4) Afficher le nombre de medicaments prescrits par docteur

Select D.matricule, D.nomM, D.prenomM, Sum(nbrMedicaments)
From DOCTEUR D, CONSULTATION C, ORDONNANCE O
Where D.matricule = C.CodeDocteur And C.numOrd = O.numOrd
Group By D.matricule, D.nomM, D.prenomM;


-- 5) RATIO DES CHIRURGIES VERSUS TRAITEMENTS MËDICAMENTEUX PAR ANNEES.

create or replace view tab (annee, nbr) AS
Select  o.DATEC, count(*)
from ORDONNANCE o , CHIRURGIE c
where o.type = 'Médicaments' AND extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC) 
group by o.DATEC 
/

Select extract (year from c.DATECHIRURGIE) AS annee, (select count(*) from chirurgie c, tab where extract (year from c.DATECHIRURGIE) = extract (year from tab.annee)) / (select count (*) from ordonnance o where o.type = 'Médicaments') as ratio
from chirurgie c , tab
where extract (year from c.DATECHIRURGIE) = extract (year from tab.annee)
group by extract (year from c.DATECHIRURGIE)
/
