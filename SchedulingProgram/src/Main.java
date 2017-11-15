import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		try
		{
			ArrayList<Employee> employees = db.readEmployees();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void addEmployeeToEvent(Employee e, Event a){
		
	}
	
	public void swapEventEmployees(Employee e1, Employee e2, Event a1, Event a2){
		
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
		//returns an "absence request form" of type string
		return "absence request #";
	}
	public String requestAbsence(Employee e, TimeSlot a){
		//returns an "absence request form" of type string
		return "absence request #";
	}
	public String changeSchedule(Employee e, Event a){
		//returns an "schedule change form" of type string
		return "schedule change #";
	}
	public String changeSchedule(Employee e, TimeSlot a){
		//returns an "schedule change form" of type string
		return "schedule change #";
	}
	public String dismissRequest(String request){
		return "accept/reject";
	}
}