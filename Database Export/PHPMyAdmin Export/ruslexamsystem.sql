-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 08, 2013 at 07:26 PM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ruslexamsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE IF NOT EXISTS `admins` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` text NOT NULL,
  `userName` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`adminId`, `adminName`, `userName`, `password`) VALUES
(1, 'Kasun Kodagoda', 'adminkvk', '202cb962ac59075b964b07152d234b70'),
(2, 'Oreliya Fernando', 'adminore', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `answer1` text NOT NULL,
  `answer2` text NOT NULL,
  `answer3` text NOT NULL,
  `answer4` text NOT NULL,
  `correctAns` int(2) NOT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionId`, `question`, `answer1`, `answer2`, `answer3`, `answer4`, `correctAns`) VALUES
(1, 'What is the main protocol used in this progect?', 'DHCP', 'UDP', 'TCP', 'POP3', 3),
(2, 'What is the main protocol of the internet?', 'DHCP', 'NAT', 'UDP', 'TCP/IP', 4),
(3, 'Most routers go up to which layer in the protocol stack', 'Network Layer', 'Application Layer', 'Physical Layer', 'DataLink Layer', 1),
(4, 'Which is the fastest connection method?', 'Ethernet', 'WiFi', 'Dial Up', 'Optical Fibers', 4),
(5, 'What is UDP mean?', 'Upper Data Packet', 'User Datagram Protocol', 'Under Datagram Protocol', 'User Datagram Packet', 2),
(6, 'What is BCD stand for?', 'Bus Con Ductor', 'Binary Coded Decimal', 'Bit Connection Duplex', 'BInary Coded Duplex', 2),
(7, 'EEPROM stand for?', 'Electrically Erasable Programmable Read Only Memory', 'Easily Erasable Programmable Read Only Memory', ' Electronic Erasable Programmable Read Only Memory', 'None of the above', 1),
(8, 'What is JDBC mean?', 'Java Data Backup Connection', 'Java Database Connection', 'Java Database Connectivity', 'Java Data Base Connect', 3),
(9, 'Chief component of first generation computer was?', 'Transistors', 'Vacuum Tubes and Valves', 'Integrated Circuits', 'None of above', 2),
(10, 'MICR stands for?', 'Magnetic Ink Character Reader', 'Magnetic Ink Code Reader', 'Magnetic Ink Cases Reader', 'None', 1),
(11, 'IBM 1401 is?', 'First Generation Computer', 'Second Generation Computer', 'Third Generation Computer', 'Fourth Generation Computer', 2);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `stdId` int(11) NOT NULL AUTO_INCREMENT,
  `stdName` text NOT NULL,
  `marks` float NOT NULL,
  `attempts` int(2) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`stdId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`stdId`, `stdName`, `marks`, `attempts`, `userName`, `password`) VALUES
(1, 'Oreliya Fernando', 60, 0, 'oreliya', '202cb962ac59075b964b07152d234b70'),
(3, 'Kasun Kodagoda', 0, 0, 'kasun', '250cf8b51c773f3f8dc8b4be867a9a02');
