
CREATE DATABASE IF NOT EXISTS Product;

CREATE TABLE Product.product (
	product_id INT AUTO_INCREMENT PRIMARY KEY,
  	product_code VARCHAR (255) NOT NULL,
	product_name VARCHAR (255) NOT NULL,
  	description VARCHAR (255) NOT NULL,
	brand_id INT NOT NULL,
	category_id INT,
	quantity INT,
	unit_price DECIMAL (10, 2) NOT NULL,
  	is_active BOOLEAN,
  	supplier_id INT
);

CREATE TABLE cart (
	cart_id INT AUTO_INCREMENT PRIMARY KEY,
	user_id int NOT NULL	
);


CREATE TABLE orders(
	order_id INT AUTO_INCREMENT PRIMARY KEY,
	cart_id INT,
	product_id INT,
	FOREIGN KEY (cart_id) REFERENCES cart (cart_id),
	FOREIGN KEY (product_id) REFERENCES product (product_id),
	quantity INT
);







