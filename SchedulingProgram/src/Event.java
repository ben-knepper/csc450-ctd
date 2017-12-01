public class Event {

	private Venue venue;
	private TimeSlot[] timeslot;
	private Employee[] employees; // assuming a small number (<10)
	private int current;

	private int tableSize;
	private int tables;
	private boolean found;

	public Event(Venue v, TimeSlot[] slots, int tables) {
		venue = v;
		timeslot = slots;
		employees = new Employee[tableSize];
		current = 0;
		tableSize = tables;
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
		for (int j = 0; j < tableSize; j++) {
			for (int j1 = 0; j1 < tables; j1++) {
				if (found){
					employees[j1-1] = employees[j1];
				}else{
					if (employees[j1] == e){
						found = true;
						current--;
					}
				}
			}
		}
	}

	public void clearEmployees() {
		// Java collects garbage automatically, right?
		employees = new Employee[tableSize];

		employees = new Employee[tables];

	}

	public int getTables() {
		return tables;
	}

	public void setTables(int tables) {
		this.tables = tables;
	}

	public String toString() {
		return ("Event " + timeslot.toString() + " at " + venue);
	}

	public TimeSlot[] getTimes() {
		return timeslot;
	}
}
