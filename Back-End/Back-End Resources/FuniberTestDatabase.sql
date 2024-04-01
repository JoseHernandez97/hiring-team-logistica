CREATE DATABASE  IF NOT EXISTS `funiber_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `funiber_test`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: funiber_test
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Comestible'),(2,'Limpieza'),(3,'Ferreteria'),(4,'Mascotas'),(5,'Ropa');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measuring`
--

DROP TABLE IF EXISTS `measuring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measuring` (
  `id` int NOT NULL AUTO_INCREMENT,
  `measuringtype` varchar(255) DEFAULT NULL,
  `measuringname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measuring`
--

LOCK TABLES `measuring` WRITE;
/*!40000 ALTER TABLE `measuring` DISABLE KEYS */;
INSERT INTO `measuring` VALUES (1,'Kg','Kilogramos'),(2,'L','litros'),(3,'g','Gramos'),(4,'ml','Mililitros'),(5,'u','Unidaades'),(6,'lb','Libras');
/*!40000 ALTER TABLE `measuring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `code` int NOT NULL,
  `category` int DEFAULT NULL,
  `stock` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `measuring_value` int DEFAULT NULL,
  `measuring` int DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKqx9wikktsev17ctu0kcpkrafc` (`category`),
  KEY `FKqhbtqk9uhx6xiddsrxy1xgc12` (`measuring`),
  CONSTRAINT `FKqhbtqk9uhx6xiddsrxy1xgc12` FOREIGN KEY (`measuring`) REFERENCES `measuring` (`id`),
  CONSTRAINT `FKqx9wikktsev17ctu0kcpkrafc` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (111,1,_binary '','Aceite Girasol',275,4),(112,1,_binary '','Harina YA ',500,3),(113,1,_binary '','Avena Quaker ',500,3),(114,1,_binary '','CocaCola',275,4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_change_history`
--

DROP TABLE IF EXISTS `product_change_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_change_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `change_date` datetime(6) NOT NULL,
  `change_details` varchar(1000) NOT NULL,
  `change_type` varchar(255) NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jo3x7saydf0sp36k32woiudu` (`product_id`),
  CONSTRAINT `FK4jo3x7saydf0sp36k32woiudu` FOREIGN KEY (`product_id`) REFERENCES `product` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_change_history`
--

LOCK TABLES `product_change_history` WRITE;
/*!40000 ALTER TABLE `product_change_history` DISABLE KEYS */;
INSERT INTO `product_change_history` VALUES (2,'2024-03-30 12:03:19.533000','Product updated','UPDATE',111),(10,'2024-03-30 12:28:19.443000','Product created','CREATION',113),(11,'2024-03-30 12:28:45.150000','Product updated','UPDATE',111),(12,'2024-03-30 12:33:56.590000','Product updated','UPDATE',111),(13,'2024-03-30 20:17:45.335000','Product created','CREATION',114);
/*!40000 ALTER TABLE `product_change_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ecuador','Jose','Hernandez','$2a$10$DXcJUPThz3P.maOyVtvkYe2/6VDLeMjnZIhaMEw3L/PX8/annYQb6','ADMIN','TheCheo@gmail.com'),(2,'Ecuador','Darik','Mendoza','$2a$10$T7W.pXQZcTiEi1wYvGtwdelnBYMn2WKaP1akrjpPYzKyJexDwQCSa','ADMIN','Thedarik@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 10:12:22
