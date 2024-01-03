CREATE DATABASE  IF NOT EXISTS `movie_directory`;
USE `movie_directory`;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) DEFAULT NULL,
  `hero_name` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `movie`
--

INSERT INTO `movie` VALUES 
	(1,'The Shawshank Redemption','Tim Robbins',1994),
	(2,'The Godfather','Marlon Brando',1972),
	(3,'The Dark Knight','Christian Bale',2008),
	(4,"Schindler's List",'Liam Neeson',1993),
	(5,'Pulp Fiction','John Travolta',1994);

