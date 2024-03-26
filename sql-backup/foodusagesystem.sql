-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2024 at 12:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodusagesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('anmol', 'ROLE_VOLUNTEER'),
('raju', 'ROLE_ADMIN'),
('swad', 'ROLE_DONOR');

-- --------------------------------------------------------

--
-- Table structure for table `donation_details`
--

CREATE TABLE `donation_details` (
  `id` int(11) NOT NULL,
  `donor` varchar(45) NOT NULL,
  `history` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donation_details`
--

INSERT INTO `donation_details` (`id`, `donor`, `history`) VALUES
(5, 'swad', 'Donated Food: Kathiawadi Dish of 15 to anmol'),
(6, 'swad', 'Donated Rs.700.5 to anmol');

-- --------------------------------------------------------

--
-- Table structure for table `donation_received`
--

CREATE TABLE `donation_received` (
  `id` int(11) NOT NULL,
  `volunteer` varchar(45) NOT NULL,
  `history` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donation_received`
--

INSERT INTO `donation_received` (`id`, `volunteer`, `history`) VALUES
(1, 'anmol', 'Received Food: Kathiawadi Dish of quantity 15 from swad'),
(2, 'anmol', 'Received Rs.700.5 from swad');

-- --------------------------------------------------------

--
-- Table structure for table `food_saver_details`
--

CREATE TABLE `food_saver_details` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_saver_details`
--

INSERT INTO `food_saver_details` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `role`) VALUES
(1, 'Raju', 'Rastogi', 'raju@gmail.com', 'raju', 'test123', 'admin'),
(2, 'Dilip', 'Rajodiya', 'swad@gmail.com', 'swad', 'test123', 'donor'),
(3, 'Anmol', 'Ratan', 'anmol@gmail.com', 'anmol', 'test123', 'volunteer');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('anmol', '{bcrypt}$2a$10$RAnR3p17UpPWbTbEpcLWxOCvMc.88hzxeb3zAqGAOaRbjucfB/.dq', 1),
('raju', '{bcrypt}$2a$12$foJ0HRDqPUDnERfpslCdZe/1FnOGvBC9ELXHZcKQAyRoJNqB6y9P2', 1),
('swad', '{bcrypt}$2a$10$qcI8ikFkcJW2goVg.O5jnuQW.sCK3K4e6saXqICrvcg6n2erTb3TG', 1);

-- --------------------------------------------------------

--
-- Table structure for table `volunteer_details`
--

CREATE TABLE `volunteer_details` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `food_name` varchar(45) NOT NULL,
  `quantity` int(40) NOT NULL,
  `due_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `volunteer_details`
--

INSERT INTO `volunteer_details` (`id`, `username`, `city`, `food_name`, `quantity`, `due_date`) VALUES
(1, 'anmol', 'Junagadh', 'Kathiawadi Dish', 5, '2024-03-27'),
(2, 'anmol', 'Junagadh', 'Fafda-Jalebi', 10, '2024-03-26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `authorities4_idx_1` (`username`,`authority`);

--
-- Indexes for table `donation_details`
--
ALTER TABLE `donation_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `donor` (`donor`);

--
-- Indexes for table `donation_received`
--
ALTER TABLE `donation_received`
  ADD PRIMARY KEY (`id`),
  ADD KEY `volunteer` (`volunteer`);

--
-- Indexes for table `food_saver_details`
--
ALTER TABLE `food_saver_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_2` (`username`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `volunteer_details`
--
ALTER TABLE `volunteer_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donation_details`
--
ALTER TABLE `donation_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `donation_received`
--
ALTER TABLE `donation_received`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food_saver_details`
--
ALTER TABLE `food_saver_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `volunteer_details`
--
ALTER TABLE `volunteer_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `donation_details`
--
ALTER TABLE `donation_details`
  ADD CONSTRAINT `donation_details_ibfk_1` FOREIGN KEY (`donor`) REFERENCES `food_saver_details` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `donation_received`
--
ALTER TABLE `donation_received`
  ADD CONSTRAINT `donation_received_ibfk_1` FOREIGN KEY (`volunteer`) REFERENCES `food_saver_details` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `volunteer_details`
--
ALTER TABLE `volunteer_details`
  ADD CONSTRAINT `volunteer_details_ibfk_1` FOREIGN KEY (`username`) REFERENCES `food_saver_details` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
