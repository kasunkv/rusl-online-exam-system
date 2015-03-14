-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.36-community-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ruslexamsystem
--

CREATE DATABASE IF NOT EXISTS ruslexamsystem;
USE ruslexamsystem;

--
-- Definition of table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` text NOT NULL,
  `userName` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` (`adminId`,`adminName`,`userName`,`password`) VALUES 
 (1,'Kasun Kodagoda','adminkvk','202cb962ac59075b964b07152d234b70'),
 (2,'Oreliya Fernando','adminore','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;


--
-- Definition of table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `answer1` text NOT NULL,
  `answer2` text NOT NULL,
  `answer3` text NOT NULL,
  `answer4` text NOT NULL,
  `correctAns` int(2) NOT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`questionId`,`question`,`answer1`,`answer2`,`answer3`,`answer4`,`correctAns`) VALUES 
 (1,'What is the main protocol used in this progect?','DHCP','UDP','TCP','POP3',3),
 (2,'What is the main protocol of the internet?','DHCP','NAT','UDP','TCP/IP',4),
 (3,'Most routers go up to which layer in the protocol stack','Network Layer','Application Layer','Physical Layer','DataLink Layer',1),
 (4,'Which is the fastest connection method?','Ethernet','WiFi','Dial Up','Optical Fibers',4),
 (5,'What is UDP mean?','Upper Data Packet','User Datagram Protocol','Under Datagram Protocol','User Datagram Packet',2),
 (6,'What is BCD stand for?','Bus Con Ductor','Binary Coded Decimal','Bit Connection Duplex','BInary Coded Duplex',2),
 (7,'EEPROM stand for?','Electrically Erasable Programmable Read Only Memory','Easily Erasable Programmable Read Only Memory',' Electronic Erasable Programmable Read Only Memory','None of the above',1),
 (8,'What is JDBC mean?','Java Data Backup Connection','Java Database Connection','Java Database Connectivity','Java Data Base Connect',3),
 (9,'Chief component of first generation computer was?','Transistors','Vacuum Tubes and Valves','Integrated Circuits','None of above',2),
 (10,'MICR stands for?','Magnetic Ink Character Reader','Magnetic Ink Code Reader','Magnetic Ink Cases Reader','None',1),
 (11,'IBM 1401 is?','First Generation Computer','Second Generation Computer','Third Generation Computer','Fourth Generation Computer',2);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;


--
-- Definition of table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stdId` int(11) NOT NULL AUTO_INCREMENT,
  `stdName` text NOT NULL,
  `marks` float NOT NULL,
  `attempts` int(2) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`stdId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`stdId`,`stdName`,`marks`,`attempts`,`userName`,`password`) VALUES 
 (1,'Oreliya Fernando',60,0,'oreliya','202cb962ac59075b964b07152d234b70'),
 (3,'Kasun Kodagoda',0,0,'kasun','250cf8b51c773f3f8dc8b4be867a9a02');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
