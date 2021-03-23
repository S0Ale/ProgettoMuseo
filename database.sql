CREATE TABLE Cliente(
    email varchar(256) PRIMARY KEY,
    nome varchar(256),
    cognome varchar(256),
    psw varchar(256)
);

CREATE TABLE Biglietto(
    ID int PRIMARY KEY,
    intervalloTempo date,
    psw varchar(256),
    dataAcquisto date,
    emailCliente varchar(256),
    FOREIGN KEY (emailCliente) REFERENCES Cliente(email) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Audio(
    ID int PRIMARY KEY,
    descrizione varchar(2048),
    percorso varchar(512) unique
);

CREATE TABLE NuvolaDiPunti(
    ID int PRIMARY KEY,
    percorso varchar(512) unique
);

CREATE TABLE Mesh(
    ID int PRIMARY KEY,
    percorso varchar(512) unique,
    IDNuvolaDiPunti int,
    FOREIGN KEY (IDNuvolaDiPunti) REFERENCES NuvolaDiPunti(ID) ON DELETE SET NULL
);

CREATE TABLE Foto(
    ID int PRIMARY KEY,
    Data date,
    descrizione varchar(2048),
    percorso varchar(512) unique
);

CREATE TABLE Categoria(
    ID int PRIMARY KEY,
    livello int,
    nomeCategoria varchar(256),
    valore varchar(256),
    idCategoriaSuperiore int,
    FOREIGN KEY (idCategoriaSuperiore) REFERENCES Categoria(ID) ON DELETE CASCADE
);

CREATE TABLE Sala(
    ID int PRIMARY KEY,
    periodo varchar(256)
);

CREATE TABLE Teca(
    ID int PRIMARY KEY,
    larghezza float,
    altezza float,
    profondita float,
    IDSala int,
    FOREIGN KEY (IDSala) REFERENCES Sala(ID)
);

CREATE TABLE Dipendente(
    ID int PRIMARY KEY,
    nome varchar(256),
    cognome varchar(256),
    psw varchar(256),
    responsabileSala bit,
    idSala int,
    FOREIGN KEY (IDSala) REFERENCES Sala(ID)
);

CREATE TABLE Luogo(
    ID int PRIMARY KEY,
    continente varchar(256),
    stato varchar(256)
);

CREATE TABLE Ritrovamento(
    ID int PRIMARY KEY,
    data date,
    idLuogo int,
    FOREIGN KEY (idLuogo) REFERENCES Luogo(ID)
);

CREATE TABLE Ricercatore(
    ID int PRIMARY KEY,
    nome varchar(256),
    cognome varchar(256)
);

CREATE TABLE RicercatoreRitrovamenti(
    IDRicercatore int,
    IDRitrovamento int,
    PRIMARY KEY(IDRicercatore, IDRitrovamento),
    FOREIGN KEY (idRicercatore) REFERENCES Ricercatore(ID),
    FOREIGN KEY (idRitrovamento) REFERENCES Ritrovamento(ID)
);

CREATE TABLE Reperto(
    ID int PRIMARY KEY,
    larghezza float,
    altezza float,
    profondita float,
    IDAudio int,
    IDMesh int,
    IDTeca int,
    IDRitrovamento int,
    FOREIGN KEY (idAudio) REFERENCES Audio(ID),
    FOREIGN KEY (idMesh) REFERENCES Mesh(ID),
    FOREIGN KEY (idTeca) REFERENCES Teca(ID),
    FOREIGN KEY (idRitrovamento) REFERENCES Ritrovamento(ID)
);

CREATE TABLE FotoReperto(
    IDFoto int,
    IDReperto int,
    PRIMARY KEY(IDFoto, IDReperto),
    FOREIGN KEY (idFoto) REFERENCES Foto(ID) ON DELETE CASCADE,
    FOREIGN KEY (idReperto) REFERENCES Reperto(ID) ON DELETE CASCADE
);

CREATE TABLE RepertoHaCategorie(
    IDCategoria int,
    IDReperto int,
    PRIMARY KEY(IDCategoria, IDReperto),
    FOREIGN KEY (idCategoria) REFERENCES Categoria(ID) ON DELETE CASCADE,
    FOREIGN KEY (idReperto) REFERENCES Reperto(ID) ON DELETE CASCADE
);
