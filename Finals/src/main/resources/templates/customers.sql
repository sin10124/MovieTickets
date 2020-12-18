
CREATE TABLE customers (user_id int Primary Key auto_increment, firstname varchar(30), lastname varchar(30), email varchar(30), phone varchar(12), pass varchar(20));

INSERT INTO customers VALUES 
(101, 'John', 'Smith',"asd@gmail.com", "23232343444", "sssssssssss"),
(102, 'Joe', 'Williams', "afgghr@gmail.com", "454354356", "gdfgdfsg"),
(103, 'Kayla', 'Jones', "sdfsdg@gmail.com", "3454352435", "sfsftsg"),
(104, 'Akash', 'Buttar', "sdsg@gmail.com", "35345435435", "buttar"),
(105, 'Arman', 'Buttar', "jebfhesfg@gmail.com", "3454354543", "dfdsfdsrere");
select * from customers;