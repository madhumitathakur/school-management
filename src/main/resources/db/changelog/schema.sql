CREATE TABLE class_details(	id int AUTO_INCREMENT  PRIMARY KEY,
	class_name varchar(20),
	admission_fee int,
	monthly_fee int,
	examination_fee int
	);
	
INSERT INTO class_details(
	id,
	class_name,
	admission_fee,
	monthly_fee,
	examination_fee)
VALUES(1,"First",  500,  300,  100),
	  (2,"Second", 500,  300,  100),
	  (3,"Third",  500,  300,  100),
	  (4,"Fourth", 600,  500,  150),
	  (5,"Fifth",  600,  500,  150),
	  (6,"Sixth",  700,  500,  200),
	  (7,"Seventh",700,  500,  300),
 	  (8,"Eighth", 800,  800,  300),
	  (9,"Ninth",  1000, 800,  300),
	  (10,"Tenth",  1000, 1100, 300);


CREATE TABLE user
(
	registration_id int AUTO_INCREMENT,
	firstname varchar(50),
	lastname varchar(50),
	email varchar(30),
	phone varchar(30),
	password varchar(100),
	address varchar(250),
	is_admin bit(1),
	class_id int,
	PRIMARY KEY (registration_id),
	FOREIGN KEY (class_id) REFERENCES class_details (id)
);

INSERT INTO user(registration_id,firstname,lastname,email,phone,password,address,class_id)	
VALUES(5,"Roushan", "Singh", "rkhome111@gmail.com", 9911476731, "12345", "Darbhanga",0,1),
	  (10,"Rohini", "Thakur", "rohini95kumari@gmail.com", 9123264288, "12345", "Darbhanga",1,2);



CREATE TABLE attendance
(
	id int AUTO_INCREMENT,
	registration_id int,
	subject varchar(50),
	total_class int,
	attended_class int,
	PRIMARY KEY (id),
	FOREIGN KEY (registration_id) REFERENCES user(registration_id)
);

INSERT INTO attendance(
	id,
	registration_id,
	subject,
	total_class,
	attended_class)
VALUES (1,5,"math", 100, 70),
	   (2,10,"science", 100, 60);


CREATE TABLE result
(	
	id int AUTO_INCREMENT,
	registration_id int,
	subject varchar(100),
	full_marks int,
	scored_marks int,
	PRIMARY KEY (id),
	FOREIGN KEY (registration_id) REFERENCES User(registration_id)
);

INSERT INTO result(
	id,
	registration_id,
	subject,
	full_marks,
	scored_marks)
VALUES (1,5,"math", 100, 75),
	   (2,10,"science", 100, 55);


CREATE TABLE fee_payment
(
	id int AUTO_INCREMENT,
	registration_id int,
	month varchar(30),
	amount_to_be_paid int,
	transaction_number varchar(30),
	date_of_payment varchar(30),
	status varchar(10),
	PRIMARY KEY (id),
	FOREIGN KEY (registration_id) REFERENCES User(registration_id)
);

INSERT INTO fee_payment(
	id,
	registration_id,
	month,
	amount_to_be_paid,
	transaction_number,
	date_of_payment,
	status)
VALUES(1,5,"june", 3000, "147852", now(), "paid"),
	  (2,10,"may", 3000, 123456, now(), "paid");
