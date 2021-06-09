-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2020 at 03:09 AM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covid_mass_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` int(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `blood_group` varchar(50) DEFAULT NULL,
  `sc_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `higher_authority`
--

CREATE TABLE `higher_authority` (
  `ho_id` int(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `higher_authority`
--

INSERT INTO `higher_authority` (`ho_id`, `password`, `name`, `phone`, `email`, `address`) VALUES
(1, '1', '2', '3', '4', '5'),
(2, '1', '2', '3', '4', 'null'),
(3, '1', '2', '3', '4', ''),
(4, '1', '2', '3', '4', ''),
(5, '1', '2', '3', '4', ''),
(6, '1', '2', '3', '4', ''),
(7, '1', '2', '3', '4', ''),
(8, '1', '2', '3', '4', ''),
(9, '1', '2', '3', '4', ''),
(10, 'yAdav_Ank!t7#rAm@', 'ANKIT', '+919594371397', 'ankit.rama.yadav@gmail.com', 'ROOM NO. 69 1/1 AZAD NAGAR MITHAGAR ROAD MULUND EAST'),
(11, 'yAdav_Ank!t7#rAm@', 'ANKIT', '+919594371397', 'ankit.rama.yadav@gmail.com', 'ROOM NO. 69 1/1 AZAD NAGAR MITHAGAR ROAD MULUND EAST'),
(12, '1', 'ANKIT RAMA YADAV', '+919594371397', 'ankit.rama.yadav@gmail.com', 'ROOM NO. 69 1/1 AZAD NAGAR MITHAGAR ROAD MULUND EAST');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patient_id` int(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `blood_group` varchar(50) DEFAULT NULL,
  `result` varchar(50) DEFAULT NULL,
  `doctor_id` int(50) NOT NULL,
  `sc_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sample_collector`
--

CREATE TABLE `sample_collector` (
  `sc_id` int(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `blood_group` varchar(50) DEFAULT NULL,
  `ho_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`);

--
-- Indexes for table `higher_authority`
--
ALTER TABLE `higher_authority`
  ADD PRIMARY KEY (`ho_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `sample_collector`
--
ALTER TABLE `sample_collector`
  ADD PRIMARY KEY (`sc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `higher_authority`
--
ALTER TABLE `higher_authority`
  MODIFY `ho_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patient_id` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sample_collector`
--
ALTER TABLE `sample_collector`
  MODIFY `sc_id` int(50) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
