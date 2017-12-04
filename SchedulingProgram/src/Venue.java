import java.util.Dictionary;
//Object containing a Venue's scheduling and physical information.
public class Venue {
	private String ID;
	private String name;
	private int tables;
	private String address;
	private Dictionary<TimeSlot, String> times;

	public Venue(String id, String n, int t, String a) {
		//constructor
		ID = id;
		name = n;
		tables = t;
		address = a;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		try {
			Database.updateVenue("venueID", iD, this.ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		try {
			Database.updateVenue("name", name, this.name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
	}
	
	public int getTables() {
		return tables;
	}
	
	public void setTables(int tables) {
		try {
			Database.updateVenue("tableNum", String.valueOf(tables), String.valueOf(this.tables));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tables = tables;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		try {
			Database.updateVenue("address", address, this.address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.address = address;
	}
	
	public String toString() {
		return this.name;
	}
	
	public Dictionary<TimeSlot, String> getTimes() {
		return times;
	}
	
	public void setTimes(Dictionary<TimeSlot, String> times) {
		this.times = times;
	}	
}
