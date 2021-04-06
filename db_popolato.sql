-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.14-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database museoricoale
CREATE DATABASE IF NOT EXISTS `museoricoale` /*!40100 DEFAULT CHARACTER SET latin7 */;
USE `museoricoale`;

-- Dump della struttura di tabella museoricoale.audio
CREATE TABLE IF NOT EXISTS `audio` (
  `ID` int(11) NOT NULL,
  `descrizione` varchar(2048) DEFAULT NULL,
  `percorso` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `percorso` (`percorso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.audio: ~0 rows (circa)
/*!40000 ALTER TABLE `audio` DISABLE KEYS */;
/*!40000 ALTER TABLE `audio` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.biglietto
CREATE TABLE IF NOT EXISTS `biglietto` (
  `ID` int(11) NOT NULL,
  `intervalloTempo` date DEFAULT NULL,
  `psw` varchar(256) DEFAULT NULL,
  `dataAcquisto` date DEFAULT NULL,
  `emailCliente` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `emailCliente` (`emailCliente`),
  CONSTRAINT `biglietto_ibfk_1` FOREIGN KEY (`emailCliente`) REFERENCES `cliente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.biglietto: ~1 rows (circa)
/*!40000 ALTER TABLE `biglietto` DISABLE KEYS */;
INSERT INTO `biglietto` (`ID`, `intervalloTempo`, `psw`, `dataAcquisto`, `emailCliente`) VALUES
	(1, '2022-12-31', '123456', '2021-04-06', 'lorenzorepetto@gmail.com');
/*!40000 ALTER TABLE `biglietto` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `ID` int(11) NOT NULL,
  `livello` int(11) DEFAULT NULL,
  `nomeCategoria` varchar(256) DEFAULT NULL,
  `valore` varchar(256) DEFAULT NULL,
  `idCategoriaSuperiore` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idCategoriaSuperiore` (`idCategoriaSuperiore`),
  CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`idCategoriaSuperiore`) REFERENCES `categoria` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.categoria: ~0 rows (circa)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `email` varchar(256) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `cognome` varchar(256) DEFAULT NULL,
  `psw` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.cliente: ~1 rows (circa)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`email`, `nome`, `cognome`, `psw`) VALUES
	('lorenzorepetto@gmail.com', 'Lorenzo', 'Repetto', '123');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.dipendente
CREATE TABLE IF NOT EXISTS `dipendente` (
  `ID` int(11) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `cognome` varchar(256) DEFAULT NULL,
  `psw` varchar(256) DEFAULT NULL,
  `responsabileSala` bit(1) DEFAULT NULL,
  `idSala` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idSala` (`idSala`),
  CONSTRAINT `dipendente_ibfk_1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.dipendente: ~10 rows (circa)
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` (`ID`, `nome`, `cognome`, `psw`, `responsabileSala`, `idSala`) VALUES
	(1, 'Alessio', 'Pelizzoni', '1234', b'0', 4),
	(2, 'Paolo', 'Rossi', 'paolo', b'1', 4),
	(3, 'Daniele', 'Pelizzoni', 'dani', b'0', 6),
	(4, 'Marco', 'Oliveri', '4444', b'1', 5),
	(5, 'Giulio', 'Pastorino', '55555', b'1', 3),
	(6, 'Lorenzo', 'Pastorino', 'lorepasto', b'0', 1),
	(7, 'Alessio', 'Oliveri', '666666', b'0', 2),
	(8, 'Ercole', 'Rossi', '12345', b'0', 3),
	(9, 'Marco', 'Rossi', 'rosmarco', b'0', 2),
	(10, 'Alessio', 'Pastorino', 'alepasto', b'1', 1);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.foto
CREATE TABLE IF NOT EXISTS `foto` (
  `ID` int(11) NOT NULL,
  `Data` date DEFAULT NULL,
  `descrizione` varchar(2048) DEFAULT NULL,
  `percorso` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `percorso` (`percorso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.foto: ~0 rows (circa)
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.fotoreperto
CREATE TABLE IF NOT EXISTS `fotoreperto` (
  `IDFoto` int(11) NOT NULL,
  `IDReperto` int(11) NOT NULL,
  PRIMARY KEY (`IDFoto`,`IDReperto`),
  KEY `IDReperto` (`IDReperto`),
  CONSTRAINT `fotoreperto_ibfk_1` FOREIGN KEY (`IDFoto`) REFERENCES `foto` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fotoreperto_ibfk_2` FOREIGN KEY (`IDReperto`) REFERENCES `reperto` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.fotoreperto: ~0 rows (circa)
/*!40000 ALTER TABLE `fotoreperto` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotoreperto` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.luogo
CREATE TABLE IF NOT EXISTS `luogo` (
  `ID` int(11) NOT NULL,
  `continente` varchar(256) DEFAULT NULL,
  `stato` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.luogo: ~8 rows (circa)
/*!40000 ALTER TABLE `luogo` DISABLE KEYS */;
INSERT INTO `luogo` (`ID`, `continente`, `stato`) VALUES
	(1, 'America', 'Messico'),
	(2, 'Oceania', 'Australia'),
	(3, 'Asia', 'Mongolia'),
	(4, 'Asia', 'Giappone'),
	(5, 'America', 'Peru'),
	(6, 'Europa', 'Spagna'),
	(7, 'Oceania', 'Filippine'),
	(8, 'Africa', 'Etiopia');
/*!40000 ALTER TABLE `luogo` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.mesh
CREATE TABLE IF NOT EXISTS `mesh` (
  `ID` int(11) NOT NULL,
  `percorso` varchar(512) DEFAULT NULL,
  `IDNuvolaDiPunti` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `percorso` (`percorso`),
  KEY `IDNuvolaDiPunti` (`IDNuvolaDiPunti`),
  CONSTRAINT `mesh_ibfk_1` FOREIGN KEY (`IDNuvolaDiPunti`) REFERENCES `nuvoladipunti` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.mesh: ~0 rows (circa)
/*!40000 ALTER TABLE `mesh` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesh` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.nuvoladipunti
CREATE TABLE IF NOT EXISTS `nuvoladipunti` (
  `ID` int(11) NOT NULL,
  `percorso` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `percorso` (`percorso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.nuvoladipunti: ~0 rows (circa)
/*!40000 ALTER TABLE `nuvoladipunti` DISABLE KEYS */;
/*!40000 ALTER TABLE `nuvoladipunti` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.reperto
CREATE TABLE IF NOT EXISTS `reperto` (
  `ID` int(11) NOT NULL,
  `larghezza` float DEFAULT NULL,
  `altezza` float DEFAULT NULL,
  `profondita` float DEFAULT NULL,
  `IDAudio` int(11) DEFAULT NULL,
  `IDMesh` int(11) DEFAULT NULL,
  `IDTeca` int(11) DEFAULT NULL,
  `IDRitrovamento` int(11) DEFAULT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `descrizione` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDAudio` (`IDAudio`),
  KEY `IDMesh` (`IDMesh`),
  KEY `IDTeca` (`IDTeca`),
  KEY `IDRitrovamento` (`IDRitrovamento`),
  CONSTRAINT `reperto_ibfk_1` FOREIGN KEY (`IDAudio`) REFERENCES `audio` (`ID`),
  CONSTRAINT `reperto_ibfk_2` FOREIGN KEY (`IDMesh`) REFERENCES `mesh` (`ID`),
  CONSTRAINT `reperto_ibfk_3` FOREIGN KEY (`IDTeca`) REFERENCES `teca` (`ID`),
  CONSTRAINT `reperto_ibfk_4` FOREIGN KEY (`IDRitrovamento`) REFERENCES `ritrovamento` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.reperto: ~0 rows (circa)
/*!40000 ALTER TABLE `reperto` DISABLE KEYS */;
/*!40000 ALTER TABLE `reperto` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.repertohacategorie
CREATE TABLE IF NOT EXISTS `repertohacategorie` (
  `IDCategoria` int(11) NOT NULL,
  `IDReperto` int(11) NOT NULL,
  PRIMARY KEY (`IDCategoria`,`IDReperto`),
  KEY `IDReperto` (`IDReperto`),
  CONSTRAINT `repertohacategorie_ibfk_1` FOREIGN KEY (`IDCategoria`) REFERENCES `categoria` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `repertohacategorie_ibfk_2` FOREIGN KEY (`IDReperto`) REFERENCES `reperto` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.repertohacategorie: ~0 rows (circa)
/*!40000 ALTER TABLE `repertohacategorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `repertohacategorie` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.ricercatore
CREATE TABLE IF NOT EXISTS `ricercatore` (
  `ID` int(11) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `cognome` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.ricercatore: ~10 rows (circa)
/*!40000 ALTER TABLE `ricercatore` DISABLE KEYS */;
INSERT INTO `ricercatore` (`ID`, `nome`, `cognome`) VALUES
	(1, 'Amelia', 'Buck'),
	(2, 'Lauren', 'Burton'),
	(3, 'Victoria', 'Page'),
	(4, 'Rosa', 'Dunn'),
	(5, 'Haroon', 'Franklin'),
	(6, 'George', 'Berry'),
	(7, 'Lucas', 'Johnston'),
	(8, 'Eric', 'Mcbride'),
	(9, 'Travis', 'Burke'),
	(10, 'Tommy', 'Rivera');
/*!40000 ALTER TABLE `ricercatore` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.ricercatoreritrovamenti
CREATE TABLE IF NOT EXISTS `ricercatoreritrovamenti` (
  `IDRicercatore` int(11) NOT NULL,
  `IDRitrovamento` int(11) NOT NULL,
  PRIMARY KEY (`IDRicercatore`,`IDRitrovamento`),
  KEY `IDRitrovamento` (`IDRitrovamento`),
  CONSTRAINT `ricercatoreritrovamenti_ibfk_1` FOREIGN KEY (`IDRicercatore`) REFERENCES `ricercatore` (`ID`),
  CONSTRAINT `ricercatoreritrovamenti_ibfk_2` FOREIGN KEY (`IDRitrovamento`) REFERENCES `ritrovamento` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.ricercatoreritrovamenti: ~0 rows (circa)
/*!40000 ALTER TABLE `ricercatoreritrovamenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `ricercatoreritrovamenti` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.ritrovamento
CREATE TABLE IF NOT EXISTS `ritrovamento` (
  `ID` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `idLuogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idLuogo` (`idLuogo`),
  CONSTRAINT `ritrovamento_ibfk_1` FOREIGN KEY (`idLuogo`) REFERENCES `luogo` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.ritrovamento: ~0 rows (circa)
/*!40000 ALTER TABLE `ritrovamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `ritrovamento` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `ID` int(11) NOT NULL,
  `periodo` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.sala: ~6 rows (circa)
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` (`ID`, `periodo`) VALUES
	(1, 'Giurassico'),
	(2, 'Cretacico'),
	(3, 'Triassico'),
	(4, 'Carbonifero'),
	(5, 'Permiano'),
	(6, 'Cambriano');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;

-- Dump della struttura di tabella museoricoale.teca
CREATE TABLE IF NOT EXISTS `teca` (
  `ID` int(11) NOT NULL,
  `larghezza` float DEFAULT NULL,
  `altezza` float DEFAULT NULL,
  `profondita` float DEFAULT NULL,
  `IDSala` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDSala` (`IDSala`),
  CONSTRAINT `teca_ibfk_1` FOREIGN KEY (`IDSala`) REFERENCES `sala` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- Dump dei dati della tabella museoricoale.teca: ~10 rows (circa)
/*!40000 ALTER TABLE `teca` DISABLE KEYS */;
INSERT INTO `teca` (`ID`, `larghezza`, `altezza`, `profondita`, `IDSala`) VALUES
	(1, 3, 4, 5, 6),
	(2, 5, 2, 3, 5),
	(3, 2, 1.5, 2, 3),
	(4, 3, 4, 5, 4),
	(5, 6, 3, 2, 1),
	(6, 3, 3, 3, 2),
	(7, 3, 5, 4, 6),
	(8, 4, 6, 3, 1),
	(9, 2, 4, 5, 6),
	(10, 3, 2, 5, 4);
/*!40000 ALTER TABLE `teca` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
