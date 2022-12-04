-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: employees
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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `department_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `head_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi2vmr37p9w31xhpoqq0kpmcll` (`head_id`),
  CONSTRAINT `FKi2vmr37p9w31xhpoqq0kpmcll` FOREIGN KEY (`head_id`) REFERENCES `instructors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'DEP01','CNTT',1),(2,'DEP02','KT',2);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) DEFAULT NULL,
  `emp_no` varchar(10) NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `UK_pq46prq9ax5kg307r1yxjovuc` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'EMP01','Text1'),(2,'EMP02','Text2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructors`
--

DROP TABLE IF EXISTS `instructors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) DEFAULT NULL,
  `end_day` datetime(6) DEFAULT NULL,
  `instructor_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_day` datetime(6) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc2nbeps18k9tww0ri3ny8rpk` (`department_id`),
  KEY `FKfswvo86o445sfl02qhpr0lch` (`username`),
  CONSTRAINT `FKc2nbeps18k9tww0ri3ny8rpk` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `FKfswvo86o445sfl02qhpr0lch` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructors`
--

LOCK TABLES `instructors` WRITE;
/*!40000 ALTER TABLE `instructors` DISABLE KEYS */;
INSERT INTO `instructors` VALUES (1,'1990-06-12 00:00:00.000000','2019-06-12 00:00:00.000000','GV01','Nguyen Van A','2018-06-12 00:00:00.000000',1,'teacher01'),(2,'1895-06-12 00:00:00.000000','2018-06-12 00:00:00.000000','GV02','Nguyen Thi B','2015-06-12 00:00:00.000000',1,'teacher02'),(3,'1975-06-12 00:00:00.000000','2020-06-12 00:00:00.000000','GV03','Le Thi B','2018-06-12 00:00:00.000000',2,'teacher03');
/*!40000 ALTER TABLE `instructors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) DEFAULT NULL,
  `end_day` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_day` datetime(6) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKalgc33nsolpmegw14o3h6g6rr` (`department_id`),
  KEY `FK395tirigxjifjgyretmm92r7o` (`topic_id`),
  KEY `FK6iyf19nupmev617yfrcj10yyp` (`username`),
  CONSTRAINT `FK395tirigxjifjgyretmm92r7o` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`),
  CONSTRAINT `FK6iyf19nupmev617yfrcj10yyp` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `FKalgc33nsolpmegw14o3h6g6rr` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'2002-01-01 00:00:00.000000','2020-01-01 00:00:00.000000','Nguyen Van A','2019-01-01 00:00:00.000000','SV01',1,1,'student01'),(2,'2001-01-01 00:00:00.000000','2021-01-01 00:00:00.000000','Nguyen Thi B','2020-01-01 00:00:00.000000','SV02',2,1,'student02');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topics` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_day` datetime(6) DEFAULT NULL,
  `start_day` datetime(6) DEFAULT NULL,
  `status` int NOT NULL,
  `topic_id` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `instructor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnjufsnsv9rtvmyp7seo42dyxu` (`department_id`),
  KEY `FKiqud3ulyrxotbua8uq86rcphm` (`instructor_id`),
  CONSTRAINT `FKiqud3ulyrxotbua8uq86rcphm` FOREIGN KEY (`instructor_id`) REFERENCES `instructors` (`id`),
  CONSTRAINT `FKnjufsnsv9rtvmyp7seo42dyxu` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (1,'CNPM','2020-01-01 00:00:00.000000','2019-01-01 00:00:00.000000',0,'T01',1,1),(2,'ATTT','2021-01-01 00:00:00.000000','2020-01-01 00:00:00.000000',1,'T02',1,2),(3,'HTTT','2022-01-01 00:00:00.000000','2021-01-01 00:00:00.000000',2,'T03',2,3);
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'teacher01','ROLE_ADMIN','teacher01'),(2,'teacher02','ROLE_USER','teacher02'),(3,'teacher03','ROLE_USER','teacher03'),(4,'student01','ROLE_USER','student01'),(5,'student02','ROLE_USER','student02'),(6,'admin','ROLE_ADMIN','admin'),(7,'user','ROLE_USER','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 22:12:46
