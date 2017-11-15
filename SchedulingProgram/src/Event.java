

public class Event {
	
	private Venue venue;
	private TimeSlot[] timeslot;
	private Employee[] employees; //assuming a small number (<10)
	private int current;
	private int employeeMax;
	private boolean found;
	
	
public Event(Venue v, TimeSlot[] slots, int spots){
	venue = v;
	timeslot = slots;
	employees = new Employee[spots];
	current = 0;
	employeeMax = spots;
	
}
public void addEmployee(Employee e) {
	employees[current] = e;
	current++;
	
}


public void removeEmployee(Employee e){
	//remove one employee and descend the array
	found = false;
	for (int j = 0; j < employeeMax; j++){
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
		


public void clearEmployees(){
	//Java collects garbage automatically, right?
	employees = new Employee[employeeMax];
}

public String toString(){
	return("Event " + timeslot.toString() + " at " + venue);
	
}
public TimeSlot[] getTimes(){
	return timeslot;
}
}


