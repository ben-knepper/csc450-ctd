public class Event {

	private Venue venue;
	private Employee employee; // assuming a small number (<10)
	private int tables;
	private boolean found;

	public Event(Venue v, Employee e) {
		venue = v;
		employee = e;
	}


	public int getTables() {
		return tables;
	}

	public void setTables(int tables) {
		this.tables = tables;
	}

	public Venue getVenue() {
		return venue;
	}




	public Employee getEmployee() {
		return employee;
	}


	
}
