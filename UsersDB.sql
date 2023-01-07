CREATE TABLE users (
  user_id int NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL UNIQUE,
  full_name varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  enabled boolean,
  PRIMARY KEY (user_id)
);
 
CREATE TABLE roles (
  role_id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (role_id)
);
 
CREATE TABLE users_roles (
  user_id int NOT NULL,
  role_id int NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles (role_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  PRIMARY KEY (role_id, user_id)
);