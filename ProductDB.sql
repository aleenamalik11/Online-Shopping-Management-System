
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








