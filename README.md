## Bank Mangement System

This Bank management system aka ATM Simulator System is a desktop based application. It functions similarly to a normal ATM. This ATM Simulator System has functionalities like Opening Banking Account, Deposit, Withdrawl, MiniStatement, Pin Change, etc.

## Technologies used
- Core Java (Swing & AWT)
- Database Used: MySQL
- IDE used: Netbeans

## MySQL Tables Schemas

### Signup

| Field          | Type        | Null | Key | Default | Extra |
|----------------|-------------|------|-----|---------|-------|
| formno         | varchar(20) | YES  |     | NULL    |       |
| name           | varchar(20) | YES  |     | NULL    |       |
| father_name    | varchar(20) | YES  |     | NULL    |       |
| dob            | varchar(20) | YES  |     | NULL    |       |
| gender         | varchar(20) | YES  |     | NULL    |       |
| email          | varchar(50) | YES  |     | NULL    |       |
| marital_status | varchar(20) | YES  |     | NULL    |       |
| address        | varchar(50) | YES  |     | NULL    |       |
| city           | varchar(25) | YES  |     | NULL    |       |
| pincode        | varchar(20) | YES  |     | NULL    |       |
| state          | varchar(20) | YES  |     | NULL    |       |

### signuptwo

| Field            | Type        | Null | Key | Default | Extra |
|------------------|-------------|------|-----|---------|-------|
| formno           | varchar(20) | YES  |     | NULL    |       |
| religion         | varchar(20) | YES  |     | NULL    |       |
| category         | varchar(20) | YES  |     | NULL    |       |
| income           | varchar(20) | YES  |     | NULL    |       |
| education        | varchar(20) | YES  |     | NULL    |       |
| occupation       | varchar(50) | YES  |     | NULL    |       |
| pan              | varchar(20) | YES  |     | NULL    |       |
| aadhar           | varchar(50) | YES  |     | NULL    |       |
| senior_citizen   | varchar(25) | YES  |     | NULL    |       |
| existing_account | varchar(20) | YES  |     | NULL    |       |

### signupthree

+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| formno       | varchar(20)  | YES  |     | NULL    |       |
| account_type | varchar(40)  | YES  |     | NULL    |       |
| card_number  | varchar(16)  | YES  |     | NULL    |       |
| pin          | varchar(10)  | YES  |     | NULL    |       |
| facility     | varchar(100) | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+

### login

+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| formno      | varchar(20) | YES  |     | NULL    |       |
| card_number | varchar(16) | YES  |     | NULL    |       |
| pin         | varchar(10) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+

### bank

+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| pin    | varchar(20) | YES  |     | NULL    |       |
| date   | varchar(50) | YES  |     | NULL    |       |
| type   | varchar(20) | YES  |     | NULL    |       |
| amount | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+


