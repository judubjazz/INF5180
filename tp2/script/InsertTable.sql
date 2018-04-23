----JEU DE MOT/INSERTION----


                    -- INSERT SPECIALITE
--errors
Insert into SPECIALITE Values (1, NULL, 'Facial');

--good values
Insert into SPECIALITE Values (10, 'Esthetique', 'Facial');
Insert into SPECIALITE Values (11, 'Urgentiste', 'Accident');
Insert into SPECIALITE Values (12, 'Opthamologiste', 'Chirurgie');
Insert into SPECIALITE Values (13, 'chirurgien', 'Chirurgie');
Insert into SPECIALITE Values (14, 'pediatre', 'Chirurgie');
Insert into SPECIALITE Values (15, 'psychologue', 'Chirurgie');


                          --INSERT SALLE
--errors
Insert into SALLE Values (1, NULL);

--good values
Insert into SALLE Values (10, 'wilfred');
Insert into SALLE Values (11, 'calixa');
Insert into SALLE Values (12, 'abraham');
Insert into SALLE Values (13, 'babylon');


                        --INSERT CATEGORIES
--errors
Insert into CATEGORIES Values (1, NULL, 'comprime');

--good values
Insert into CATEGORIES Values (10, 'comprime', 'comprime');
Insert into CATEGORIES Values (11, 'gelule', 'gelule');
Insert into CATEGORIES Values (12, 'sirop', 'sirop');


                        --INSERT TYPECHIRURGIE
--errors
Insert into TYPECHIRURGIE Values (1, NULL, 'Facial');

--good values
Insert into TYPECHIRURGIE Values (10,'chirurgie dentaire', 'bouche');
Insert into TYPECHIRURGIE Values (11, 'chirurgie plastique', 'esthetique');
Insert into TYPECHIRURGIE Values (12, 'occulaire', 'yeux');


                            --INSERT ORDONNANCE
--errors
Insert into ORDONNANCE Values (1, 'test', 'erreur', '2001-01-01', 1);
Insert into ORDONNANCE Values (2, 'boire de l eau', 'Chirurgie', '2002-02-02', -1);

-- good values
Insert into ORDONNANCE Values (10, 'ne pas manger', 'Médicaments', '2010-10-10', 10);
Insert into ORDONNANCE Values (11, 'ne pas boire', 'Médicaments', '2011-11-11', 11);
Insert into ORDONNANCE Values (12, 'ne rien faire', 'Médicaments', '2012-12-12', default);
Insert into ORDONNANCE Values (13, 'ne pas manger', 'Médicaments', '2010-10-10', 13);
Insert into ORDONNANCE Values (14, 'ne pas boire', 'Médicaments', '2011-11-11', 14);
Insert into ORDONNANCE Values (15, 'ne rien faire', 'Chirurgie', '2012-12-12', 15);
Insert into ORDONNANCE Values (16, 'ne pas manger', 'Chirurgie', '2010-10-10', 16);
Insert into ORDONNANCE Values (17, 'ne pas boire', 'Chirurgie', '2011-11-11', 17);


                          --INSERT DOCTEUR
--errors
Insert into DOCTEUR Values (1, NULL, 'Phil', 1, 'NY', 'ici', 'Docteur', 1);
Insert into DOCTEUR Values (2, 'McGraw', NULL, 2, 'NY', 'ici', 'Docteur', 2);
Insert into DOCTEUR Values (3, 'McGraw', 'Phil', 3, 'NY', 'ici', 'Docteur', -1);
Insert into DOCTEUR Values (4, 'McGraw', 'Phil', 4, 'NY', 'ici', 'Docteur', 4);
Insert into DOCTEUR Values (5, 'McGraw', 'Phil', 4, 'NY', 'ici', 'tv', 4);

--good values
Insert into DOCTEUR Values (10, 'Dr', 'House', 10, 'NY', '10 dix', 'Étudiant', default);
Insert into DOCTEUR Values (11, 'Dr', 'Evil', 11, 'NY', '11 onze', 'Interne', default);
Insert into DOCTEUR Values (12, 'Dr', 'Green Thumb', 12, 'NY', '12 douze', 'Docteur', 12);
Insert into DOCTEUR Values (13, 'smith', 'john', 13, 'NY', '10 dix', 'Étudiant', 13);
Insert into DOCTEUR Values (14, 'smith', 'john', 14, 'NY', '11 onze', 'Interne', 14);
Insert into DOCTEUR Values (15, 'smith', 'john', 15, 'NY', '12 douze', 'Docteur', 15);


                                    --INSERT DOSSIERPATIENT
--errors
Insert into DOSSIERPATIENT Values (1, NULL, 'inette', 'M', 1, '2001-01-01', '2001-01-01', 1, 1);
Insert into DOSSIERPATIENT Values (2, 'bob', NULL, 'M', 2, '2002-02-02', '2002-02-02', 2, 2);
Insert into DOSSIERPATIENT Values (3, 'bob', 'inette', 'M', 3, '2003-03-03', '2003-03-03', 3, -1);
Insert into DOSSIERPATIENT Values (4, 'bob', 'inette', 'T', 4, '2004-04-04', '2004-04-04', 4, 4);

-- good values
Insert into DOSSIERPATIENT Values (10, 'lafleur', 'guy', 'M', 10, '1985-10-10', '2010-10-10', 10, default);
Insert into DOSSIERPATIENT Values (11, 'dryden', 'ken', 'M', 11, '1980-11-11', '2011-11-11', 11, default);
Insert into DOSSIERPATIENT Values (12, 'roy', 'patrick', 'F', 12, '2012-12-12', '2011-12-12', 12, default);
Insert into DOSSIERPATIENT Values (13, 'smith', 'john', 'M', 13, '1985-10-10', '2010-10-10', 13, default);
Insert into DOSSIERPATIENT Values (14, 'smith', 'john', 'M', 14, '1980-11-11', '2011-11-11', 14, default);
Insert into DOSSIERPATIENT Values (15, 'smith', 'john', 'F', 15, '2012-12-12', '2011-12-12', 15, default);

--error numas unique
Insert into DOSSIERPATIENT Values (16, 'smith', 'john', 'F', 15, '2012-12-12', '2011-12-12', 15, default);


                                        --INSERT CONSULTATION
--errors
Insert into CONSULTATION Values (1, 1, '2001-01-01', NULL, 1);

--good values
Insert into CONSULTATION Values (10, 10, '2010-10-10', 'inflamation', 10);
Insert into CONSULTATION Values (11, 11, '2011-11-11', 'Coupure', 11);
Insert into CONSULTATION Values (12, 12, '2012-12-12', 'fracture', 12);
Insert into CONSULTATION Values (13, 13, '2012-12-12', 'Infection', 13);
Insert into CONSULTATION Values (14, 14, '2012-12-12', 'Infection', 14);
Insert into CONSULTATION Values (15, 15, '2012-12-12', 'Infection', 15);
Insert into CONSULTATION Values (15, 10, '2012-12-12', 'Infection', 16);
Insert into CONSULTATION Values (15, 11, '2012-12-12', 'Infection', 17);


                                    --INSERT CHIRURGIE
--errors
Insert into Chirurgie Values (1, 1, 1, '2001-01-01', -1, 1);
Insert into Chirurgie Values (2, 2, 2, '2002-02-02', 0, -1);

-- good values
Insert into Chirurgie Values (15, 10, 10, '2010-10-10', 10, 11);
Insert into Chirurgie Values (16, 11, 11, '2011-11-11', 12, 13);
Insert into Chirurgie Values (17, 12, 12, '2012-12-12', 14, 15);


                          --INSERT ORDONNANCECHIRURGIE
--errors
Insert into ORDONNANCECHIRURGIE Values (1, 1, -1);

--good values
Insert into ORDONNANCECHIRURGIE Values (15, 15, 10);
Insert into ORDONNANCECHIRURGIE Values (16, 16, 11);
Insert into ORDONNANCECHIRURGIE Values (17, 17, 12);


                            --INSERT SPECIALISATIONSALLE
--good values
Insert into SPECIALISATIONSALLE Values (10, 10, '2010-10-10');
Insert into SPECIALISATIONSALLE Values (11, 11, '2011-11-11');
Insert into SPECIALISATIONSALLE Values (12, 12, '2012-12-12');


                                    --INSERT MEDICAMENT
--errors
Insert into MEDICAMENT Values (1, NULL, 1.11, 1);
Insert into MEDICAMENT Values (2, 'vortex', -2.22, 2);


-- good values
Insert into MEDICAMENT Values (10, 'Moulton', 10, 10);
Insert into MEDICAMENT Values (11, 'cutex', default, 11);
Insert into MEDICAMENT Values (12, 'latex', default, 11);



                            --INSERT ORDONNANCEMEDICAMENTS
--errors
Insert into ORDONNANCEMEDICAMENTS Values (1, 1, -1);

--good values
Insert into ORDONNANCEMEDICAMENTS Values (10, 10, 10);
Insert into ORDONNANCEMEDICAMENTS Values (11, 11, 11);
Insert into ORDONNANCEMEDICAMENTS Values (12, 12, 12);
Insert into ORDONNANCEMEDICAMENTS Values (13, 10, 12);
Insert into ORDONNANCEMEDICAMENTS Values (14, 11, 12);




