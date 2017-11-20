
public class Request {
	private Employee e;
	private Venue v;
	private Event a;
	private TimeSlot t;
	private int id;
	private String message;
	
	public Request(Employee emp, Venue ven, int i, String s){
		e = emp;
		a = null;
		v = ven;
		id = i;
		t = null;
		message = s;
	}
	public Request(Employee emp, Event ven, int i, String s){
		e = emp;
		a = ven;
		v = null;
		id = i;
		t = null;
		message = s;
	}
	public Request(Employee emp, TimeSlot time, int i, String s){
		e = emp;
		a = null;
		v = null;
		id = i;
		t = time;
		message = s;
	}
	public Event getA() {
		return a;
	}
	public void setA(Event a) {
		this.a = a;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	public Employee getE() {
		return e;
	}
	public void setE(Employee e) {
		this.e = e;
	}
	public Venue getV() {
		return v;
	}
	public void setV(Venue v) {
		this.v = v;
	}
	public TimeSlot getT() {
		return t;
	}
	public void setT(TimeSlot t) {
		this.t = t;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
