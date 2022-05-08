show databases;
use dbms_sushma;
drop table supplier;
drop table customer;
drop table category;
drop table product;
drop table productDetails;
drop table orders;
drop table rating;
show tables;

create table supplier
(
supp_id int primary key,
supp_name varchar(50),
supp_city varchar(50),
supp_phone bigint
);

create table customer
(
cus_id int primary key,
cus_name varchar(50),
cus_phone bigint,
cus_city varchar(50),
cus_gender varchar(50)
);

create table category
(
cat_id int primary key,
cat_name varchar(50)
);

create table product
(
pro_id int primary key,
pro_name varchar(50),
pro_desc varchar(50),
cat_id int,
FOREIGN KEY (cat_id) REFERENCES category(cat_id)
);

create table productDetails
(
prod_id int primary key,
pro_id int,
supp_id int,
price int,
FOREIGN KEY (pro_id) REFERENCES product(pro_id),
FOREIGN KEY (supp_id) REFERENCES supplier(supp_id)
);

create table orders
(
ord_id int primary key,
ord_amount int,
ord_date date,
cus_id int,
prod_id int,
FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
FOREIGN KEY (prod_id) REFERENCES productDetails(prod_id)
);

create table rating
(
rat_id int primary key,
cus_id int,
supp_id int,
rat_ratstars int,
FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
FOREIGN KEY (supp_id) REFERENCES supplier(supp_id)
);

insert into supplier value(1, "Rajesh Retails", "Delhi", 1234567890);
insert into supplier value(2, "Appario Ltd.", "Mumbai", 2589631470);
insert into supplier value(3, "Knome products", "Banglore", 9785462315);
insert into supplier value(4, "Bansal Retails", "Kochi", 8975463285);
insert into supplier value(5, "Mittal Ltd.", "Lucknow", 7898456532);

insert into customer value(1, "AAKASH", 9999999999, "DELHI", "M");
insert into customer value(2, "AMAN", 9785463215, "NOIDA", "M");
insert into customer value(3, "NEHA", 9999999999, "MUMBAI", "F");
insert into customer value(4, "MEGHA", 9994562399, "KOLKATA", "F");
insert into customer value(5, "PULKIT", 7895999999, "LUCKNOW", "M");

insert into category value(1, "BOOKS");
insert into category value(2, "GAMES");
insert into category value(3, "GROCERIES");
insert into category value(4, "ELECTRONICS");
insert into category value(5, "CLOTHES");

insert into product value(1, "GTA V", "DFJDJFDJFDJFDJFJF", 2);
insert into product value(2, "TSHIRT", "DFDFJDFJDKFD", 5);
insert into product value(3, "ROG LAPTOP", "DFNTTNTNTERND", 4);
insert into product value(4, "OATS", "REURENTBTOTH", 3);
insert into product value(5, "HARRY POTTER", "NBEMCTHTJTH", 1);

insert into productDetails value(1, 1, 2, 1500);
insert into productDetails value(2, 3, 5, 30000);
insert into productDetails value(3, 5, 1, 3000);
insert into productDetails value(4, 2, 3, 2500);
insert into productDetails value(5, 4, 1, 1000);

insert into orders value(20, 1500, "2021-10-12", 3, 5);
insert into orders value(25, 30500, "2021-09-16", 5, 2);
insert into orders value(26, 2000, "2021-10-05", 1, 1);
insert into orders value(30, 3500, "2021-08-16", 4, 3);
insert into orders value(50, 2000, "2021-10-06", 2, 1);

insert into rating value(1, 2, 2, 4);
insert into rating value(2, 3, 4, 3);
insert into rating value(3, 5, 1, 5);
insert into rating value(4, 1, 3, 2);
insert into rating value(5, 4, 5, 4);

/*3)Display the number of the customer group by their genders who have placed any order of amount greater than or equal to Rs.3000.*/
select cus_gender, count(c.cus_id) from customer c inner join orders o on o.cus_id=c.cus_id where ord_amount>=3000 group by cus_gender;

/*4)Display all the orders along with the product name ordered by a customer having Customer_Id=2. */
select o.ord_id, pr.pro_name, o.ord_amount, o.ord_date, o.cus_id, pd.prod_id from orders o 
inner join productdetails pd on pd.prod_id=o.prod_id
inner join product pr on pr.pro_id=pd.pro_id where o.cus_id=2;

/*5)Display the Supplier details who can supply more than one product. */
select s.supp_id as 'Supplier ID', s.supp_name as 'Supplier Name', s.supp_city as 'City', s.supp_phone as 'Phone', count(pd.prod_id) as 'No of Products' from supplier s
inner join productdetails pd on pd.supp_id=s.supp_id group by pd.supp_id
having count(pd.prod_id)>1 order by count(pd.prod_id);

/*6)Find the category of the product whose order amount is minimum.*/
select c.*, pr.pro_name, o.ord_amount from category c
inner join product pr on pr.cat_id=c.cat_id
inner join productdetails pd on pd.pro_id=pr.pro_id
inner join orders o on o.prod_id=pd.prod_id having min(o.ord_amount);

/*7)Display the Id and Name of the Product ordered after “2021-10-05”. */
select o.ord_id as 'Order Id', pr.pro_id as 'Product Id', pr.pro_name as 'Product Name' from orders o
inner join productdetails pd on pd.prod_id=o.prod_id
inner join product pr on pr.pro_id=pd.pro_id where o.ord_date>'2021-10-05';

/*8)Display customer name and gender whose names start or end with character 'A'.*/
select cus_name as 'Customer Name', cus_gender as 'Gender' from customer where cus_name like 'A%' or cus_name like '%A';

/* 9)Create a stored procedure to display the Rating for a Supplier if any along with the Verdict on that rating if any like if rating >4 then “Genuine Supplier” if rating >2 “Average Supplier” else “Supplier should not be considered”.

select supplier.supp_id, Supplier.supp_name, rating.rat_ratstars,
case
	when rating.rat_ratstars > 4 then 'Genuine Supplier'
	when rating.rat_ratstars > 2 then 'Average Supplier'
	else 'Supplier should not be considered'
end as verdict
from rating
inner join supplier on supplier.supp_id=rating.supp_id;
