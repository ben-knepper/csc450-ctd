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
		times = buildTimeSlots();
	}
	
	public Dictionary<TimeSlot, String> buildTimeSlots() {
		//creates a dictionary of time slots, each of which contains a "yes" or "no" value.
		for (int h = 0; h < 168; h++) {
			times.put(new TimeSlot(h), null);
		}
		return times;
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
	
	public Dictionary<TimeSlot, String> getTimes() {
		return times;
	}
	
	public void setTimes(Dictionary<TimeSlot, String> times) {
		this.times = times;
	}	
}
