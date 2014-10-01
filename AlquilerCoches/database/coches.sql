-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-3ubuntu5


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cochesSpring
--

CREATE DATABASE IF NOT EXISTS cochesSpring;
USE cochesSpring;

--
-- Definition of table `cochesSpring`.`coches`
--

DROP TABLE IF EXISTS `cochesSpring`.`coches`;
CREATE TABLE  `cochesSpring`.`coches` (
  `matricula` char(7) NOT NULL,
  `modelo` varchar(50) default NULL,
  `fechaMatriculacion` date default NULL,
  `km` int(11) default NULL,
  `precio` decimal(10,0) default NULL,
  PRIMARY KEY  (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cochesSpring`.`coches`
--

/*!40000 ALTER TABLE `coches` DISABLE KEYS */;
LOCK TABLES `coches` WRITE;
INSERT INTO `cochesSpring`.`coches` VALUES  ('1111JKG','Opel Corsa Cup','2009-10-05',22000,'21'),
 ('3333ABK','Seat León TDI 220','2008-01-25',15200,'34');
UNLOCK TABLES;
/*!40000 ALTER TABLE `coches` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
