
public class Employee {
	private String firstName;
	private String id;
	private String lastName;
	private String phone;
	private String email;
	private boolean manager;
	private TimeSlot[] times;
<<<<<<< HEAD
	private Database database;
public Employee(String f, String l, String i,
		String p, String a){
	firstName = f;
	lastName = l;
	id = i;
	phone = p;
	address = a;
	manager = false;
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


=======

	public Employee(String i, String f, String l, String p, String e) {
		id = i;
		firstName = f;
		lastName = l;
		phone = p;
		email = e;
		manager = false;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isManager() {
		return manager;
	}
	
	public void setManager(boolean manager) {
		this.manager = manager;
	}
>>>>>>> f1cfb8e71e4e8be3c19664d2d20c26a10c9bc604
}