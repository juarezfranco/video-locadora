CREATE DATABASE  IF NOT EXISTS `locadoralp2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `locadoralp2`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: locadoralp2
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(15) NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'catálogo',7),(2,'promoção',3),(3,'lançamento',10.3);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `cpf` varchar(15) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `telefone` varchar(80) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('333.333.333-33','rewewrok','fioejfoj','(34)3243-2432');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copia_filmes`
--

DROP TABLE IF EXISTS `copia_filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copia_filmes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filmeId` int(11) NOT NULL,
  `data_aquisicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_aquisicao` double NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `motivo_remocao` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `filmeId` (`filmeId`),
  CONSTRAINT `copia_filmes_ibfk_1` FOREIGN KEY (`filmeId`) REFERENCES `filmes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copia_filmes`
--

LOCK TABLES `copia_filmes` WRITE;
/*!40000 ALTER TABLE `copia_filmes` DISABLE KEYS */;
INSERT INTO `copia_filmes` VALUES (1,1,'2014-07-15 23:12:51',66,NULL,'locada',NULL),(2,1,'2014-07-15 23:12:51',66,NULL,'disponivel',NULL);
/*!40000 ALTER TABLE `copia_filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copias_reservadas`
--

DROP TABLE IF EXISTS `copias_reservadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copias_reservadas` (
  `clienteId` varchar(15) NOT NULL,
  `copia_filmeId` int(11) NOT NULL,
  PRIMARY KEY (`clienteId`,`copia_filmeId`),
  KEY `copia_filmeId` (`copia_filmeId`),
  CONSTRAINT `copias_reservadas_ibfk_1` FOREIGN KEY (`clienteId`) REFERENCES `clientes` (`cpf`),
  CONSTRAINT `copias_reservadas_ibfk_2` FOREIGN KEY (`copia_filmeId`) REFERENCES `copia_filmes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copias_reservadas`
--

LOCK TABLES `copias_reservadas` WRITE;
/*!40000 ALTER TABLE `copias_reservadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `copias_reservadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filmes`
--

DROP TABLE IF EXISTS `filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) NOT NULL,
  `assunto` varchar(80) NOT NULL,
  `categoria` varchar(80) NOT NULL,
  `oscar` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmes`
--

LOCK TABLES `filmes` WRITE;
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` VALUES (1,'kisdfjijdasj','comédia','lançamento','');
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_espera_de_reservas`
--

DROP TABLE IF EXISTS `lista_espera_de_reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_espera_de_reservas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reservaId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reservaId` (`reservaId`),
  CONSTRAINT `lista_espera_de_reservas_ibfk_1` FOREIGN KEY (`reservaId`) REFERENCES `reservas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_espera_de_reservas`
--

LOCK TABLES `lista_espera_de_reservas` WRITE;
/*!40000 ALTER TABLE `lista_espera_de_reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_espera_de_reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clienteId` varchar(15) NOT NULL,
  `copia_filmesId` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `clienteId` (`clienteId`),
  KEY `copia_filmesId` (`copia_filmesId`),
  CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`clienteId`) REFERENCES `clientes` (`cpf`),
  CONSTRAINT `locacao_ibfk_2` FOREIGN KEY (`copia_filmesId`) REFERENCES `copia_filmes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,'333.333.333-33',1,'2014-07-15 23:14:08');
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clienteId` varchar(15) NOT NULL,
  `filmeId` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `clienteId` (`clienteId`),
  KEY `filmeId` (`filmeId`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`clienteId`) REFERENCES `clientes` (`cpf`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`filmeId`) REFERENCES `filmes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-15 21:36:17
