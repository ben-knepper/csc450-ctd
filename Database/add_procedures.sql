drop procedure if exists GetTable;

drop procedure if exists GetEmployeeInfo;
drop procedure if exists AddEmployee;
drop procedure if exists UpdateEmployee;
drop procedure if exists UpdateManager;
drop procedure if exists SearchEmployee;

drop procedure if exists GetVenueInfo;
drop procedure if exists AddVenue;
drop procedure is exists UpdateVenue;
drop procedure if exists SearchVenue;

drop procedure if exists AddBlacklisted;
drop procedure if exists SearchBlacklistedEmployee;
drop procedure if exists SearchBlacklistedVenue;

drop procedure if exists AddVenueDateTime;
drop procedure if exists SearchVenueDateTime;

drop procedure if exists AddScheduled;
drop procedure if exists SearchScheduledEmployee;
drop procedure if exists SearchScheduledVenue;

drop procedure if exists AddAvailability;
drop procedure if exists SearchAvailability;

delimiter //

create procedure GetTable(
	in t_name varchar(15)
)
begin
	select * from t_name;
end//

/*Employee Procedures*/
create procedure GetEmployeeInfo(
	in f_name varchar(15),
	in l_name varchar(15),
	in t_column varchar(15)
)
begin
	select t_column from employee
		where f_name = fName
		and l_name = lName;
end//

create procedure AddEmployee(
	in fName varchar(15),
	in lName varchar(15),
	in password varchar(15),
	in phone varchar(15),
	in email varchar(25),
	in isManager boolean
)
begin
	insert into employee
		values(
			fName, lName, password, phone, email, isManager
		);
end//

create procedure UpdateEmployee(
	in e_column varchar(10),
	in e_value varchar(25),
	in e_id varchar(10)
)
begin
	update employee set e_column = e_value
		where e_id = employeeID;
end//

create procedure UpdateManager(
	in is_man boolean,
	in e_id varchar(10)
)
begin
	update employee set isManager = is_man
		where e_id = employeeID;
end//

create procedure SearchEmployee(
	in f_name varchar(15),
	in l_name varchar(15)
)
begin
	select * from employee
		where f_name = fName
		and l_name = lName;
end//

/*Venue Procedures*/
create procedure GetVenueInfo(
	in v_name varchar(10),
	in t_column varchar(10)
)
begin
	select t_column from venue
		where v_name = name;
end//

create procedure AddVenue(
	in venueID varchar(10),
	in name varchar(20),
	in tableNum varchar(5),
	in address varchar(50)
)
begin
	insert into venue
		values(
			venueID, name, tableNum, address
		);
end//

create procedure UpdateVenue(
	in v_column varchar(10),
	in v_value varchar(50),
	in v_venue varchar(10)
)
begin
	update venue set v_column = v_value
		where v_id = venueID;
end//

create procedure SearchVenue(
	in v_name varchar(20)
)
begin
	select * from venue
		where v_name = name;
end//

/*Blacklisted Procedures*/
create procedure AddBlacklisted(
	in e_id varchar(10),
	in v_id varchar(10)
)
begin
	insert into blacklisted values(
		e_id, v_id
	);
end//

create procedure SearchBlacklistedEmployee(
	in e_id varchar(10)
)
begin
	select venueID from blacklisted
		where e_id = employeeID;
end//

create procedure SearchBlacklistedVenue(
	in v_id varchar(10)
)
begin
	select employeeID from blacklisted
		where v_id = venueID;
end//

/*Venue Date Time Procedures*/
create procedure AddVenueDateTime(
	in v_id varchar(10),
	in s_date_time datetime,
	in e_date_time datetime,
	in is_open boolean
)
begin
	insert into venue_date_time values(
		v_id, s_date_time, e_date_time, is_open
	);
end//

create procedure SearchVenueDateTime(
	in v_id varchar(10)
)
begin
	select * from venue_date_time
		where v_id = venueID;
end//

/*Scheduled Procedures*/
create procedure AddScheduled(
	in e_id varchar(10),
	in v_id varchar(10),
	in s_date_time datetime
)
begin
	insert into scheduled values(
		e_id, v_id, s_date_time
	);
end//

create procedure SearchScheduledEmployee(
	in e_id varchar(10)
)
begin
	select * from scheduled
		where e_id = employeeID;
end//

create procedure SearchScheduledVenue(
	in v_id varchar(10)
)
begin
	select * from scheduled
		where v_id = venueID;
end//

/*Availability Procedures*/
create procedure AddAvailability(
	in e_id varchar(10),
	in weekday varchar(10),
	in s_time time,
	in e_time time
)
begin
	insert into availability values(
		e_id, weekday, s_time, e_time
	);
end//

create procedure SearchAvailability(
	in e_id varchar(10)
)
begin
	select * from availability
		where e_id = employeeID;
end//

delimiter ;