CREATE TABLE  users (
   username varchar(100) NOT NULL, password varchar(100) NOT NULL, PRIMARY KEY (username) 
 );


CREATE TABLE usercomments
(
username varchar(100), comments varchar(200) NOT NULL, date varchar(100) NOT NULL,
FOREIGN KEY (username) REFERENCES users(username)
);