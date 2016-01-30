CREATE TABLE CUSTOMER (
	ID INT NOT NULL,
	VERSION INT,
	NAME VARCHAR(45),
	CREDIT INT
)
;


ALTER TABLE CUSTOMER ADD CONSTRAINT PK_CUSTOMER
PRIMARY KEY (
	ID
);

ALTER TABLE CUSTOMER ADD 
CHECK (ID IS NOT NULL);


------- Begin of CUSTOMER-------

insert into CUSTOMER (ID, VERSION, NAME, CREDIT ) values (1, 0, 'customer1', 101290);
insert into CUSTOMER (ID, VERSION, NAME, CREDIT ) values (2, 0, 'customer2', 101290);
insert into CUSTOMER (ID, VERSION, NAME, CREDIT ) values (3, 0, 'customer3', 101285);
insert into CUSTOMER (ID, VERSION, NAME, CREDIT ) values (4, 0, 'customer4', 101285);

------- End of CUSTOMER -------