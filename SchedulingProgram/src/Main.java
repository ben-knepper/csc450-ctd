import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Random;
import java.util.Dictionary;
/** The main logic of the scheduling program.
 * Contains the automated schedule generator, local copies of information in the database,
 * Blacklisting and favor management, and request sends/management,
 * in addition to basic commands sent to other classes.
 * @author gsmbagels
 *
 */
public class Main {

	public Main(){
	}
	
	public static void main(String[] args){
		Viewer viewer = new Viewer();
		
		viewer.setVisible(true);
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public boolean scheduleCompatible(Dictionary<TimeSlot, String> empTimes, TimeSlot[] eventTimes){
//		/** Given the times of an event and an employee, tests to see if they are compatible.
//		* @param empTimes Dictionary containing employee times.
//		*/
//		for (TimeSlot t: eventTimes){
//			if(empTimes.get(t) == "n") {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	
//	public Employee tryEmployee(Event e, TimeSlot[] eventTimes) {
//		/**Tries to add an employee to an event.
//		 * 
//		 */
//		//Unused.
//		Employee tempEmployee = employees.get(randomizer.nextInt(employees.size())); //gets a random employee from the database 
//		Dictionary<TimeSlot, String> empTimes = tempEmployee.getTimes();
//		if (scheduleCompatible(empTimes, eventTimes)){
//			return tempEmployee;
//		} else {
//			return null;
//		}
//		
//	}
//	
//	public void createRecurringEvent(Venue v, int startTime, int endTime, int employeeNum){
//		/**
//		 * Creates a template for an event that repeats every week.
//		 */
//		TimeSlot[] eventTimes = new TimeSlot[endTime - startTime];
//		for (int hour = startTime; hour < endTime; hour++){
//			eventTimes[hour - startTime] = new TimeSlot(hour);
//		}
//		Event e = new Event(v, eventTimes, employeeNum);
//		events.add(e);
//	}
//	
//	public void addEmployeeToEvent(Employee e, Event a){
//		/**Adds an employee to an event, assuming the employee's schedule is compatible.
//		*
//		*/
//		a.addEmployee(e);
//	}
//	
//	public void swapEventEmployees(Employee e1, Employee e2, Event a1, Event a2){
//		/**Swaps two employees, assuming the employees have mutually agreed to trade events.
//		*
//		*/
//		a1.removeEmployee(e1);
//		a2.removeEmployee(e2);
//		a1.addEmployee(e2);
//		a2.addEmployee(e1);
//	}
//	
//	//Commands to blacklist, or increase the favor, between an employee and venue match.
//	
//	public void employeeBlacklistVenue(Employee e, Venue v) {
//		/**
//		 * Adds a blacklist mark between an employee and a venue, preventing matching.
//		 */
//		try {
//			Database.addBlacklisted(e.getId(), v.getID());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
//	
//	public void employeeFavorVenue(Employee e, Venue v) {
//		//Database.favorplusone(e, v);
//	}
//
//	public void venueBlacklistEmployee(Employee e, Venue v) {
//		/**
//		 * Adds a blacklist mark between an employee and a venue, preventing matching.
//		 */
//		try {
//			Database.addBlacklisted(e.getId(), v.getID());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
//	
//	public void venueFavorEmployee(Employee e, Venue v) {
//		//Database.favorplusone(e, v); 
//	}
//	//Calling constructors.
//	public Employee newEmployee(String f, String l, String i,
//			String p, String a, String ip) {
//		Employee e = new Employee(i, f, l, p, a, ip);
//		return e;
//	}
//	public Employee newManager(String f, String l, String i,
//			String p, String a, String ip) {
//		Employee m = new Employee(f, l, i, p, a, ip);
//		m.setManager(true);
//		return m;
//	}
//	
//
//	public Venue newVenue(String id, String n, int t, String a) {
//		Venue v = new Venue(id, n, t, a);
//		return v;
//		
//	}
//	// When an employee creates a request for an absence for a day, a change
//	//in schedule, etc., a request form is sent to the manager for approval.
//
//	public Request requestAbsence(Employee e, Event a){
//		/**
//		 * Sends a request to be absent from an event.
//		 */
//		String message = ("#01 " + e.toString() + " absence request for " + a.toString());
//		return new Request(e, a, 1, message);
//	}
//	public Request requestAbsence(Employee e, TimeSlot a){
//		/**
//		 * Sends a request to be absent from an particular time slot.
//		 * Unused.
//		 */
//		String message = ("#02 " + e.toString() + "absence request for" + a.toString());
//		return new Request(e, a, 2, message);
//	}
//	public Request addTimeslot(Employee e, Event a){
//		/**
//		 * Sends a request to add a time slot.
//		 * Unused.
//		 */
//		String message = ("#03 " + e.toString() + "has new timeslot" + a.toString());
//		return new Request(e, a, 3, message);
//	}
//	public Request removeTimeslot(Employee e, TimeSlot a){
//
//		/**
//		 * Sends a request to remove a time slot.
//		 * Unused.
//		 */
//		String message = ("#04 " + e.toString() + "removal request for" + a.toString());
//		return new Request(e, a, 4, message);
//	}
//	
//	public Request requestFavor1(Employee e, Venue a){
//
//		/**
//		 * Sends a request to increase favor between an employee and venue.
//		 */
//		String message = ("#05 " + e.toString() + " preference request for " + a.toString());
//		return new Request(e, a, 5, message);
//	}
//	public Request requestFavor2(Employee e, Venue a){
//
//		/**
//		 * Sends a request to increase favor between an employee and venue.
//		 */
//		String message = ("#06 " + a.toString() + "preference request for" + e.toString());
//		return new Request(e, a, 6, message);
//	}
//	public Request requestBlacklist1(Employee e, Venue a){
//
//		/**
//		 * Requests a blacklisting mark between and employee and a venue.
//		 */
//		String message = ("#07 " + e.toString() + " blacklist request against " + a.toString());
//		return new Request(e, a, 7, message);
//	}
//	public Request requestBlacklist2(Employee e, Venue a){
//
//		/**
//		 * Requests a blacklisting mark between and employee and a venue.
//		 */
//		String message = ("#08 " + a.toString() + "blacklist request against" + e.toString());
//		return new Request(e, a, 8, message);
//	}
//	
//	
//	
//	public String dismissRequest(String request){
//		/**
//		 * If a request is rejected, return a message saying so to the employee.
//		 */
//		
//		return "request rejected";
//	}
//	public String approveRequest(Request r){
//		/**If the request is approved, extract information from the request form to make the change.
//		*/
//		if (r.getId() == 1){
//			r.getA().removeEmployee(r.getE());
//		}
//		if (r.getId() == 2){
//			r.getE().blockTimes(r.getT());
//		}
//		if (r.getId() == 3){
//			r.getE().removeTimes(r.getT());
//		}
//		if (r.getId() == 4){
//			r.getE().addTimes(r.getT());
//		}
//		if (r.getId() == 5){
//			employeeFavorVenue(r.getE(), r.getV());
//		}
//		if (r.getId() == 6){
//			venueFavorEmployee(r.getE(), r.getV());
//		}
//		if (r.getId() == 7){
//			employeeBlacklistVenue(r.getE(), r.getV());
//		}if (r.getId() == 8){
//			venueBlacklistEmployee(r.getE(), r.getV());
//		}
//		return "request approved";
//	}
