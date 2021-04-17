# jpa-examples
A repository for Spring JPA examples

This is a small and simple example for how to use Spring JPA for fetching data from a database.

Import the project as a gradle project

## I used:

* PhpMyAdmin (for creating the MySql database)
* Eclipse (for implementing the example)
* STS Tools (plugin to Eclipse that ensures you can work with Spring boot)
* Gradle (for setting up the dependecies)

## Database

The connection to the database is setup up in application.properties.
If you need to change to another kind of database change this file:

application.properties (change the parameters to match your database)

Also, edit in build.gradle (I added this line to get the right dependencies for MySql - you will need some other dependency: implementation 'mysql:mysql-connector-java:8.0.11')

## SQL queries for creating the example database

If you want a quick shortcut to creating the database I was using - feel free to copy and execute these SQL statements:

```

/* CREATE THE DATABASE */

CREATE DATABASE myjpaexampledb

/*CREATE THE CUSTOMERS TABLE */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*DATA FOR THE TABLE `customers` */

insert  into `customers`(`customer_id`,`customer_name`) values 

(1,'Jane Nelson'),
(2,'John Hansson'),
(3,'Peter Sellers'),
(4,'Mary Jane Peterson'),
(5,'Heather Johson');

/*CREATE THE ORDERS TABLE */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `required_date` date NOT NULL,
  `shipped_date` date DEFAULT NULL,
  `order_status` varchar(15) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT FK FOREIGN KEY (customer_id)
  REFERENCES customers (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*DATA FOR THE TABLE `orders` */

insert  into `orders`(`order_id`,`required_date`,`shipped_date`,`order_status`,`customer_id`) values 

(10100,'2003-01-06','2003-01-13','Shipped',1),
(10101,'2003-01-09','2003-01-18','Shipped',2),
(10102,'2003-01-10','2003-01-18','Shipped',2),
(10103,'2003-01-29','2003-02-07','Shipped',3),
(10104,'2003-01-31','2003-02-09','Shipped',5);

```

## Controller.java

Controller.java makes sure that if you test with the endpoint "Customers" this class will take you to the right place.

With this class, it's possible to test with the endpoints:

```
/customers 
/customers/{/id}
```

## CustomerEntity.java and CustomerRepository.java

This is where the magic happens and where you fetch the data from the database.

Refer to this explanation that I posted on medium.com:
https://medium.com/destinationaarhus-techblog/spring-jpa-say-goodbye-to-sql-and-boilerplate-code-in-your-java-application-2246e4683352

## How to test

Make sure that your database is up and running locally (in my case, phpMyAdmin)

Run this file as a SpringApplication: /spring-boot-jpa/src/main/java/com/example/demo/SpringBootJpaApplication.java

In Postman, hit these end points: 
localhost:8080/customers/
localhost:8080/customers/1

.. and see the results of fetching data :+1:

 
![image](https://user-images.githubusercontent.com/45855658/114501097-9b6aec00-9c29-11eb-9292-b3e74874143c.png)
