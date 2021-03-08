CREATE SCHEMA `online_shop` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `online_shop`.`product` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`price` INT NOT NULL,
 PRIMARY KEY (`id`));
 
 CREATE TABLE `online_shop`.`buyer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `online_shop`.`product` (`id`, `title`, `price`) VALUES ('1', 'Coffee', '5');
INSERT INTO `online_shop`.`product` (`id`, `title`, `price`) VALUES ('2', 'Meat', '15');
INSERT INTO `online_shop`.`product` (`id`, `title`, `price`) VALUES ('3', 'Pizza', '3');
INSERT INTO `online_shop`.`product` (`id`, `title`, `price`) VALUES ('4', 'Juice', '4');
INSERT INTO `online_shop`.`product` (`id`, `title`, `price`) VALUES ('5', 'Ice-Cream', '2');

INSERT INTO `online_shop`.`buyer` (`id`, `name`) VALUES ('1', 'Dmitriy');
INSERT INTO `online_shop`.`buyer` (`id`, `name`) VALUES ('2', 'Konstantin');
INSERT INTO `online_shop`.`buyer` (`id`, `name`) VALUES ('3', 'Anton');

CREATE TABLE `online_shop`.`order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `buyer_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `online_shop`.`order` 
ADD INDEX `fk_order_buyer_idx` (`buyer_id` ASC) VISIBLE,
ADD INDEX `fk_order_product_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `online_shop`.`order` 
ADD CONSTRAINT `fk_order_buyer`
  FOREIGN KEY (`buyer_id`)
  REFERENCES `online_shop`.`buyer` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_order_product`
  FOREIGN KEY (`product_id`)
  REFERENCES `online_shop`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('1', '1', '2');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('2', '2', '4');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('3', '3', '2');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('4', '2', '5');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('5', '2', '5');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('6', '1', '2');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('7', '1', '1');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('8', '1', '3');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('9', '2', '5');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('10', '3', '4');
INSERT INTO `online_shop`.`order` (`id`, `buyer_id`, `product_id`) VALUES ('11', '3', '4');
