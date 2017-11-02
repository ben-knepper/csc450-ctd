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

delimiter ;