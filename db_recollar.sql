-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_recollar
-- ------------------------------------------------------
-- Server version	5.7.31
drop database db_recollar;
create database db_recollar;
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
-- Table structure for table `collector`
--
use db_recollar;
DROP TABLE IF EXISTS `collector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collector` (
  `id_collector` int(11) NOT NULL AUTO_INCREMENT,
  `id_person` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `tx_date` datetime NOT NULL,
  `tx_id_user` int(11) NOT NULL,
  `tx_host` varchar(100) NOT NULL,
  `tx_update` datetime NOT NULL,
  PRIMARY KEY (`id_collector`),
  KEY `collector_person` (`id_person`),
  KEY `collector_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collector`
--

LOCK TABLES `collector` WRITE;
/*!40000 ALTER TABLE `collector` DISABLE KEYS */;
INSERT INTO `collector` VALUES (1,2,19,1,'','2021-09-23 00:00:00',1,'192.168.0.3','2021-09-23 00:00:00');
/*!40000 ALTER TABLE `collector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h_user`
--

DROP TABLE IF EXISTS `h_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `h_user` (
  `id_h_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `tx_date` datetime NOT NULL,
  `tx_id_user` int(11) NOT NULL,
  `tx_host` varchar(100) NOT NULL,
  `tx_update` datetime NOT NULL,
  PRIMARY KEY (`id_h_user`),
  KEY `h_user_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_user`
--

LOCK TABLES `h_user` WRITE;
/*!40000 ALTER TABLE `h_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `h_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_person` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `tx_date` datetime NOT NULL,
  `tx_id_user` int(11) NOT NULL,
  `tx_host` varchar(100) NOT NULL,
  `tx_update` datetime NOT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (2,'Alvin','Poma Tarqui','77765282',1,'2021-09-23 00:00:00',1,'192.168.0.3','2021-09-23 00:00:00');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `tx_date` datetime NOT NULL,
  `tx_id_user` int(11) NOT NULL,
  `tx_host` varchar(100) NOT NULL,
  `tx_update` datetime NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$1YnwSip5Az2MweCq3Kup3O6I0r7YF.SceIucvLEUJxx/q5etNhTQq','pomaalvin@gmail.com',1,'2021-09-19 21:52:43',1,'172.0.0.1','2021-09-19 21:52:58'),(4,'$2a$10$PDZRo5OoO33XT54qhqgoyueOntYfiRq5hyI4kM8l9gOg3591XEHFS','poma.tarqui.alvin@gmail.com',1,'2021-09-23 00:00:00',1,'192.168.0.3','2021-09-23 00:00:00'),(19,'$2a$10$PlPLFjHBZbpef5xUwyOoROQWIHrruEfRt8SnStOHWLOAZXe.VZJGC','poma.alvin.jamil@gmail.com',1,'2021-09-23 00:00:00',1,'192.168.0.3','2021-09-23 00:00:00');
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

-- Dump completed on 2021-10-11  9:54:54

CREATE TABLE category (
                          id_category int NOT NULL AUTO_INCREMENT,
                          name varchar(50) NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id_category)
);

INSERT INTO category VALUES (1,"monedas"),(2,"figuras de accion");

-- Table: collection

CREATE TABLE collection (
                            id_collection int NOT NULL AUTO_INCREMENT,
                            id_collector int NOT NULL,
                            name varchar(100) NOT NULL,
                            color varchar(6) NOT NULL,
                            amount int NOT NULL,
                            id_category int NOT NULL,
                            status int(2) NOT NULL,
                            tx_date datetime NOT NULL,
                            tx_id_user int NOT NULL,
                            tx_host varchar(100) NOT NULL,
                            tx_update datetime NOT NULL,
                            CONSTRAINT collection_pk PRIMARY KEY (id_collection)
);

-- Table: collector


-- Table: h_collection
CREATE TABLE h_collection (
                              id_h_collection int NOT NULL AUTO_INCREMENT,
                              id_collection int NOT NULL,
                              id_collector int NOT NULL,
                              name varchar(100) NOT NULL,
                              color varchar(6) NOT NULL,
                              amount int NOT NULL,
                              id_category int NOT NULL,
                              status int(2) NOT NULL,
                              tx_date datetime NOT NULL,
                              tx_id_user int NOT NULL,
                              tx_host varchar(100) NOT NULL,
                              tx_update datetime NOT NULL,
                              CONSTRAINT h_collection_pk PRIMARY KEY (id_h_collection)
);

-- Table: h_collector
CREATE TABLE h_collector (
                             id_h_collector int NOT NULL AUTO_INCREMENT,
                             id_collector int NOT NULL,
                             id_person int NOT NULL,
                             id_user int NOT NULL,
                             status tinyint NOT NULL,
                             image_path varchar(255) NULL,
                             tx_date datetime NOT NULL,
                             tx_id_user int NOT NULL,
                             tx_host varchar(100) NOT NULL,
                             tx_update datetime NOT NULL,
                             CONSTRAINT h_collector_pk PRIMARY KEY (id_h_collector)
);

-- Table: h_object
CREATE TABLE h_object (
                          id_h_object int NOT NULL AUTO_INCREMENT,
                          id_object int NOT NULL,
                          id_collection int NOT NULL,
                          id_category int NOT NULL,
                          name varchar(100) NOT NULL,
                          description varchar(255) NOT NULL,
                          image varchar(255) NOT NULL,
                          status int(2) NOT NULL,
                          object_status int NOT NULL,
                          price decimal(10,2) NOT NULL,
                          tx_date datetime NOT NULL,
                          tx_id_user int NOT NULL,
                          tx_host varchar(100) NOT NULL,
                          tx_update datetime NOT NULL,
                          CONSTRAINT h_object_pk PRIMARY KEY (id_h_object)
);

-- Table: h_person
CREATE TABLE h_person (
                          id_h_person int NOT NULL AUTO_INCREMENT,
                          id_person int NOT NULL ,
                          first_name varchar(100) NOT NULL,
                          last_name varchar(100) NOT NULL,
                          phone_number varchar(50) NOT NULL,
                          status tinyint NOT NULL,
                          tx_date datetime NOT NULL,
                          tx_id_user int NOT NULL,
                          tx_host varchar(100) NOT NULL,
                          tx_update datetime NOT NULL,
                          person_id_person int NOT NULL,
                          CONSTRAINT h_person_pk PRIMARY KEY (id_h_person)
);


-- Table: object
CREATE TABLE object (
                        id_object int NOT NULL AUTO_INCREMENT,
                        id_collection int NOT NULL,
                        id_category int NOT NULL,
                        name varchar(100) NOT NULL,
                        description varchar(255) NOT NULL,
                        image varchar(255) NOT NULL,
                        status int(2) NOT NULL,
                        object_status int NOT NULL,
                        price decimal(10,2) NOT NULL,
                        tx_date datetime NOT NULL,
                        tx_id_user int NOT NULL,
                        tx_host varchar(100) NOT NULL,
                        tx_update datetime NOT NULL,
                        CONSTRAINT object_pk PRIMARY KEY (id_object)
);

-- foreign keys
-- Reference: collection_collector (table: collection)
ALTER TABLE collection ADD CONSTRAINT collection_collector FOREIGN KEY collection_collector (id_collector)
    REFERENCES collector (id_collector);



-- Reference: h_collection_collection (table: h_collection)
ALTER TABLE h_collection ADD CONSTRAINT h_collection_collection FOREIGN KEY h_collection_collection (id_collection)
    REFERENCES collection (id_collection);

-- Reference: h_collector_collector (table: h_collector)
ALTER TABLE h_collector ADD CONSTRAINT h_collector_collector FOREIGN KEY h_collector_collector (id_collector)
    REFERENCES collector (id_collector);

-- Reference: h_object_object (table: h_object)
ALTER TABLE h_object ADD CONSTRAINT h_object_object FOREIGN KEY h_object_object (id_object)
    REFERENCES object (id_object);

-- Reference: h_person_person (table: h_person)
ALTER TABLE h_person ADD CONSTRAINT h_person_person FOREIGN KEY h_person_person (person_id_person)
    REFERENCES person (id_person);

-- Reference: h_user_user (table: h_user)
ALTER TABLE h_user ADD CONSTRAINT h_user_user FOREIGN KEY h_user_user (id_user)
    REFERENCES user (id_user);

-- Reference: object_category (table: object)
ALTER TABLE collection ADD CONSTRAINT collection_category FOREIGN KEY collection_category (id_category)
    REFERENCES category (id_category);

-- Reference: object_collection (table: object)
ALTER TABLE object ADD CONSTRAINT object_collection FOREIGN KEY object_collection (id_collection)
    REFERENCES collection (id_collection);

-- End of file.

