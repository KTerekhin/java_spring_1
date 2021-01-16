DROP TABLE IF EXISTS `product`;

CREATE TABLE `online_shop`.`product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`price` INT NOT NULL,
 PRIMARY KEY (`id`));