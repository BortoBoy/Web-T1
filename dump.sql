-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: ConsultasMedicasDB
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Consulta`
--

DROP TABLE IF EXISTS `Consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Consulta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ano` int DEFAULT NULL,
  `mes` int DEFAULT NULL,
  `dia` int DEFAULT NULL,
  `hora` int DEFAULT NULL,
  `minuto` int DEFAULT NULL,
  `cpf_paciente` varchar(20) DEFAULT NULL,
  `crm_medico` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf_paciente` (`cpf_paciente`),
  KEY `crm_medico` (`crm_medico`),
  CONSTRAINT `Consulta_ibfk_1` FOREIGN KEY (`cpf_paciente`) REFERENCES `Paciente` (`cpf`),
  CONSTRAINT `Consulta_ibfk_2` FOREIGN KEY (`crm_medico`) REFERENCES `Medico` (`crm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta`
--

LOCK TABLES `Consulta` WRITE;
/*!40000 ALTER TABLE `Consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico` (
  `email` varchar(256) DEFAULT NULL,
  `senha` varchar(48) DEFAULT NULL,
  `crm` varchar(48) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `especialidade` int DEFAULT NULL,
  PRIMARY KEY (`crm`),
  UNIQUE KEY `crm` (`crm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
INSERT INTO `Medico` VALUES ('medico2@email.com','medico2','142342/BA','Jãozinho Mão Tremida',1),('medico1@email.com','medico1','31231/SP','Fabrício Inácio da Silva',0),('medico3@email.com','medico3','3487/GO','Cícero Alvez de Caminha',2);
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paciente` (
  `email` varchar(256) DEFAULT NULL,
  `senha` varchar(48) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `sexo` int DEFAULT NULL,
  `aniversario` date DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES ('paciente2@email.com','paciente2','123.123.123-12','Mário Lanche Feliz','+5516943214321',0,'1991-05-02'),('paciente1@email.com','paciente1','145.345.654-33','Faber Castel dos Reis','+5516912341234',0,'1998-04-01'),('paciente3@email.com','paciente3','321.321.321-32','Ines Quecível a Souza','+5516901230123',0,'2003-07-10');
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 22:03:17
