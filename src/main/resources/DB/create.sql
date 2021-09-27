--SET MODE PostgreSQL;
--
CREATE DATABASE news;
CREATE DATABASE news_test WITH TEMPLATE news;
\c news

CREATE TABLE IF NOT EXISTS users (
 id SERIAL PRIMARY KEY,
 name VARCHAR,
 userPosition VARCHAR,
 userDeparment VARCHAR,
 role VARCHAR
);

CREATE TABLE IF NOT EXISTS departments (
 id SERIAL PRIMARY KEY,
 title VARCHAR,
 description VARCHAR,
 members INTEGER
);

CREATE TABLE IF NOT EXISTS posts (
 id SERIAL PRIMARY KEY,
 author VARCHAR,
 title VARCHAR,
 content VARCHAR
);

CREATE TABLE IF NOT EXISTS user_departments(
id SERIAL PRIMARY KEY,
user_id INTEGER,
department_id INTEGER
)