-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 21, 2015 at 12:44 PM
-- Server version: 5.5.44-0+deb8u1
-- PHP Version: 5.6.13-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `game`
--
CREATE DATABASE IF NOT EXISTS `game` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `game`;

-- --------------------------------------------------------

--
-- Table structure for table `Answers`
--
-- Creation: Oct 20, 2015 at 09:38 AM
--

DROP TABLE IF EXISTS `Answers`;
CREATE TABLE IF NOT EXISTS `Answers` (
`ID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `Answer` text NOT NULL,
  `Points` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `Answers`:
--   `QuestionID`
--       `Questions` -> `ID`
--

--
-- Dumping data for table `Answers`
--

INSERT INTO `Answers` (`ID`, `QuestionID`, `Answer`, `Points`) VALUES
(1, 1, 'Vule vu coucher avec moi ce soir', 3),
(2, 1, 'Liberté, égalité, fraternité', 0),
(3, 1, 'Surrender first, ask questions later', 15),
(4, 1, 'Raise the white flag', 7),
(5, 2, 'Everything that moves', 15),
(6, 2, 'Doggy', 7),
(7, 2, 'Cat', 3),
(8, 2, 'Ramen', 0),
(9, 3, 'Mexico', 7),
(10, 3, 'England', 3),
(11, 3, 'Russia', 0),
(12, 3, 'India', 15),
(13, 4, 'Sweden', 3),
(14, 4, 'Finland', 15),
(15, 4, 'Hungary', 0),
(16, 4, 'Russia', 7),
(17, 5, 'Polish KURWAS ', 3),
(18, 5, 'Germans', 15),
(19, 5, 'Tee loving Britains ', 0),
(20, 5, 'Frenchies', 7);

-- --------------------------------------------------------

--
-- Table structure for table `Highscore`
--
-- Creation: Oct 17, 2015 at 09:35 AM
--

DROP TABLE IF EXISTS `Highscore`;
CREATE TABLE IF NOT EXISTS `Highscore` (
`ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Points` int(11) NOT NULL,
  `Timestamp` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Highscore`
--

INSERT INTO `Highscore` (`ID`, `Name`, `Points`, `Timestamp`) VALUES
(1, 'Thomas_the_Creator', 713, '2015-10-18'),
(2, 'Thomas', 30, '2015-10-20'),
(3, 'ipod', 75, '2015-10-20'),
(4, 'John Appleseed', 75, '2015-10-20'),
(5, 'Johnny Depp', 75, '2015-10-20'),
(6, 'Hans Lander', 40, '2015-10-20'),
(7, 'John Appleseed', 28, '2015-10-20'),
(8, 'MacGyver', 52, '2015-10-20'),
(9, 'My ass', 29, '2015-10-20'),
(10, 'Germanyyy', 44, '2015-10-20'),
(11, 'wr00mz', 32, '2015-10-20'),
(12, 'John Appleseed', 31, '2015-10-21');

-- --------------------------------------------------------

--
-- Table structure for table `Questions`
--
-- Creation: Oct 20, 2015 at 09:38 AM
--

DROP TABLE IF EXISTS `Questions`;
CREATE TABLE IF NOT EXISTS `Questions` (
`ID` int(11) NOT NULL,
  `Question` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Questions`
--

INSERT INTO `Questions` (`ID`, `Question`) VALUES
(1, 'What is the motto of the country France?'),
(2, 'What is the most famous meal for Chinese ?'),
(3, 'Come for the spicy, food stay for the rape. Is the motto of?'),
(4, 'The land of vodka, sauna and suicides is called?'),
(5, 'Which people love their Fatherland, have never been late for anything in their lives, and would secretly like to invade Europe, even if they have to do it via the EU?');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Answers`
--
ALTER TABLE `Answers`
 ADD PRIMARY KEY (`ID`), ADD KEY `QuestionID` (`QuestionID`);

--
-- Indexes for table `Highscore`
--
ALTER TABLE `Highscore`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Questions`
--
ALTER TABLE `Questions`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Answers`
--
ALTER TABLE `Answers`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `Highscore`
--
ALTER TABLE `Highscore`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `Questions`
--
ALTER TABLE `Questions`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Answers`
--
ALTER TABLE `Answers`
ADD CONSTRAINT `Answers_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `Questions` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
