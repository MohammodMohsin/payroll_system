-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2016 at 08:30 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payroll_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE IF NOT EXISTS `designation` (
  `position` varchar(20) NOT NULL,
  `salary` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation` (`position`, `salary`) VALUES
('Clerk', 8000),
('Developer', 20000),
('Gaurd', 5000),
('Manager', 35000),
('Project Manager', 25000),
('Reception', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `empid` varchar(30) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Contact` varchar(20) NOT NULL,
  `join_date` varchar(20) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empid`, `first_name`, `last_name`, `Gender`, `Email`, `Contact`, `join_date`, `designation`, `salary`) VALUES
('m000012', 'Mohammad', 'Abdullah', 'Male', 'mdabdullah@gmail.com', '01767886199', '26-November-2016', 'Project Manager', 27500),
('m220116', 'MD', 'Ashraful', 'male', 'ghk1@zancon.com', '01562347895', '02-06-2016', 'Manager', 35000),
('m220117', 'Arfatul', 'Islam', 'Male', 'arfat@gmail.com', '01827274651', '24-November-2016', 'Developer', 20000),
('m220118', 'MD', 'Towshin', 'Male', 'towshin@gmail.com', '01827274652', '24-November-2016', 'Developer', 20000),
('m220119', 'MD', 'Mahfuz', 'Male', 'mahfuz@gmail.com', '01827274653', '24-November-2016', 'Developer', 20000),
('m220120', 'MD', 'Mahin', 'Male', 'mahin@gmail.com', '01827274654', '24-November-2016', 'Developer', 20000),
('m220121', 'MD', 'Mohsin', 'Male', 'mohsin@gmail.com', '01827274655', '24-November-2016', 'Developer', 20000),
('m220122', 'MD', 'Mamon', 'Male', 'mamon@gmail.com', '01827274656', '24-November-2016', 'Developer', 20000),
('m220123', 'MD', 'Helal', 'Male', 'helal@gmail.com', '01827274657', '24-November-2016', 'Developer', 20000),
('m220124', 'MD', 'Nezam', 'Male', 'nezam@gmail.com', '01827274658', '24-November-2016', 'Manager', 35000),
('m220125', 'MD', 'Shaimon', 'Male', 'saimon@gmail.com', '01827274659', '24-November-2016', 'Developer', 20000),
('m220126', 'MD', 'Mizan', 'Male', 'mizan@gmail.com', '01827274660', '24-November-2016', 'Reception', 10000),
('m220127', 'Sumaia', 'Jannat', 'Female', 'sumaia@gmail.com', '01827274661', '24-November-2016', 'Reception', 10000),
('m220128', 'Aklima', 'Khanom', 'Female', 'aklima@gmail.com', '01827274662', '24-November-2016', 'Reception', 10000),
('m220129', 'Emtiazul', 'Hoque', 'Male', 'emtiaz@gmail.com', '01827274663', '24-November-2016', 'Developer', 20000),
('m220130', 'Dipta', 'Mozumdar', 'Male', 'dipta@gmail.com', '01827274664', '24-November-2016', 'Developer', 20000),
('m220131', 'Arju', 'chowdhury', 'Male', 'arju@gmail.com', '01827274665', '24-November-2016', 'Developer', 20000),
('m220132', 'Serajul', 'Arifin', 'Male', 'arifin@gmail.com', '01827274666', '24-November-2016', 'Developer', 20000),
('m220133', 'Shahid', 'khan', 'Male', 'khan@gmail.com', '01827274667', '24-November-2016', 'Developer', 20000),
('m220135', 'Noman', 'khan', 'Male', 'noman@gmail.com', '01827274668', '24-November-2016', 'Reception', 10000),
('m220136', 'Jahid', 'khan', 'Male', 'jahid@gmail.com', '01827274669', '24-November-2016', 'Developer', 20000);

-- --------------------------------------------------------

--
-- Table structure for table `net_salary`
--

CREATE TABLE IF NOT EXISTS `net_salary` (
  `empid` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL,
  `month` varchar(20) NOT NULL,
  `salary` double NOT NULL,
  `allowance` double NOT NULL,
  `deducation` double NOT NULL,
  `net_salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net_salary`
--

INSERT INTO `net_salary` (`empid`, `year`, `month`, `salary`, `allowance`, `deducation`, `net_salary`) VALUES
('m220117', '2016', 'June', 20000, 1000, 500, 20500),
('m220118', '2016', 'June', 20000, 1500, 300, 21200),
('m220119', '2016', 'June', 20000, 1200, 200, 21000),
('m220120', '2016', 'June', 20000, 2000, 400, 21600),
('m220121', '2016', 'july', 20000, 700, 100, 20600),
('m220122', '2016', 'july', 20000, 900, 200, 20500),
('m220123', '2016', 'july', 20000, 300, 100, 20200),
('m220124', '2016', 'july', 35000, 2000, 600, 36400),
('m220125', '2016', 'july', 20000, 400, 100, 20300),
('m220126', '2016', 'June', 10000, 300, 100, 10200),
('m220116', '2016', 'June', 35000, 920, 1400, 30220);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `empid` varchar(20) NOT NULL,
  `month` varchar(12) NOT NULL,
  `year` varchar(4) NOT NULL,
  `status` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`empid`, `month`, `year`, `status`) VALUES
('m220116', 'June', '2016', 'Not paid');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE IF NOT EXISTS `registration` (
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `answer` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`username`, `password`, `answer`) VALUES
('t', '1', 'red');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `designation`
--
ALTER TABLE `designation`
  ADD UNIQUE KEY `position` (`position`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD UNIQUE KEY `id` (`empid`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD UNIQUE KEY `empid` (`empid`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD UNIQUE KEY `username` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
