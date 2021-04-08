INSERT INTO ricercatore (id, nome, cognome) VALUES (1, 'Amelia', 'Buck');
INSERT INTO ricercatore (id, nome, cognome) VALUES (2, 'Lauren', 'Burton');
INSERT INTO ricercatore (id, nome, cognome) VALUES (3, 'Victoria', 'Page');
INSERT INTO ricercatore (id, nome, cognome) VALUES (4, 'Rosa', 'Dunn');
INSERT INTO ricercatore (id, nome, cognome) VALUES (5, 'Haroon', 'Franklin');
INSERT INTO ricercatore (id, nome, cognome) VALUES (6, 'George', 'Berry');
INSERT INTO ricercatore (id, nome, cognome) VALUES (7, 'Lucas', 'Johnston');
INSERT INTO ricercatore (id, nome, cognome) VALUES (8, 'Eric', 'Mcbride');
INSERT INTO ricercatore (id, nome, cognome) VALUES (9, 'Travis', 'Burke');
INSERT INTO ricercatore (id, nome, cognome) VALUES (10, 'Tommy', 'Rivera');

INSERT INTO sala (id, periodo) VALUES (1, 'Giurassico');
INSERT INTO sala (id, periodo) VALUES (2, 'Cretacico');
INSERT INTO sala (id, periodo) VALUES (3, 'Triassico');
INSERT INTO sala (id, periodo) VALUES (4, 'Carbonifero');
INSERT INTO sala (id, periodo) VALUES (5, 'Permiano');
INSERT INTO sala (id, periodo) VALUES (6, 'Cambriano');

INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (1, 3, 4, 5, 6);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (2, 5, 2, 3, 5);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (3, 2, 1.5, 2, 3);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (4, 3, 4, 5, 4);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (5, 6, 3, 2, 1);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (6, 3, 3, 3, 2);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (7, 3, 5, 4, 6);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (8, 4, 6, 3, 1);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (9, 2, 4, 5, 6);
INSERT INTO teca (id, larghezza, altezza, profondita, idsala) VALUES (10, 3, 2, 5, 4);

INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (1, 'Alessio', 'Pelizzoni', '1234', 0, 4);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (2, 'Paolo', 'Rossi', 'paolo', 1, 4);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (3, 'Daniele', 'Pelizzoni', 'dani', 0, 6);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (4, 'Marco', 'Oliveri', '4444', 1, 2);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (5, 'Giulio', 'Pastorino', '55555', 1, 3);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (6, 'Lorenzo', 'Pastorino', 'lorepasto', 0, 1);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (7, 'Alessio', 'Oliveri', '666666', 0, 2);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (8, 'Ercole', 'Rossi', '12345', 0, 3);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (9, 'Marco', 'Rossi', 'rosmarco', 0, 2);
INSERT INTO dipendente (id, nome, cognome, psw, responsabileSala, idSala) VALUES (10, 'Alessio', 'Pastorino', 'alepasto', 1, 1);

INSERT INTO luogo (id, continente, stato) VALUES (1, 'America', 'Messico');
INSERT INTO luogo (id, continente, stato) VALUES (2, 'Oceania', 'Australia');
INSERT INTO luogo (id, continente, stato) VALUES (3, 'Asia', 'Mongolia');
INSERT INTO luogo (id, continente, stato) VALUES (4, 'Asia', 'Giappone');
INSERT INTO luogo (id, continente, stato) VALUES (5, 'America', 'Peru');
INSERT INTO luogo (id, continente, stato) VALUES (6, 'Europa', 'Spagna');
INSERT INTO luogo (id, continente, stato) VALUES (7, 'Oceania', 'Filippine');
INSERT INTO luogo (id, continente, stato) VALUES (8, 'Africa', 'Etiopia'); 

INSERT INTO cliente (email, nome, cognome, psw) VALUES ("lorenzorepetto@gmail.com", "Lorenzo", "Repetto", "123"); 

INSERT INTO biglietto (id, intervalloTempo, psw, dataAcquisto, emailCliente) VALUES (1, DATE "2022-12-31", 123456, DATE "2021-04-06", "lorenzorepetto@gmail.com");

INSERT INTO audio
(id, descrizione, percorso) VALUES (1, "Audio del reperto numero 1", "./data/audio/audio1.wav");
INSERT INTO audio
(id, descrizione, percorso) VALUES (2, "Audio del reperto numero 2", "./data/audio/audio2.wav");

INSERT INTO mesh
(id, percorsom, idNuvolaDiPunti) VALUES (1, "./data/mesh/claw/claw.obj", null);
INSERT INTO mesh
(id, percorsom, idNuvolaDiPunti) VALUES (2, "./data/mesh/dino/dino.obj", null);

INSERT INTO ritrovamento
(id, data, idLuogo) VALUES (1, DATE "1987-03-12", 1);
INSERT INTO ritrovamento
(id, data, idLuogo) VALUES (2, DATE "1956-08-10", 7);

INSERT INTO reperto
(id, nome, descrizione, larghezza, altezza, profondita, IDAudio, IDMesh, IDTeca, IDRitrovamento) VALUES (1, "Dente di Dino", "Questa è una descrizione molto accurata", 30, 50, 40, 1, 1, 3, 2);
INSERT INTO reperto
(id, nome, descrizione, larghezza, altezza, profondita, IDAudio, IDMesh, IDTeca, IDRitrovamento) VALUES (2, "Cranio", "Questa è una descrizione molto accurata2", 70, 52, 10, 2, 2, 5, 1);


INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (1, 7, "Regno", "Animalia", null);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (2, 6, "Phylum", "Chordata", 1);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (3, 5, "Classe", "Sauropsidia", 2);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (4, 4, "Ordine", "Saurischia", 3);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (5, 3, "Famiglia", "Tyrannosauridae", 4);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (6, 2, "Genere", "Tyrannosaurus", 5);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (7, 1, "Specie", "T.rex", 6);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (8, 3, "Famiglia", "Spinosauridae", 4);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (9, 2, "Genere", "Spinosaurus", 8);
INSERT INTO categoria
(id, livello, nomeCategoria, valore, idCategoriaSuperiore) VALUES (10, 1, "Specie", "S.aegyptiacus", 9);

INSERT INTO repertohacategorie(idCategoria, idReperto, probabilita)
VALUES(10, 1, 70);
INSERT INTO repertohacategorie(idCategoria, idReperto, probabilita)
VALUES(7, 1, 30);
INSERT INTO repertohacategorie(idCategoria, idReperto, probabilita)
VALUES(7, 2, 100);

INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(3,1);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(1,1);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(7,1);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(9,1);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(4,2);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(5,2);
INSERT INTO ricercatoreritrovamenti(idricercatore,idritrovamento)VALUES(8,2);

INSERT INTO foto(id, data, descrizione, percorso) VALUES (1, DATE "1997-06-09", "Questa è la descrizione della foto 1","./data/foto/foto1.png");
INSERT INTO foto(id, data, descrizione, percorso) VALUES (2, DATE "1967-11-11", "Questa è la descrizione della foto 2","./data/foto/foto2.png");
INSERT INTO foto(id, data, descrizione, percorso) VALUES (3, DATE "2020-03-05", "Questa è la descrizione della foto 3","./data/foto/foto3.png");
INSERT INTO foto(id, data, descrizione, percorso) VALUES (4, DATE "1999-12-06", "Questa è la descrizione della foto 4","./data/foto/foto4.png");

INSERT INTO fotoreperto(idfoto, idreperto) VALUES (1, 1);
INSERT INTO fotoreperto(idfoto, idreperto) VALUES (2, 2);
INSERT INTO fotoreperto(idfoto, idreperto) VALUES (3, 1);
INSERT INTO fotoreperto(idfoto, idreperto) VALUES (4, 2);
