-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2024 at 05:01 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `music`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `email`) VALUES
(2, 'demo', '1234', 'r@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE `album` (
  `Album_id` int(200) NOT NULL,
  `album_name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`Album_id`, `album_name`) VALUES
(1, 'David Guetta Hits'),
(2, 'Shakira Hits'),
(3, 'Thrill'),
(4, 'a hundred songs'),
(5, 'Night Visions'),
(6, 'Ludwig van Beethoven Songs'),
(7, 'Taylor swift hits'),
(8, 'Talk That Talk'),
(9, 'uptown funk'),
(10, ' Motion (2014)'),
(11, 'Get Rich or Die Tryin\''),
(12, 'Enimen hits');

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `id` int(200) NOT NULL,
  `artist_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`id`, `artist_name`) VALUES
(1, 'David Guetta'),
(2, 'Shakira'),
(3, 'Taylor Swift'),
(4, 'Linkin Park'),
(5, 'Backstreet Boys'),
(6, ' B.B. King'),
(7, 'Bob Dylan'),
(8, ' Imagine Dragons'),
(9, 'Ludwig van Beethoven'),
(10, 'Calvin Harris'),
(11, 'Bruno Mars'),
(12, '50 Cent'),
(13, 'Eminem');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(255) NOT NULL,
  `comments` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `comments`) VALUES
(1, 'linkin park'),
(2, 'linkin park'),
(3, 'linkin park'),
(4, 'linkin park'),
(5, 'taylor swift'),
(6, 'rihanna'),
(7, 'linkin park'),
(8, 'Somewhere I Belong');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `genre_id` int(200) NOT NULL,
  `genre_name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`genre_id`, `genre_name`) VALUES
(1, 'Pop'),
(2, 'Electronic'),
(3, 'Classical'),
(4, 'Rock'),
(5, 'Hip'),
(6, 'Jazz'),
(7, 'Blues'),
(8, 'Hip Hop'),
(9, 'Rap'),
(10, 'R&B'),
(11, 'Alternative music'),
(12, 'Reggoe');

-- --------------------------------------------------------

--
-- Table structure for table `mood`
--

CREATE TABLE `mood` (
  `track_no` int(200) NOT NULL,
  `mood_description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mood`
--

INSERT INTO `mood` (`track_no`, `mood_description`) VALUES
(1, 'Rocking'),
(2, 'Rocking'),
(3, 'Good'),
(4, 'Good'),
(5, 'rocking'),
(0, 'bad'),
(6, 'bad'),
(7, 'rocking'),
(8, 'good'),
(9, 'silent'),
(10, 'silent'),
(11, 'silent'),
(12, 'good'),
(13, 'electronic'),
(14, 'good'),
(15, 'Silent'),
(16, 'Silent'),
(17, 'silent'),
(18, 'sad'),
(19, 'good'),
(20, 'rocking'),
(21, 'rocking'),
(22, 'sad'),
(23, 'sad'),
(24, 'sad'),
(25, 'silent');

-- --------------------------------------------------------

--
-- Table structure for table `tracks`
--

CREATE TABLE `tracks` (
  `id` int(200) NOT NULL,
  `track_no` int(200) NOT NULL,
  `track_name` varchar(1000) NOT NULL,
  `lyrics` text NOT NULL,
  `album_id` int(200) NOT NULL,
  `year` year(4) NOT NULL,
  `link` varchar(250) NOT NULL,
  `genre_id` int(250) NOT NULL,
  `count` int(250) NOT NULL,
  `mood_description` varchar(50) NOT NULL,
  `artist_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tracks`
--

INSERT INTO `tracks` (`id`, `track_no`, `track_name`, `lyrics`, `album_id`, `year`, `link`, `genre_id`, `count`, `mood_description`, `artist_name`) VALUES
(1, 1, 'maana ke hum yaar nahi', '', 0, 0000, 'Maana Ke Hum Yaar Nahin.mp3', 0, 0, 'Sad', 'Parineeti chopda'),
(2, 2, 'agar tum saath ho', '', 0, 0000, 'Agar tum saath ho.mp3', 0, 0, 'Surprise', 'Arijit singh'),
(3, 3, 'Channa Mereya', '', 0, 0000, 'Channa Mereya.mp3', 0, 0, 'Sad', 'Arijit singh'),
(4, 4, 'Kabira', '', 0, 0000, 'Kabira.mp3', 0, 0, 'Sad', 'Rekha Bharadwaj'),
(5, 5, 'Bulleya', '', 0, 0000, 'Bulleya.mp3', 0, 0, 'Sad', 'pritam chakraborty'),
(6, 6, 'Humdard', '', 0, 0000, 'Humdard.mp3', 0, 0, 'Sad', ''),
(7, 7, 'Lag Ja Gale Se', '', 0, 0000, 'Lag Ja Gale Se.mp3', 0, 0, 'Sad', 'Lata Mangeshkar '),
(8, 8, 'Main Rahoon Ya Na Rahoon', '', 0, 0000, 'Main Rahoon Ya Na Rahoon.mp3', 0, 0, 'Sad', ''),
(9, 9, 'Tujhe Bhula Diya', '', 0, 0000, 'Tujhe Bhula Diya.mp3', 0, 0, 'Sad', 'Mohit Chauhan'),
(10, 10, 'Yeh Dooriyan', '', 0, 0000, 'Yeh Dooriyan.mp3', 0, 0, 'Sad', 'Mohit Chauhan'),
(1, 11, 'Apna Time Aayega ', '', 0, 0000, 'Apna Time Aayega.mp3', 0, 0, 'Surprise', 'Ranveer Singh'),
(2, 12, 'Main Lad Jaana', '', 0, 0000, 'Main Lad Jaana.mp3', 0, 0, 'Surprise', 'Romy'),
(3, 13, 'Dangal', '', 0, 0000, 'Dangal.mp3', 0, 0, 'Surprise', 'Daler Mehndi'),
(4, 14, 'Kar Har Maidaan Fateh', '', 0, 0000, 'Kar Har Maidaan Fateh.mp3', 0, 0, 'Surprise', 'Shreya Goshal,Sukhwinder Singh'),
(5, 15, 'Mere Liye Tum Kaafi Ho', '', 0, 0000, 'Mere Liye Tum Kaafi Ho.mp3', 0, 0, 'Surprise', 'Aayushman Khurrana'),
(6, 16, 'Soorma Anthem', '', 0, 0000, 'Soorma Anthem.mp3', 0, 0, 'Surprise', 'Shankar Mahadevan'),
(7, 17, 'Ziddi Dil', '', 0, 0000, 'Ziddi Dil.mp3', 0, 0, 'Surprise', 'Vishal Dadlani'),
(8, 18, 'Zinda', '', 0, 0000, 'Zinda.mp3', 0, 0, 'Surprise', 'Amit Trivedi'),
(1, 19, 'Aal izz Well', '', 0, 0000, 'Aal izz Well.mpeg', 0, 0, 'Happy', 'Shaan,Sonu Nigam'),
(2, 20, 'Chittiyan Kalaaiyaan', '', 0, 0000, 'Chittiyan Kalaaiyaan.mpeg', 0, 0, 'Happy', 'Meet Bros'),
(3, 21, 'Dil Dhadakne Do', '', 0, 0000, 'Dil Dhadakne Do.mpeg', 0, 0, 'Happy', 'T-Series'),
(4, 22, 'Ilahi', '', 0, 0000, 'Ilahi.mpeg', 0, 0, 'Happy', 'Arijit Singh'),
(5, 23, 'Life Is Crazy(Wake Up Sid)', '', 0, 0000, 'Life Is Crazy(Wake Up Sid).mpeg', 0, 0, 'Happy', 'Konkona Sen'),
(6, 24, 'Ole Ole', '', 0, 0000, 'Ole Ole.mpeg', 0, 0, 'Happy', 'Abhijeet Bhattacharya,Amit Mishra'),
(7, 25, 'Senorita', '', 0, 0000, 'Senorita.mpeg', 0, 0, 'Happy', 'Hritik Roshan,Abhay Deol,Farhan Akhtar'),
(8, 26, 'Sooraj Ki Baahon Mein', '', 0, 0000, 'Sooraj Ki Baahon Mein.mpeg', 0, 0, 'Happy', 'Clinton Cerejo, Dominique Cerejo, Loy Mendonsa'),
(9, 27, 'Sunny Sunny', '', 0, 0000, 'Sunny Sunny.mpeg', 0, 0, 'Happy', 'Yo Yo honey Singh'),
(1, 28, 'Besharmi Ki Height', '', 0, 0000, 'Besharmi Ki Height.mp3', 0, 0, 'Neutral', 'Benny Dayal'),
(2, 29, 'Kehdoon Tumhein', '', 0, 0000, 'Kehdoon Tumhein.mp3', 0, 0, 'Neutral', 'Asha Bhosle'),
(3, 30, 'Tu Ne Jo Na Kaha', '', 0, 0000, 'Tu Ne Jo Na Kaha.mp3', 0, 0, 'Neutral', 'Mohit Chauhan'),
(4, 31, 'ABCD - Yaariyan', '', 0, 0000, 'ABCD - Yaariyan.mp3', 0, 0, 'Neutral', 'Yo Yo Honey Singh'),
(5, 32, 'Baby Doll', '', 0, 0000, 'Baby Doll.mp3', 0, 0, 'Neutral', 'Kanika Kapoor,Meet Bros'),
(6, 33, 'Bang Bang', '', 0, 0000, 'Bang Bang.mp3', 0, 0, 'Neutral', 'Neeti Mohan,Benny Dayal'),
(7, 34, 'Chaar Botal Vodka', '', 0, 0000, 'Chaar Botal Vodka.mp3', 0, 0, 'Neutral', 'Yo Yo Honey Singh'),
(8, 35, 'India Waale', '', 0, 0000, 'India Waale.mp3', 0, 0, 'Neutral', 'KK,Vishal Dadlani'),
(9, 36, 'Jumme Ki Raat', '', 0, 0000, 'Jumme Ki Raat.mp3', 0, 0, 'Neutral', 'Mikka Singh'),
(10, 37, 'Mast Kalander', '', 0, 0000, 'Mast Kalander.mp3', 0, 0, 'Neutral', 'Mika Singh,Yo Yo Honey Singh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`Album_id`);

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genre_id`);

--
-- Indexes for table `tracks`
--
ALTER TABLE `tracks`
  ADD PRIMARY KEY (`track_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `album`
--
ALTER TABLE `album`
  MODIFY `Album_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `genre_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tracks`
--
ALTER TABLE `tracks`
  MODIFY `track_no` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
