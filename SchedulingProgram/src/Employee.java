import java.util.Dictionary;
import java.util.Hashtable;
//Object containing an Employee's scheduling and contact information.

public class Employee {
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private String phone;
	private String email;
	private boolean manager;
/**
 * 
 * @param i Use ID
 * @param f First name
 * @param l Last name
 * @param p Phone Number
 * @param ip Password
 * @param e Email
 */
	public Employee(String i, String f, String l, String ip, String p, String e) {
			//constructor
			id = i;
			firstName = f;
			lastName = l;
			password = ip;
			phone = p;
			manager = false;
			email = e;
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
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	public String toString() {
		return getFullName();
	}
	
	public boolean equals(Employee employee){
		return this.getId().equals(employee.getId());
			
	}
}
