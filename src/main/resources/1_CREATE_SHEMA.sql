CREATE SCHEMA KURSOVOY;
CREATE TABLE KURSOVOY.USERS (
  USER_ID INT NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR(45) NOT NULL,
  LAST_NAME VARCHAR(45) NOT NULL,
  AGE INT NULL,
  PRIMARY KEY (USER_ID)) 
DEFAULT CHARSET=utf8;