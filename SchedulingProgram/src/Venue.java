
public class Venue {
	private String ID;
	private String name;
	private String address;
	private int tables;
	private TimeSlot[] times; 
		
	public Venue(String id, String n, int t, String a) {
		ID = id;
		name = n;
		tables = t;
		address = a;
		
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTables() {
		return tables;
	}
	
	public void setTables(int tables) {
		this.tables = tables;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return this.name;
	}
}
