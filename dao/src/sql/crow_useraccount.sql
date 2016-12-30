CREATE DATABASE  IF NOT EXISTS `crow` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `crow`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: crow
-- ------------------------------------------------------
-- Server version	5.5.53

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
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `createdDate` datetime NOT NULL,
  `email` varchar(65) NOT NULL,
  `id` int(11) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `password` varchar(65) NOT NULL,
  `username` varchar(65) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_UserAccount_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` VALUES ('2016-11-30 16:01:16','admin@noemail.com',560,1,'$2a$10$IsfNW2FYO4DKtvIoX1Sn7O35QbrRMC7SG0qvq0AnZg9R8dCtPojBy','admin'),('2016-11-30 16:02:28','test@test.com',561,0,'$2a$10$2gkmv4I9LiFN/n1a4N3FoO2CViWcCjdLqvqex7m3Bg19CECKUTrxq','test'),('2016-12-01 00:19:45','shivani@test.com',620,0,'$2a$10$V8VXvztMMCH9GBAhrgqahu6ODnwUVGx/Ez0lfoltkJBFOAtH4EwO6','shivani'),('2016-12-01 19:42:35','taran@test.com',640,0,'$2a$10$/je62XgqzB5nKkGy03F2kOYwZ7gmuYFrNLTs4FSvYminM/eWNxONS','taran'),('2016-12-01 21:06:49','usertester@abc.com',681,0,'$2a$10$sclagPl.gPGIsvJUJy0.ReQKl0TeovMSkYTo5I7A0D9jYJb37RCQW','testuser'),('2016-12-01 21:33:05','new@user.com',701,0,'$2a$10$SoWxZ6ZWQzYV2VXBZstx1uc/MseA7gJEqTga7SKlZCNOT4jKBgkNe','nuser'),('2016-12-05 22:47:12','testmeila@somthing.com',721,0,'$2a$10$zaFs72YeTDDW1AGoshdpxOer4og/l8P9a1DoXMB7OeIu/8L.7eh6C','something'),('2016-12-05 22:47:46','yyyy@hhh.com',722,0,'$2a$10$3fnnZ9.Jb/pQef1jqB18Yuez/PtZz7U0gFRu4Hl5uJdYIdCOOO/Lq','yyysss'),('2016-12-18 18:29:10','preeth@test.com',760,0,'$2a$10$k78yTjJMqBdOMAqSAgr.lu81QNsQ5IS8LUWSU9Aj9aTnk.V2dKpo6','preetha'),('2016-12-18 21:30:50','ASasSa@asd.com',800,0,'$2a$10$84Kl5a/sbbk68c0SrsGr9.UG1XWO9ieL6KuRiRRWZC5DfW1vjjwJ.','sjrjrkejf');
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-30 18:22:15
