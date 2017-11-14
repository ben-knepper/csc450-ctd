
public class TimeSlot {
	//Each time slot contains an numerical identifier, the hour of the day
	//(in military time) times the day of the week times 24
	//(Monday is 0, Tuesday is 1, Sunday is 6.)
	private int id;
	private String day, hour;
	public TimeSlot(int h, int d){
		id = d*24+h;
	}

	public TimeSlot(int iden){
		id = iden;
	}
	public boolean isEqual(TimeSlot t){
		return true;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		return day + " " + hour;
	}
	
}
