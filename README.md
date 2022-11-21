# Setting up MySQL
## Create payroll user

```bash
	$ mysql -u root -p
	mysql $ CREATE USER 'payroll'@'localhost' IDENTIFIED BY '1234';
	mysql $ GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'payroll'@'localhost' WITH GRANT OPTION;
```

#Running on docker
## Building image
```bash
 $ docker build -t spring-example .
```
## Starting container
```
 $ docker run -d -p 8080:8080 spring-example
```

