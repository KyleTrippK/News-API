SET MODE PostgreSQL;

CREATE DATABASE news;
\c news
CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 userPosition VARCHAR,
 userDeparment VARCHAR,
 role VARCHAR,
);

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 description VARCHAR,
 members INTEGER
);

CREATE TABLE IF NOT EXISTS posts (
 id int PRIMARY KEY auto_increment,
 author VARCHAR,
 title VARCHAR,
 content VARCHAR,
);