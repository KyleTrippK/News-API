SET MODE PostgreSQL;
--
--CREATE DATABASE news;
--CREATE DATABASE news_test WITH TEMPLATE news;
--\c news

CREATE TABLE IF NOT EXISTS users (
id int PRIMARY KEY auto_increment,
 name VARCHAR,
 userDeparment VARCHAR,
 userPosition VARCHAR,
 role VARCHAR
);

CREATE TABLE IF NOT EXISTS departments (
id int PRIMARY KEY auto_increment,
 names VARCHAR,
 description VARCHAR,
 members INTEGER
);

CREATE TABLE IF NOT EXISTS posts (
 id int PRIMARY KEY auto_increment,
 author VARCHAR,
 title VARCHAR,
 content VARCHAR
);

CREATE TABLE IF NOT EXISTS user_departments(
id int PRIMARY KEY auto_increment,
user_id INTEGER,
department_id INTEGER
);