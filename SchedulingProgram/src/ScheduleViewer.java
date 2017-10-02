import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.*;

public class ScheduleViewer {
	static JLabel calendarYear, calendarMonth;
	static JFrame frame;
	static JTable calendarTable;
	static DateFormatSymbols newDate;
	static Calendar calendar;
	static private int thisWeek, thisDay;
	private static int daysInMonth;
	private static Year thisYear;
	private static Month thisMonth;
	private String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public ScheduleViewer() {
		calendar = Calendar.getInstance();
		this.getThisYear();
		this.getThisMonth();
		this.getDaysInMonth();
		this.getThisWeek();
		this.getThisDay();
	}

	/**
	 * Creates a year object to return the year object displayed in integer
	 * form. It is still an object, even though it looks like an integer.
	 * 
	 * @return
	 */
	public static Year getThisYear() {
		thisYear = Year.now();
		return thisYear;
	}

	/**
	 * Creates a Month object to return the Month Object displayed in text form.
	 * It is still an object, even though it looks like a string.
	 * 
	 * @return
	 */
	public static Month getThisMonth() {
		thisMonth = Month.of(calendar.get(Calendar.MONTH) + 1);
		return thisMonth;
	}
	
	/**
	 * Returns days in a month as an integer by retrieving the length of the current month.
	 * @return
	 */
	public static int getDaysInMonth() {
		daysInMonth = thisMonth.length(false);
		return daysInMonth;
	}

	public static int getThisWeek() {
		return thisWeek;
	}

	public static int getThisDay() {
		return thisDay;
	}

}
