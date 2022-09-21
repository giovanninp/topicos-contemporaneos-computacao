# Setting up MySQL
## Create payroll user

```
	$ mysql -u root -p
	mysql $ CREATE USER 'payroll'@'localhost' IDENTIFIED BY '1234';
	mysql $ GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'payroll'@'localhost' WITH GRANT OPTION;
```