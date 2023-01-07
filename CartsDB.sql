CREATE DATABASE IF NOT EXISTS Cart;

CREATE TABLE cart (
	cart_id INT AUTO_INCREMENT PRIMARY KEY,
	user_id int NOT NULL	
);


CREATE TABLE orders(
	order_id INT AUTO_INCREMENT PRIMARY KEY,
	cart_id INT,
	FOREIGN KEY (cart_id) REFERENCES cart (cart_id)

);
