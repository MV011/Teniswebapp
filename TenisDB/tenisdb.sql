CREATE DATABASE `tenisdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE tenisdb;

CREATE TABLE `Coach` (
  `CoachID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CoachFirstName` varchar(45) NOT NULL,
  `CoachLastName` varchar(45) NOT NULL,
  `CoachPhoneNumber` varchar(45) NOT NULL,
  `CoachStartDate` date NOT NULL,
  PRIMARY KEY (`CoachID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Feedback` (
  `FeedbackID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FeedbackDate` date NOT NULL,
  `StudentID` int(10) unsigned NOT NULL,
  `CoachID` int(10) unsigned NOT NULL,
  `FeedbackRating` int(11) NOT NULL,
  `FeedbackDescription` varchar(1000) NOT NULL,
  PRIMARY KEY (`FeedbackID`),
  KEY `StudentID` (`StudentID`),
  KEY `CoachID` (`CoachID`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`studentid`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`CoachID`) REFERENCES `coach` (`coachid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Student` (
  `StudentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `StudentActive` TINYINT NOT NULL DEFAULT 1,
  `StudentFirstName` varchar(45) NOT NULL,
  `StudentLastName` varchar(45) NOT NULL,
  `StudentBirthDate` date NOT NULL,
  `StudentJoinDate` date NOT NULL,
  `StudentEmail` varchar(45) DEFAULT NULL,
  `StudentPhoneNumber` varchar(45) DEFAULT NULL,
  `StudentSkill` int(11) NOT NULL,
  `TeamID` int(11) NOT NULL DEFAULT '0',
  'StudentAvailability' json NOT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Team` (
  `TeamID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TeamDateTime` json NOT NULL,
  `TeamStudents` json NOT NULL,
  `CoachID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`TeamID`),
  KEY `Coach.CoachID_idx` (`CoachID`),
  CONSTRAINT `CoachID` FOREIGN KEY (`CoachID`) REFERENCES `coach` (`coachid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
