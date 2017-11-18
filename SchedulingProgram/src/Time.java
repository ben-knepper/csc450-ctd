import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Time {
	YearMonth yearMonthObject;
	int daysInMonth;
	int month;
	int year;
	
	Calendar calendar;
	public Time(){
		calendar = Calendar.getInstance();

	}

	
	public int getDaysInMonth() {
		month = Calendar.getInstance().get(Calendar.MONTH)+1;
		year = Calendar.getInstance().get(Calendar.YEAR);
		yearMonthObject = YearMonth.of(year, month);
		daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}


	public void setDaysInMonth(int daysInMonth) {
		this.daysInMonth = daysInMonth;
	}


	public int getYear() {
		year = Calendar.getInstance().get(Calendar.YEAR);
		return year;
	}


	public int getMonth() {
		month = Calendar.getInstance().get(Calendar.MONTH);
		return month;
	}
	
	public static void main(String[] args){
		Time date = new Time();
	}

}