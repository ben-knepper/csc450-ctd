/*Drop tables*/
drop table if exists availability;
drop table if exists scheduled;
drop table if exists venue_date_time;
drop table if exists blacklisted;
drop table if exists venue;
drop table if exists employee;

/*Create tables*/
create table employee (
	employeeID varchar(10),
	fName varchar(15),
	lName varchar(15),
	password varchar(15),
	phone varchar(15),
	email varchar(25),
	isManager boolean,
	primary key(employeeID)
);

create table venue (
	venueID varchar(10),
	name varchar(20),
	tableNum varchar(5),
	address varchar(50),
	primary key(venueID)
);

create table blacklisted (
	employeeID varchar(10),
	venueID varchar(10),
	primary key(employeeID, venueID),
	foreign key(employeeID) references employee(employeeID) 
		on delete cascade 
		on update cascade,
	foreign key(venueID) references venue(venueID)
		on delete cascade
		on update cascade
);

create table venue_date_time (
	venueID varchar(10),
	startDateTime datetime,
	endDateTime datetime,
	isOpen boolean,
	primary key(venueID, startDateTime),
	foreign key(venueID) references venue(venueID)
		on delete cascade
		on update cascade
);

create table scheduled (
	employeeID varchar(10),
	venueID varchar(10),
	startDateTime datetime,
	primary key(employeeID, venueID, startDateTime),
	foreign key(employeeID) references employee(employeeID)
		on delete cascade
		on update cascade,
	foreign key(venueID) references venue(venueID)
		on delete cascade
		on update cascade,
	foreign key(startDateTime) references venue_date_time(startDateTime)
		on delete cascade
		on update cascade
);

create table availability (
	employeeID varchar(10),
	dayOfWeek varchar(10),
	startTime time,
	endTime time,
	primary key(employeeID, dayOfWeek, startTime),
	foreign key(employeeID) references employee(employeeID)
		on delete cascade
		on update cascade
);