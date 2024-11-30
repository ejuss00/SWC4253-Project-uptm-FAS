-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2024 at 09:36 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `userId` int(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `num_person` int(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` bigint(20) NOT NULL,
  `booking_date` datetime(6) DEFAULT NULL,
  `discounted_price` double NOT NULL,
  `number_of_people` int(11) NOT NULL,
  `promotion_applied` bit(1) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking_products`
--

CREATE TABLE `booking_products` (
  `booking_id` bigint(20) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(5) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image_file_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `brand`, `category`, `created_at`, `description`, `image_file_name`, `name`, `price`) VALUES
(1, 'Langkawi Group', 'Diving', NULL, 'Night diving adventure at night time where you can see unique fish at night', '1732462414682_92970713.jpg', 'Langkawi Night Diving', 2000),
(2, 'Phoenix Valorant', 'Jungle Tracking', NULL, 'Climb the dangerous volcano and swim into the lava to heal.', '1732462400300_75241241.jpg', 'Volcano Lava Swimming', 100),
(3, 'Mara', 'Education', NULL, 'Discover top university', '1732463302197_57380538.jpg', 'UPTM Tour', 50),
(4, 'Lord Of The Ring', 'Adventure', NULL, 'Journey on middle earth and become another expandable adventure to genocide the dark elf.', '1732480112314_MountDoom_eye_of_sauron.jpg', 'Mount Doom and Sauron Eye', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `address`, `created_at`, `email`, `first_name`, `last_name`, `password`, `phone`, `role`) VALUES
(1, 'selangor, malaysia', '2024-11-22 23:55:53.000000', 'test@gmail.com', 'test', 'ter', '$2a$10$ww9yO7iwUiR7Ocfam0FDD.1FJb0EVaU9vTtebhVOcdCwpmaRAJ2f2', '01122692320', 'admin'),
(2, 'johor, malaysia', '2024-11-24 17:28:12.000000', 'kucing@gmail.com', 'kucing', 'british', '$2a$10$kYrX6ZpvILVazw8SOZua.OIirepbxyZ1ygi936dtpVZpWHveFNyGa', '01111692322', 'client'),
(3, 'selangor, malaysia', '2024-11-24 23:36:51.000000', 'adam@gmail.com', 'adam', 'pro', '$2a$10$ifsr7yvxLWOWoEBcwDiNTe4GRo32KtBFfWF9.Xsi2cHTVqy2HH/x6', '01122692323', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booking_products`
--
ALTER TABLE `booking_products`
  ADD KEY `FK61i0xq10qbqmdoopgop57xyd9` (`product_id`),
  ADD KEY `FKihcgeg3ds5wtdcgu3eqq446qo` (`booking_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `userId` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking_products`
--
ALTER TABLE `booking_products`
  ADD CONSTRAINT `FK61i0xq10qbqmdoopgop57xyd9` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKihcgeg3ds5wtdcgu3eqq446qo` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
