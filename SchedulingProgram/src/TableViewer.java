
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.Object;
import java.time.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TableViewer extends JFrame {
	Employee employee;
	Venue venue;
	static ScheduleViewer viewer = new ScheduleViewer();
	private JButton employeeButton, venueButton;
	private int day, size = 1;

	Object[][] data;

	public TableViewer() {
		

		String[] columns = new String[] { "Last", "First", "ID", "email", "Year" };
		for (int i = 0; i < size; i++) {
			data = new Object[][] {
					{ "Jake", "Johnson",11121, "9196102512", viewer.getThisYear()},
					{ "John", "Jackson", 11213, "9195120122", viewer.getThisMonth()} };
		}
		JTable table = new JTable(data, columns);
		this.add(new JScrollPane(table));
		this.setTitle("Table View");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		viewer = new ScheduleViewer();
		for(int i = 0; i <= viewer.getDaysInMonth(); i++){
			System.out.println(i);
		}
		System.out.println(viewer.getThisMonth().getClass().getName());
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TableViewer();
			}
		});
	}

}
