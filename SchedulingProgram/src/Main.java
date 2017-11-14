import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
	ArrayList<Event> events = new ArrayList<Event>();
	ArrayList<String> requests = new ArrayList<String>();
	

	public static void main(String[] args) {
		Database db = new Database();
		try
		{
			//ArrayList<Employee> employees = db.getEmployees();
			//System.out.println(employees);
			String info = db.getEmployeeInfo("Jennie", "Hansson", "password");
			System.out.println(info);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void scheduleGenerator(){
		//For all the events in a week, adds employees to each, taking priority into account.
		Employee satisfied = null;
		Employee saved = null; //First employee received from a higher priority.
		// If no employee is found with a higher priority, employee is tested.
		for (Event e: events) {
			TimeSlot[] eventTimes = e.getTimes();
			while (satisfied == null){
				satisfied = tryEmployee(e, eventTimes);
			}
			int priority = 0; //a numerical measure of priority
			for (int tests = 0; tests <5; tests++ ){ //test five additional employees for a higher priority
				satisfied = tryEmployee(e, eventTimes);
				if (satisfied != null) {
					int priority2 = 0;
					if (priority2 > priority){
						saved = satisfied;
					}
				}
			}
			e.addEmployee(saved);
		} 
	}
	public boolean scheduleCompatible(TimeSlot[] empTimes, TimeSlot[] eventTimes){
		//Given the times of an event and an employee, tests to see if they are compatible.
		for (TimeSlot t: eventTimes){
			boolean r = Arrays.asList(empTimes).contains(t);
			if (r == false){
				return false;
			}
		}
		return true;
	}
	public Employee tryEmployee(Event e, TimeSlot[] eventTimes){
		//Tries to add an employee to an event.
		Employee tempEmployee = null; //gets a random employee from the database
		TimeSlot[] empTimes = tempEmployee.getTimes();
		if (scheduleCompatible(empTimes, eventTimes)){
			return tempEmployee;
		} else {
			return null;
		}
		
	}
	
	public void addEmployeeToEvent(Employee e, Event a){
		a.addEmployee(e);
	}
	
	public void swapEventEmployees(Employee e1, Employee e2, Event a1, Event a2){
		a1.removeEmployee(e1);
		a2.removeEmployee(e2);
		a1.addEmployee(e2);
		a2.addEmployee(e1);
	}
	
	public void employeeBlacklistVenue(Employee e, Venue v){
		
	}
	
	public void employeeFavorVenue(Employee e, Venue v){
		
	}

	public void venueBlacklistEmployee(Employee e, Venue v){
	
	}
	public void venueFavorEmployee(Employee e, Venue v){
	
	}
	public String requestAbsence(Employee e, Event a){
		return("#01 " + e.toString() + " absence request for " + a.toString());
	}
	public String requestAbsence(Employee e, TimeSlot a){
		//returns an "absence request form" of type string
		return("#02 " + e.toString() + "absence request for" + a.toString());
	}
	public String addTimeslot(Employee e, Event a){
		//check the database to determine functionality
		return "#03 " + e.toString() + "has new timeslot" + a.toString();
	}
	public String removeTimeslot(Employee e, TimeSlot a){
		//check the database to determine functionality
		return "#03 " + e.toString() + "removal request for" + a.toString();
	}
	public String dismissRequest(String request){
		return "accept/reject";
	}
}
