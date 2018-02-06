-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2017 at 04:25 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `contains`
--

CREATE TABLE `contains` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customername` varchar(20) DEFAULT NULL,
  `prescby` varchar(20) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customername`, `prescby`, `address`) VALUES
(123, 'Yash', 'Dr. Nikhil', 'Thane'),
(421, 'Aditya', 'Dr. Brinton', 'Mumbai');

-- --------------------------------------------------------

--
-- Table structure for table `mycount`
--

CREATE TABLE `mycount` (
  `TABLE_NAME` varchar(20) DEFAULT NULL,
  `Counter` int(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mycount`
--

INSERT INTO `mycount` (`TABLE_NAME`, `Counter`) VALUES
('vendor', 4),
('vendor', 5),
('vendor', 5),
('vendor', 6);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `orderdt` int(11) DEFAULT NULL,
  `orderamt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `orderdt`, `orderamt`) VALUES
(121, 110817, 340),
(123, 70817, 270),
(1001, 100817, 340);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `productname` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `dosage` varchar(20) DEFAULT NULL,
  `expdt` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `productname`, `price`, `dosage`, `expdt`, `quantity`, `description`) VALUES
(1200, 'Crocin', 30, '500mg', 518, 10, 'headache'),
(1202, 'Febrex plus', 100, '5ml', 919, 50, 'cough'),
(1206, 'Meftal', 75, '25mg', 1220, 5, 'stomachache'),
(1210, 'calciumsandoz', 140, '', 1219, 20, 'calcium'),
(1300, 'Dove', 100, '', 1117, 100, 'hair'),
(1304, 'Ferronia-xt', 91, '10mg', 1019, 15, 'iron'),
(1340, 'Soframycin', 124, '', 1017, 50, 'skinburn'),
(1341, 'Amoxilin', 279, '500mg', 1217, 50, 'antibiotic'),
(6969, 'Meth', 245, '100mg', 31082017, 100, 'narcotic');

--
-- Triggers `product`
--
DELIMITER $$
CREATE TRIGGER `countmeds` AFTER INSERT ON `product` FOR EACH ROW SET @product_quantity = @product_quantity + 1
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `retailer_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`retailer_id`, `customer_id`, `order_id`) VALUES
(2167, 123, 1001),
(21, 421, 123),
(21, 421, 121);

-- --------------------------------------------------------

--
-- Table structure for table `retailer`
--

CREATE TABLE `retailer` (
  `retailer_id` int(11) NOT NULL,
  `retailername` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `retailer`
--

INSERT INTO `retailer` (`retailer_id`, `retailername`) VALUES
(21, 'Joel'),
(2167, 'Joel'),
(2314, '');

-- --------------------------------------------------------

--
-- Table structure for table `supplies`
--

CREATE TABLE `supplies` (
  `product_id` int(11) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `vendor_id` int(11) NOT NULL,
  `vendorname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`vendor_id`, `vendorname`) VALUES
(102, 'Jack'),
(107, 'Mahesh'),
(123, 'Joel'),
(4234, 'Sanika'),
(4246, 'Pooja'),
(12345, 'JoelJ');

--
-- Triggers `vendor`
--
DELIMITER $$
CREATE TRIGGER `countvendor` AFTER INSERT ON `vendor` FOR EACH ROW insert into mycount select "vendor", count(*) from vendor
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contains`
--
ALTER TABLE `contains`
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD KEY `retailer_id` (`retailer_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `retailer`
--
ALTER TABLE `retailer`
  ADD PRIMARY KEY (`retailer_id`);

--
-- Indexes for table `supplies`
--
ALTER TABLE `supplies`
  ADD KEY `product_id` (`product_id`),
  ADD KEY `vendor_id` (`vendor_id`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`vendor_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contains`
--
ALTER TABLE `contains`
  ADD CONSTRAINT `contains_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `contains_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`retailer_id`) REFERENCES `retailer` (`retailer_id`),
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `purchase_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);

--
-- Constraints for table `supplies`
--
ALTER TABLE `supplies`
  ADD CONSTRAINT `supplies_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `supplies_ibfk_2` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
