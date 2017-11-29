import java.util.Dictionary;
//Object containing an Employee's scheduling and contact information.

public class Employee {
	private String firstName;
	private String id;
	private String lastName;
	private String phone;
	private String address;
	private String password;
	private String email;
	private boolean manager;
	private Dictionary<TimeSlot, String> times;
/**
 * 
 * @param f First name
 * @param l Last name
 * @param i Use ID
 * @param p Phone Number
 * @param a Address
 * @param ip Password
 * @param e Email
 */
public Employee(String f, String l, String i,
		String p, String a, String ip, String e){
	//constructor
	firstName = f;
	lastName = l;
	id = i;
	phone = p;
	address = a;
	password = ip;
	manager = false;
	email = e;
	times = buildTimeSlots();
    }

public Dictionary<TimeSlot, String> buildTimeSlots(){
	//creates a dictionary of time slots, each of which contains a "yes" or "no" value.
	for (int h = 0; h < 168; h++){
		times.put(new TimeSlot(h), "n");
	}
	return times;
	
	
}

public String getEmail() {
	return email; 
}


public void setEmail(String email) {
	this.email = email;
}


public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public boolean isManager() {
	return manager;
}

public void setManager(boolean manager) {
	this.manager = manager;
}
public String getPassword() {
	return password;
}

public void setPassword(String pw) {
	this.password = pw;
}

public void addTimes(TimeSlot t){
	//Sets an existing time slot to "yes".
	int iden = t.getId();

	times.put(new TimeSlot(iden), "y");
}
public void removeTimes(TimeSlot t){

	//Sets an existing time slot to "no".
	int iden = t.getId();

	times.put(new TimeSlot(iden), "n");
}
public void blockTimes(TimeSlot t){

	//Sets an existing time slot to "blocked" - it will be considered as a "no" temporarily.
	int iden = t.getId();

	times.put(new TimeSlot(iden), "b");
}

public Dictionary<TimeSlot, String> getTimes() {
	return times;
}
public String toString() {
	return(this.firstName + " " + this.lastName + " " + id);
}



}
