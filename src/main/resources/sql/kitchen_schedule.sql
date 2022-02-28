-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.27 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for kitchen_schedule
CREATE DATABASE IF NOT EXISTS `kitchen_schedule` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kitchen_schedule`;

-- Dumping structure for table kitchen_schedule.breaktime
CREATE TABLE IF NOT EXISTS `breaktime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `serving_date` date DEFAULT NULL,
  `serving_time` varchar(255) DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8p62qo15y5vc8pshngwpndpfa` (`serving_time`),
  KEY `FK3llpqx4csie6cu8v0wlyq6m72` (`menu_id`),
  CONSTRAINT `FK3llpqx4csie6cu8v0wlyq6m72` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table kitchen_schedule.breaktime_department
CREATE TABLE IF NOT EXISTS `breaktime_department` (
  `department_id` bigint NOT NULL,
  `breakTime_id` int NOT NULL,
  PRIMARY KEY (`breakTime_id`,`department_id`),
  KEY `FKh9dsi8a43nj0ofcd63013buo2` (`department_id`),
  CONSTRAINT `FK8yjpyaopl608vbhycnl3u53u1` FOREIGN KEY (`breakTime_id`) REFERENCES `breaktime` (`id`),
  CONSTRAINT `FKh9dsi8a43nj0ofcd63013buo2` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table kitchen_schedule.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `regular_break` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table kitchen_schedule.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `identification_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tath3qdbdt3kkdh9ccfl84ag0` (`identification_id`),
  KEY `FKb49tatdi7kxcr5nlipjit0uhd` (`department_id`),
  CONSTRAINT `FK4okbvndadm1klws0su0ijvt65` FOREIGN KEY (`identification_id`) REFERENCES `identification` (`id`),
  CONSTRAINT `FKb49tatdi7kxcr5nlipjit0uhd` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table kitchen_schedule.identification
CREATE TABLE IF NOT EXISTS `identification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table kitchen_schedule.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `breakfast` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dinner` varchar(255) DEFAULT NULL,
  `lunch` varchar(255) DEFAULT NULL,
  `special_meals` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
