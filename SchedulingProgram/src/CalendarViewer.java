import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarViewer extends ScheduleViewer {
	Calendar calendar = new GregorianCalendar();
	private int thisYear;
	private int thisMonth;
	private int thisWeek;
	private int thisDay;
	private String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

}
