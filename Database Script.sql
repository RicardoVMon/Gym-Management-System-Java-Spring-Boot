CREATE DATABASE  IF NOT EXISTS `gymapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gymapp`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: gymapp
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejercicio` (
  `id_ejercicio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio`
--

LOCK TABLES `ejercicio` WRITE;
/*!40000 ALTER TABLE `ejercicio` DISABLE KEYS */;
INSERT INTO `ejercicio` VALUES (1,'Press de banca'),(2,'Sentadillas'),(3,'Dominadas'),(4,'Press militar'),(5,'Flexiones'),(6,'Plancha'),(7,'Zancadas'),(8,'Abdominales'),(35,'Backflips'),(36,'Triple Backflips'),(37,'Pull-Ups Intermedio');
/*!40000 ALTER TABLE `ejercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejercicio_rutina`
--

DROP TABLE IF EXISTS `ejercicio_rutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejercicio_rutina` (
  `id_ejercicio_rutina` int NOT NULL AUTO_INCREMENT,
  `id_ejercicio` int DEFAULT NULL,
  `id_rutina` int DEFAULT NULL,
  `series` int DEFAULT NULL,
  `repeticiones` int DEFAULT NULL,
  `peso_previo` decimal(6,2) DEFAULT NULL,
  `peso_actual` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio_rutina`),
  KEY `id_rutina` (`id_rutina`),
  KEY `id_ejercicio` (`id_ejercicio`),
  CONSTRAINT `ejercicio_rutina_ibfk_1` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`),
  CONSTRAINT `ejercicio_rutina_ibfk_2` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicio` (`id_ejercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio_rutina`
--

LOCK TABLES `ejercicio_rutina` WRITE;
/*!40000 ALTER TABLE `ejercicio_rutina` DISABLE KEYS */;
INSERT INTO `ejercicio_rutina` VALUES (13,5,2,3,15,0.00,0.00),(14,6,2,2,30,0.00,0.00),(15,7,2,3,12,20.00,25.00),(16,8,2,4,20,0.00,0.00),(21,1,1,4,10,50.00,55.00),(22,2,1,3,12,60.00,65.00),(23,3,1,5,8,0.00,0.00),(24,4,1,15,3,15.00,15.00),(25,1,3,4,10,50.00,55.00),(26,2,3,3,12,60.00,65.00),(27,3,3,5,8,0.00,0.00),(28,4,3,5,10,40.00,45.00),(36,3,7,1,5,0.00,0.00),(37,1,7,2,5,0.00,0.00),(38,6,7,3,5,0.00,0.00),(39,8,7,4,5,0.00,0.00),(48,8,13,1,2,1.00,5.00),(49,3,13,1,3,10.00,5.00);
/*!40000 ALTER TABLE `ejercicio_rutina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estiramiento`
--

DROP TABLE IF EXISTS `estiramiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estiramiento` (
  `id_estiramiento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` text,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estiramiento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estiramiento`
--

LOCK TABLES `estiramiento` WRITE;
/*!40000 ALTER TABLE `estiramiento` DISABLE KEYS */;
INSERT INTO `estiramiento` VALUES (1,'Movilidad','Prepara tu cuerpo con movilidad antes del ejercicio. ¡Optimiza tu rendimiento y reduce el riesgo de lesiones con estos breves ejercicios!','https://www.youtube.com/embed/5aAkskctYGY?si=ItJITk-HxpArosNZ'),(2,'Estiramientos','Los estiramientos después del entrenamiento son esenciales para mantener la flexibilidad yprevenir lesiones. Dedica tiempo a estirar tus músculos paramejorar la recuperación y mantener tu cuerpo en óptimas condiciones.','https://www.youtube.com/embed/YQQfhILVR7c?si=xl2FQfWGdVEqi4l0'),(3,'Yoga','Ayuda a preparar tu cuerpo y mente para el entrenamiento con estiramientos de yoga. Estirar antes de ejercitarte mejora la flexibilidad y reduce el riesgo de lesiones. ¡Inténtalo hoy!','https://www.youtube.com/embed/d-xp2uOl3Gc?si=2aOEL8BBdyH6Gq77'),(4,'Flexibilidad','Los ejercicios de flexibilidad son fundamentales para mantener la amplitud de movimiento en las articulaciones, lo que ayuda a prevenir lesiones, mejora la postura y favorece la circulación sanguínea, contribuyendo así a la salud y el bienestar general del cuerpo.','https://www.youtube.com/embed/y87vSUoIMGU?si=UpQ2ax13ONpWs5Eo');
/*!40000 ALTER TABLE `estiramiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medida`
--

DROP TABLE IF EXISTS `medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medida` (
  `id_medida` int NOT NULL AUTO_INCREMENT,
  `peso` decimal(10,2) DEFAULT NULL,
  `grasa` decimal(5,2) DEFAULT NULL,
  `cuello` decimal(10,2) DEFAULT NULL,
  `hombros` decimal(10,2) DEFAULT NULL,
  `bicep_izquierdo` decimal(10,2) DEFAULT NULL,
  `bicep_derecho` decimal(10,2) DEFAULT NULL,
  `cintura` decimal(10,2) DEFAULT NULL,
  `cadera` decimal(10,2) DEFAULT NULL,
  `muslo_izquierdo` decimal(10,2) DEFAULT NULL,
  `muslo_derecho` decimal(10,2) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_medida`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `medida_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medida`
--

LOCK TABLES `medida` WRITE;
/*!40000 ALTER TABLE `medida` DISABLE KEYS */;
/*!40000 ALTER TABLE `medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_rol`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `rol_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',2),(3,'ROLE_USER',3),(8,'ROLE_USER',NULL),(11,'ROLE_USER',10);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutina`
--

DROP TABLE IF EXISTS `rutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutina` (
  `id_rutina` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_rutina`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `rutina_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutina`
--

LOCK TABLES `rutina` WRITE;
/*!40000 ALTER TABLE `rutina` DISABLE KEYS */;
INSERT INTO `rutina` VALUES (1,'Rutina de Fiorella',2),(2,'Rutina de Daniel',3),(3,'Rutina de Fiorella 2',2),(7,'EJERCICIO PRUEBA',3),(13,'PRUEBA 3',2);
/*!40000 ALTER TABLE `rutina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(512) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ricardo','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Ricardo','Vargas','ricardo@admin.com','Masculino'),(2,'fiorella','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Fiorella','Hernández','fiorella@user.com','Femenino'),(3,'daniel','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Daniel','Vega','daniel@user.com','Masculino'),(10,'juan28','$2a$10$pTEt8gVButPICF2CCacKUe7v8HUK6MrqWX4E/l8eTIBLHpEm0ZrPO','Juan','Vargas','juan@gmail.com','Masculino');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gymapp'
--

--
-- Dumping routines for database 'gymapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-20 18:20:24
