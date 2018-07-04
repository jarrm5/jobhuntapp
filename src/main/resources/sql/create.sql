CREATE TABLE APP_USER (
	user_id int NOT NULL AUTO_INCREMENT,
	username varchar(20) NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE LOCATION (
	location_id int NOT NULL AUTO_INCREMENT,
	street varchar(30),
	city varchar(30) NOT NULL,
	state varchar(2) NOT NULL,
	zip varchar(5),
	PRIMARY KEY (location_id)
);

CREATE TABLE CONTACT (
	contact_id int NOT NULL AUTO_INCREMENT,
	first_name varchar(30),
	last_name varchar(30) NOT NULL,
	phone varchar(10),
	email varchar(50),
	PRIMARY KEY (contact_id)
);

CREATE TABLE JOB_LISTING (
	job_listing_id int NOT NULL AUTO_INCREMENT,
	position_title varchar(50) NOT NULL,
	description varchar(200),
	listing_link varchar(200),
	date_applied date,
	company_id int,
	PRIMARY KEY (job_listing_id),
	CONSTRAINT FK_JOB_LISTING_COMPANY FOREIGN KEY (company_id) REFERENCES COMPANY(company_id)
);

CREATE TABLE USER_JOB_LISTING (
	user_id int NOT NULL,
	job_listing_id int NOT NULL,
	CONSTRAINT FK_USER_ID_USER_JOB_LISTING FOREIGN KEY (user_id) REFERENCES APP_USER(user_id),
	CONSTRAINT FK_JOB_LISTING_ID_USER_JOB_LISTING FOREIGN KEY (job_listing_id) REFERENCES JOB_LISTING(job_listing_id)
);

CREATE TABLE CONTACT_JOB_LISTING (
	contact_id int NOT NULL,
	job_listing_id int NOT NULL,
	CONSTRAINT FK_CONTACT_ID_USER_JOB_LISTING FOREIGN KEY (contact_id) REFERENCES CONTACT(contact_id),
	CONSTRAINT FK_JOB_LISTING_ID_CONTACT_JOB_LISTING FOREIGN KEY (job_listing_id) REFERENCES JOB_LISTING(job_listing_id)
);

CREATE TABLE COMPANY (
	company_id int NOT NULL AUTO_INCREMENT,
	company_name varchar(50) NOT NULL,
	website varchar(50),
	location_id int, 
	CONSTRAINT FK_LOCATION_ID FOREIGN KEY (location_id) REFERENCES LOCATION(location_id),
	PRIMARY KEY (company_id)
);


