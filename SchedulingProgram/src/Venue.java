
public class Venue {
	private String name;
	private String address;
	private int tables;
	private TimeSlot[] times; 
	
	
	
	
public Venue(String n, String a, int t) {
	name = n;
	address = a;
	tables = t;
	
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getAddress() {
	return address;
}




public void setAddress(String address) {
	this.address = address;
}




public int getTables() {
	return tables;
}




public void setTables(int tables) {
	this.tables = tables;
}
}
