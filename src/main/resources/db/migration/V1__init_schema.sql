CREATE TABLE car_entity (
  id INTEGER NOT NULL,
   make VARCHAR(255),
   model VARCHAR(255),
   color VARCHAR(255),
   release_year INTEGER NOT NULL,
   price_per_hour DOUBLE PRECISION NOT NULL,
   CONSTRAINT pk_carentity PRIMARY KEY (id)
);

CREATE TABLE customer_entity (
  id INTEGER NOT NULL,
   address VARCHAR(255),
   email VARCHAR(255),
   CONSTRAINT pk_customerentity PRIMARY KEY (id)
);

CREATE TABLE booking_entity (
  id INTEGER NOT NULL,
   start_time TIMESTAMP WITHOUT TIME ZONE,
   end_time TIMESTAMP WITHOUT TIME ZONE,
   state VARCHAR(255),
   booking_car INTEGER,
   booking_customer INTEGER,
   CONSTRAINT pk_bookingentity PRIMARY KEY (id)
);

ALTER TABLE booking_entity ADD CONSTRAINT FK_BOOKINGENTITY_ON_BOOKING_CAR FOREIGN KEY (booking_car) REFERENCES car_entity (id);

ALTER TABLE booking_entity ADD CONSTRAINT FK_BOOKINGENTITY_ON_BOOKING_CUSTOMER FOREIGN KEY (booking_customer) REFERENCES customer_entity (id);




CREATE TABLE address_entity (
  id INTEGER NOT NULL,
   house_no VARCHAR(255),
   street VARCHAR(255),
   city VARCHAR(255),
   country VARCHAR(255),
   CONSTRAINT pk_addressentity PRIMARY KEY (id)
);


CREATE TABLE contact_entity (
  id INTEGER NOT NULL,
   email VARCHAR(255),
   phone_no VARCHAR(255),
   CONSTRAINT pk_contactentity PRIMARY KEY (id)
);



CREATE TABLE user_info_entity (
  id INTEGER NOT NULL,
   name VARCHAR(255),
   password VARCHAR(255),
   role VARCHAR(255),
   address_id INTEGER,
   contacts_entity_id INTEGER,
   CONSTRAINT pk_userinfoentity PRIMARY KEY (id)
);

ALTER TABLE user_info_entity ADD CONSTRAINT FK_USERINFOENTITY_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address_entity (id);

ALTER TABLE user_info_entity ADD CONSTRAINT FK_USERINFOENTITY_ON_CONTACTS_ENTITY FOREIGN KEY (contacts_entity_id) REFERENCES contact_entity (id);

CREATE SEQUENCE  IF NOT EXISTS address_entity_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE  IF NOT EXISTS contact_entity_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE  IF NOT EXISTS user_info_entity_seq START WITH 1 INCREMENT BY 50;















