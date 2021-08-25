use CarShop;/* the database name */
CREATE TABLE Users (
   id int(11) AUTO_INCREMENT,
   first_name varchar(150) NOT NULL,
   last_name varchar(150) NOT NULL,
   username varchar(150) NOT NULL,
   email varchar(150) NOT NULL,
   password varchar(150) NOT NULL,
   role varchar(150) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO Users (first_name, last_name, username, email, password, role) VALUES ('Ahmed','Sabry', 'hamada', 'hamada@gmail.com', 'rloal#', 'emp');
INSERT INTO Users (first_name, last_name, username, email, password, role) VALUES ('Ahmed','Sabry', 'a', 'hamada@gmail.com', '1', 'emp');
INSERT INTO Users (first_name, last_name, username, email, password, role) VALUES ('Ahmed','Sabry', 'b', 'hamada@gmail.com', 'lol', 'emp');


CREATE TABLE Cars (
   id int(11) AUTO_INCREMENT,
   brand varchar(150) NOT NULL,
   model varchar(150) NOT NULL,
   year int(11) NOT NULL,
   color varchar(150) NOT NULL,
   country char(2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (country) REFERENCES Country(country_code) on DELETE CASCADE
);

INSERT INTO Cars (brand, model, year, color, country) VALUES ('Mercedes','C-Class', '2019', 'red', 'DE');
INSERT INTO Cars (brand, model, year, color, country) VALUES ('Kia','Cerato', '2009', 'brown', 'DE');
INSERT INTO Cars (brand, model, year, color, country) VALUES ('BMW','M5', '2020', 'black', 'DE');

CREATE TABLE Country (
   country_code char(2) NOT NULL,
   name varchar(150) NOT NULL,
  PRIMARY KEY (country_code)
);

INSERT INTO Country (country_code, name) VALUES ('CH', 'China');
INSERT INTO Country (country_code, name) VALUES ('FR', 'France');
INSERT INTO Country (country_code, name) VALUES ('DE', 'Germany');
INSERT INTO Country (country_code, name) VALUES ('IN', 'India');
INSERT INTO Country (country_code, name) VALUES ('IT', 'Italy');
INSERT INTO Country (country_code, name) VALUES ('JP', 'Japan');
INSERT INTO Country (country_code, name) VALUES ('KR', 'Korea');
INSERT INTO Country (country_code, name) VALUES ('RS', 'Russia');
INSERT INTO Country (country_code, name) VALUES ('SP', 'Spain');
INSERT INTO Country (country_code, name) VALUES ('TR', 'Turkey');
INSERT INTO Country (country_code, name) VALUES ('GB', 'United Kingdom');
INSERT INTO Country (country_code, name) VALUES ('US', 'United States');


SELECT * FROM Cars C
INNER JOIN Country L ON
C.country = L.country_code;
