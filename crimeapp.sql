-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2021 at 04:04 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crimeapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `arson`
--

CREATE TABLE `arson` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `date_happened` date NOT NULL,
  `date_reported` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arson`
--

INSERT INTO `arson` (`id`, `username`, `gender`, `contact`, `address`, `date_happened`, `date_reported`) VALUES
(1, '', '', 0, '', '0000-00-00', '0000-00-00'),
(2, '', '', 0, '', '0000-00-00', '0000-00-00'),
(3, 'asdasd', 'asdasd', 12312, 'asdasd', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `assault`
--

CREATE TABLE `assault` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `details` varchar(50) NOT NULL,
  `date_happened` date NOT NULL,
  `date_reported` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assault`
--

INSERT INTO `assault` (`id`, `username`, `gender`, `contact`, `details`, `date_happened`, `date_reported`) VALUES
(1, 'Daniyal', 'male', 0, 'near Dolmen mall', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `carstolen`
--

CREATE TABLE `carstolen` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `cardetails` varchar(100) NOT NULL,
  `date_happened` date DEFAULT NULL,
  `date_reported` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carstolen`
--

INSERT INTO `carstolen` (`id`, `username`, `gender`, `contact`, `cardetails`, `date_happened`, `date_reported`) VALUES
(1, '', '', 0, '', NULL, NULL),
(2, '', '', 0, '', NULL, NULL),
(3, '', '', 0, '', NULL, NULL),
(4, '', '', 0, '', NULL, NULL),
(5, 'asdasd', 'asdasd', 123123, 'asdasd', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `crime_type`
--

CREATE TABLE `crime_type` (
  `crimeType_ID` int(11) NOT NULL,
  `crimeType_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `crime_type`
--

INSERT INTO `crime_type` (`crimeType_ID`, `crimeType_name`) VALUES
(1, 'Mobile Snatching'),
(2, 'Car Stolen'),
(3, 'Assault'),
(4, 'Kidnapping'),
(5, 'Arson'),
(6, 'Domestic Violence');

-- --------------------------------------------------------

--
-- Table structure for table `fir`
--

CREATE TABLE `fir` (
  `Fir_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Cnic` varchar(200) NOT NULL,
  `Contact` int(11) NOT NULL,
  `Gender` varchar(11) NOT NULL,
  `ComplainAgainst` varchar(50) NOT NULL,
  `Date_reported` date NOT NULL,
  `Date_happened` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fir`
--

INSERT INTO `fir` (`Fir_id`, `Name`, `Cnic`, `Contact`, `Gender`, `ComplainAgainst`, `Date_reported`, `Date_happened`) VALUES
(1, 'asdasd', 'asdasdas', 12123123, '', 'XYZ', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `kidnapp`
--

CREATE TABLE `kidnapp` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `details` varchar(100) NOT NULL,
  `date_happened` date NOT NULL,
  `date_reported` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kidnapp`
--

INSERT INTO `kidnapp` (`id`, `username`, `gender`, `contact`, `details`, `date_happened`, `date_reported`) VALUES
(1, '', '', 0, '', '0000-00-00', '0000-00-00'),
(2, '', '', 0, '', '0000-00-00', '0000-00-00'),
(3, 'asdasd', 'asdasd', 34534, 'asdas', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `mobilesnatch`
--

CREATE TABLE `mobilesnatch` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `snatchingpoint` varchar(100) NOT NULL,
  `date_happened` date DEFAULT NULL,
  `date_reported` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mobilesnatch`
--

INSERT INTO `mobilesnatch` (`id`, `username`, `gender`, `contact`, `snatchingpoint`, `date_happened`, `date_reported`) VALUES
(1, 'asdasd', 'asdasd', 234234, 'sdfsdfsdfsd', NULL, NULL),
(2, 'daniyal', 'male', 2147483647, 'nazimabad', NULL, NULL),
(3, 'asdas', 'asdasd', 345345, 'asdasd', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `User_Id` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Contact` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_Id`, `Username`, `Password`, `Email`, `Age`, `Contact`) VALUES
(1, 'ramisha', '12345', 'ramisha@gmail.com', 20, 9876123),
(2, 'aqsa', 'aqsa123', 'aqsa@gmail.com', 55, 91234456),
(3, 'ali', 'ali12', 'ali@gmail.com', 33, 9876145),
(7, '', '', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `violence`
--

CREATE TABLE `violence` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `details` varchar(100) NOT NULL,
  `date_happened` date NOT NULL,
  `date_reported` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `violence`
--

INSERT INTO `violence` (`id`, `username`, `gender`, `contact`, `details`, `date_happened`, `date_reported`) VALUES
(1, '', '', 0, '', '0000-00-00', '0000-00-00'),
(2, 'asd', 'asd', 567567, 'asdasd', '0000-00-00', '0000-00-00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `arson`
--
ALTER TABLE `arson`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assault`
--
ALTER TABLE `assault`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `carstolen`
--
ALTER TABLE `carstolen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `crime_type`
--
ALTER TABLE `crime_type`
  ADD PRIMARY KEY (`crimeType_ID`);

--
-- Indexes for table `fir`
--
ALTER TABLE `fir`
  ADD PRIMARY KEY (`Fir_id`);

--
-- Indexes for table `kidnapp`
--
ALTER TABLE `kidnapp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mobilesnatch`
--
ALTER TABLE `mobilesnatch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_Id`);

--
-- Indexes for table `violence`
--
ALTER TABLE `violence`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `arson`
--
ALTER TABLE `arson`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `assault`
--
ALTER TABLE `assault`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `carstolen`
--
ALTER TABLE `carstolen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `crime_type`
--
ALTER TABLE `crime_type`
  MODIFY `crimeType_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `fir`
--
ALTER TABLE `fir`
  MODIFY `Fir_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `kidnapp`
--
ALTER TABLE `kidnapp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `mobilesnatch`
--
ALTER TABLE `mobilesnatch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `User_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `violence`
--
ALTER TABLE `violence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
