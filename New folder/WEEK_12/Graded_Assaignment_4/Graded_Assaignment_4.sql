show databases;
use dbms_sushma;

create table PASSENGER (
Passenger_name varchar(50),
Category varchar(50),
Gender varchar(50),
Boarding_City varchar(50),
Destination_City varchar(50),
Distance int,
Bus_Type varchar(50)
);
create table PRICE(
Bus_Type varchar(50),
Distance int,
Price int
);

insert into PASSENGER value("Sejal", "AC", "F", "Bengaluru", "Chennai", 350, "Sleeper");
insert into PASSENGER value("Anmol", "Non-AC", "M", "Mumbai", "Hyderabad", 700, "Sitting");
insert into PASSENGER value("Pallavi", "AC", "F", "Panaji", "Bengaluru", 600, "Sleeper");
insert into PASSENGER value("Khusboo", "AC", "F", "Chennai", "Mumbai", 1500, "Sleeper");
insert into PASSENGER value("Udit", "Non-AC", "M", "Trivandrum", "panaji", 1000, "Sleeper");
insert into PASSENGER value("Ankur", "AC", "M", "Nagpur", "Hyderabad", 500, "Sitting");
insert into PASSENGER value("Hemant", "Non-AC", "M", "panaji", "Mumbai", 700, "Sleeper");
insert into PASSENGER value("Manish", "Non-AC", "M", "Hyderabad", "Bengaluru", 500, "Sitting");
insert into PASSENGER value("Piyush", "AC", "M", "Pune", "Nagpur", 700, "Sitting");

insert into PRICE value("Sleeper", 350, 770);
insert into PRICE value("Sleeper", 500, 1100);
insert into PRICE value("Sleeper", 600, 1320);
insert into PRICE value("Sleeper", 700, 1540);
insert into PRICE value("Sleeper", 1000, 2200);
insert into PRICE value("Sleeper", 1200, 2640);
insert into PRICE value("Sleeper", 1500, 2700);
insert into PRICE value("Sitting", 500, 620);
insert into PRICE value("Sitting", 600, 744);
insert into PRICE value("Sitting", 700, 868);
insert into PRICE value("Sitting", 1000, 1240);
insert into PRICE value("Sitting", 1200, 1488);
insert into PRICE value("Sitting", 1500, 18600);

/* 3) How many females and how many male passengers travelled for a minimum distance of 600 KM s? */
select gender, count(Passenger_name) from PASSENGER where Distance>=600 group by gender;

/* 4) Find the minimum ticket price for Sleeper Bus. */
Select Bus_Type, min(price) from PRICE where Bus_Type="Sleeper";

/* 5) Select passenger names whose names start with character 'S' */
select Passenger_name as 'Passenger Name' from PASSENGER where Passenger_name like 'S%';

/* 6) Calculate price charged for each passenger displaying Passenger name, Boarding City,Destination City, Bus_Type, Price in the output */
select p.Passenger_name as 'Passenger Name', p.Boarding_City as 'Boarding City', p.Destination_City as 'Destination City', p.Bus_Type as 'Bus Type', pr.price from PASSENGER p
inner join PRICE pr on pr.Distance=p.Distance and pr.Bus_Type=p.Bus_Type;

/* 7) What are the passenger name/s and his/her ticket price who travelled in the Sitting bus for a distance of 1000 KM s */
select p.Passenger_name as 'Passenger Name', p.Distance as 'Distance', pr.price as 'Price', p.Bus_Type as 'Bus Type' from PASSENGER p
inner join PRICE pr on pr.Bus_Type=p.Bus_Type and pr.Distance=p.Distance where p.Bus_Type="Sleeper" and p.Distance=1000;

/* 8) What will be the Sitting and Sleeper bus charge for Pallavi to travel from Bangalore to Panaji? */
Select p.Passenger_name as 'Passenger Name', p.Boarding_City as 'Boarding City', p.Destination_City as 'Destination City', pr.Bus_Type as 'Bus Type', pr.price from PASSENGER p
inner join PRICE pr on pr.Distance=p.Distance where Passenger_name='Pallavi' and p.Distance=pr.Distance;

/* 9) List the distances from the "Passenger" table which are unique (non-repeated distances) in descending order. */
Select distinct Distance from PASSENGER order by Distance desc;

/*10) Display the passenger name and percentage of distance travelled by that passenger from the total distance travelled by all passengers without using user variables */
SELECT Passenger_name as 'Passenger Name', Distance * 100.0/ (SELECT SUM(Distance) FROM PASSENGER)FROM PASSENGER GROUP BY Distance;

/* 11) Display the distance, price in three categories in table Price
a) Expensive if the cost is more than 1000
b) Average Cost if the cost is less than 1000 and greater than 500
c) Cheap otherwise */
select Distance, Price,
case
	when Price > 1000 then 'Expensive'
	when Price > 500 and Price < 1000 then 'Average Cost'
	else 'Cheap'
end as verdict
from PRICE;

