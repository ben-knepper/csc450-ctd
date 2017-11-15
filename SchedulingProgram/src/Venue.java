
public class Venue {
	private String id;
	private String name;
	private int tables;
	private String address;
	private TimeSlot[] times; 
	
	public Venue(String i, String n, int t, String a) {
		id = i;
		name = n;
		address = a;
		tables = t;	
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
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
