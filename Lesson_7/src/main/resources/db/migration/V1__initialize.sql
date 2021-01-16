CREATE TABLE products (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`price` INT NOT NULL,
 PRIMARY KEY (`id`));

INSERT INTO products (`title`, `price`) VALUES
('Coffee', '5'),
('Meat', '15'),
('Pizza', '3'),
('Juice', '4'),
('Ice-Cream', '2'),
('Apple', '3'),
('Orange', '4'),
('Banana', '3'),
('Milk', '2'),
('Fish', '6'),
('Potato', '2'),
('Cake', '8'),
('Tomato', '6'),
('Chicken', '6'),
('Sausage', '9'),
('Cucumber', '2'),
('Ketchup', '10'),
('Pepper', '12'),
('Water', '1'),
('Cheese', '14');