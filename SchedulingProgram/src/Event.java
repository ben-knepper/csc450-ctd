public class Event {
	
	private Venue venue;
	private TimeSlot[] timeslot;
	private Employee[] employees; //assuming a small number (<10)
	private int current;
	private int tables;
	private boolean found;
	
	
	public Event(Venue v, TimeSlot[] slots, int spots) {
		venue = v;
		timeslot = slots;
		employees = new Employee[spots];
		current = 0;
		tables = spots;
	}
	
	public Event(Venue v, int spots) {
		venue = v;
		employees = new Employee[spots];
		current = 0;
		tables = spots;
	}

	public void addEmployee(Employee e) {
		employees[current] = e;
		current++;	
	}


	public void removeEmployee(Employee e) {
		//remove one employee and descend the array
		found = false;
		for (int j = 0; j < tables; j++) {
			if (found){
				employees[j-1] = employees[j];
			}else{
				if (employees[j] == e){
					found = true;
					current--;
				}
			}
		}
	}
		
	public void clearEmployees() {
		//Java collects garbage automatically, right?
		employees = new Employee[tables];
	}
	
	public int getTables() {
		return tables;
	}

	public void setTables(int tables) {
		this.tables = tables;
	}

	public String toString() {
		return("Event " + timeslot.toString() + " at " + venue);	
	}
	
	public TimeSlot[] getTimes() {
		return timeslot;
	}
}
