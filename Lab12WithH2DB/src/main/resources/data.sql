DROP TABLE IF EXISTS mycustomers;

CREATE TABLE mycustomers (
  cid INT AUTO_INCREMENT  PRIMARY KEY,
  cname VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL,
  phone INT(20) DEFAULT NULL
);

INSERT INTO mycustomers (cname, email, city, phone) VALUES('Aliko1', 'Dangote1@gmail', 'Bang1', 12345);
INSERT INTO mycustomers (cname, email, city, phone) VALUES('Aliko1', 'Dangote1@gmail', 'Bang1', 12345);
INSERT INTO mycustomers (cname, email, city, phone) VALUES('Aliko1', 'Dangote1@gmail', 'Bang1', 12345);