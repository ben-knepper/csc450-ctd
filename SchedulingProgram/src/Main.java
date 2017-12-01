import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Dictionary;
/** If you can read this, you're too close.
 * 
 * @author gsmbagels
 *
 */
public class Main {
	private ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
	private static ArrayList<Event> events = new ArrayList<Event>(); // actual events
	private static ArrayList<Event> setEvents = new ArrayList<Event>(); // actual events

	
	
	private ArrayList<String> requests = new ArrayList<String>();

	private static ArrayList<Employee> employees = new ArrayList<Employee>();

	private static ArrayList<Venue> venues = new ArrayList<Venue>();
	

	Random randomizer = new Random();
	
	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		Database db = new Database();
		try {
			employees = Database.getEmployees();
			employees = db.getEmployees();

			venues = db.getVenues();
			for (Venue v: venues){
				Event e = new Event(v, v.getTables());
				events.add(e);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main test = new Main();
		test.scheduleGenerator();
	}
	public void scheduleGenerator(){
		/** For all the events in a week, adds employees to each, taking priority into account.     
		If no employee is found with a higher priority, employee is tested.
		*/ 
		

		
	
		ArrayList<Employee> availableEmps = new ArrayList<Employee>();
		for (Event e: events){
			for (int table = 0; table < e.getTables(); e++){
			Employee saved = availableEmps.get(randomizer.nextInt(availableEmps.size())); //first employee
			e.addEmployee(saved);
			setEvents.add(e);
			availableEmps.remove(saved);
			}
				//Original method. I overcomplicated it. - Steven	
				/*Employee satisfied = null;
				Employee saved = employees.get(randomizer.nextInt(employees.size())); //First employee received from a higher priority.
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
				}*/
			
		} 
	}
	

	public boolean scheduleCompatible(Dictionary<TimeSlot, String> empTimes, TimeSlot[] eventTimes){
		/** Given the times of an event and an employee, tests to see if they are compatible.
		* @param empTimes Dictionary containing employee times.
		*/
		for (TimeSlot t: eventTimes){
			if(empTimes.get(t) == "n") {
				return false;
			}
		}
		return true;
	}

	
	public Employee tryEmployee(Event e, TimeSlot[] eventTimes) {
		//Tries to add an employee to an event.
		//Unused.
		Employee tempEmployee = employees.get(randomizer.nextInt(employees.size())); //gets a random employee from the database 
		Dictionary<TimeSlot, String> empTimes = tempEmployee.getTimes();
		if (scheduleCompatible(empTimes, eventTimes)){
			return tempEmployee;
		} else {
			return null;
		}
		
	}
	
	public void createRecurringEvent(Venue v, int startTime, int endTime, int employeeNum){
		/**
		 * Creates a template for an event that repeats every week.
		 */
		TimeSlot[] eventTimes = new TimeSlot[endTime - startTime];
		for (int hour = startTime; hour < endTime; hour++){
			eventTimes[hour - startTime] = new TimeSlot(hour);
		}
		Event e = new Event(v, eventTimes, employeeNum);
		events.add(e);
	}
	
	public void addEmployeeToEvent(Employee e, Event a){
		/**Adds an employee to an event, assuming the employee's schedule is compatible.
		*
		*/
		a.addEmployee(e);
	}
	
	public void swapEventEmployees(Employee e1, Employee e2, Event a1, Event a2){
		/**Swaps two employees, assuming the employees have mutually agreed to trade events.
		*
		*/
		a1.removeEmployee(e1);
		a2.removeEmployee(e2);
		a1.addEmployee(e2);
		a2.addEmployee(e1);
	}
	
	//Commands to blacklist, or increase the favor, between an employee and venue match.
	
	public void employeeBlacklistVenue(Employee e, Venue v) {
		try {
			Database.addBlacklisted(e.getId(), v.getID());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void employeeFavorVenue(Employee e, Venue v) {
		//Database.favorplusone(e, v);
	}

	public void venueBlacklistEmployee(Employee e, Venue v) {
		try {
			Database.addBlacklisted(e.getId(), v.getID());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void venueFavorEmployee(Employee e, Venue v) {
		//Database.favorplusone(e, v); 
	}
	//Calling constructors.
	public Employee newEmployee(String f, String l, String i,
			String p, String a, String ip) {
		Employee e = new Employee(i, f, l, p, a, ip);
		return e;
	}
	public Employee newManager(String f, String l, String i,
			String p, String a, String ip) {
		Employee m = new Employee(f, l, i, p, a, ip);
		m.setManager(true);
		return m;
	}
	

	public Venue newVenue(String id, String n, String a, int t) {
		Venue v = new Venue(id, n, a, t);
		return v;
		
	}
	// When an employee creates a request for an absence for a day, a change
	//in schedule, etc., a request form is sent to the manager for approval.

	public Request requestAbsence(Employee e, Event a){
		String message = ("#01 " + e.toString() + " absence request for " + a.toString());
		return new Request(e, a, 1, message);
	}
	public Request requestAbsence(Employee e, TimeSlot a){
		//returns an "absence request form" of type string
		String message = ("#02 " + e.toString() + "absence request for" + a.toString());
		return new Request(e, a, 2, message);
	}
	public Request addTimeslot(Employee e, Event a){
		//check the database to determine functionality
		String message = ("#03 " + e.toString() + "has new timeslot" + a.toString());
		return new Request(e, a, 3, message);
	}
	public Request removeTimeslot(Employee e, TimeSlot a){
		//check the database to determine functionality
		String message = ("#04 " + e.toString() + "removal request for" + a.toString());
		return new Request(e, a, 4, message);
	}
	
	public Request requestFavor1(Employee e, Venue a){
		String message = ("#05 " + e.toString() + " preference request for " + a.toString());
		return new Request(e, a, 5, message);
	}
	public Request requestFavor2(Employee e, Venue a){
		String message = ("#06 " + a.toString() + "preference request for" + e.toString());
		return new Request(e, a, 6, message);
	}
	public Request requestBlacklist1(Employee e, Venue a){
		String message = ("#07 " + e.toString() + " blacklist request against " + a.toString());
		return new Request(e, a, 7, message);
	}
	public Request requestBlacklist2(Employee e, Venue a){
		String message = ("#08 " + a.toString() + "blacklist request against" + e.toString());
		return new Request(e, a, 8, message);
	}
	
	
	
	public String dismissRequest(String request){
		return "request rejected";
	}
	//If the request is approved, extract information from the request form to make the change.
	public String approveRequest(Request r){
		if (r.getId() == 1){
			r.getA().removeEmployee(r.getE());
		}
		if (r.getId() == 2){
			r.getE().blockTimes(r.getT());
		}
		if (r.getId() == 3){
			r.getE().removeTimes(r.getT());
		}
		if (r.getId() == 4){
			r.getE().addTimes(r.getT());
		}
		if (r.getId() == 5){
			employeeFavorVenue(r.getE(), r.getV());
		}
		if (r.getId() == 6){
			venueFavorEmployee(r.getE(), r.getV());
		}
		if (r.getId() == 7){
			employeeBlacklistVenue(r.getE(), r.getV());
		}if (r.getId() == 8){
			venueBlacklistEmployee(r.getE(), r.getV());
		}
		return "request approved";
	}
}
