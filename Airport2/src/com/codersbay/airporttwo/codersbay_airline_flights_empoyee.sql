-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Mrz 2019 um 09:12
-- Server-Version: 10.1.28-MariaDB
-- PHP-Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `codersbay_airline`
--

-- --------------------------------------------------------
--
-- Tabellenstruktur für Tabelle `employees`
--

CREATE TABLE `employees` (
  `personnel_number` int(11) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `street` varchar(150) NOT NULL,
  `appartment_number` varchar(10) NOT NULL,
  `zip` varchar(10) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(150) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `flights`
--

CREATE TABLE `flights` (
  `flight_number` varchar(15) NOT NULL,
  `departure` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flight_duration` int(4) NOT NULL COMMENT 'in minutes',
  `departure_gate` int(11) NOT NULL,
  `arrival_gate` int(11) NOT NULL,
  `pilot` int(11) NOT NULL,
  `co_pilot` int(11) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`personnel_number`),
  ADD KEY `zip` (`zip`);

--
-- Indizes für die Tabelle `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flight_number`),
  ADD KEY `arrival_gate` (`arrival_gate`),
  ADD KEY `pilot` (`pilot`),
  ADD KEY `co_pilot` (`co_pilot`),
  ADD KEY `departure_gate` (`departure_gate`);


--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- Constraints der Tabelle `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`zip`) REFERENCES `locations` (`zip`);

--
-- Constraints der Tabelle `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`arrival_gate`) REFERENCES `gates` (`gate_id`),
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`pilot`) REFERENCES `employees` (`personnel_number`),
  ADD CONSTRAINT `flights_ibfk_3` FOREIGN KEY (`co_pilot`) REFERENCES `employees` (`personnel_number`),
  ADD CONSTRAINT `flights_ibfk_4` FOREIGN KEY (`departure_gate`) REFERENCES `gates` (`gate_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
