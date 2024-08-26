-- First off, create a new user with a password.
CREATE USER demo WITH PASSWORD 'demo';

-- Create a database afterwards, set the owner to your newly created user.
CREATE DATABASE demo OWNER demo;

-- Create the sequence.
-- TODO:: increments 50??
CREATE SEQUENCE IF NOT EXISTS house_price_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE house_price
(
    id    INTEGER NOT NULL,
    price INTEGER,
    date  date,
    CONSTRAINT pk_houseprice PRIMARY KEY (id)
);

-- Create some fake records. TODO:: create a few more
INSERT INTO house_price (price, date) values (375000, NOW());

-- Validate the records have been added.
select * from house_price;