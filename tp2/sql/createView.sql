create or replace view tab (annee, nbr) AS
  Select  o.DATEC, count(*)
  from ORDONNANCE o , CHIRURGIE c
  where o.type = 'Médicaments' AND extract (year from c.DATECHIRURGIE) = extract (year from o.DATEC)
  group by o.DATEC