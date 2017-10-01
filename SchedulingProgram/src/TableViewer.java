
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TableViewer extends JFrame {
	Employee employee;
	Venue venue;
	private JButton employeeButton, venueButton;
	private int size = 1;

	Object[][] data;

	public TableViewer() {
		String[] columns = new String[] { "Last", "First", "ID", "email" };
		for (int i = 0; i < size; i++) {
			data = new Object[][] {
					{ "Jake", "Johnson",11121, "9196102512"},
					{ "John", "Jackson", 11213, "9195120122" } };
		}
		JTable table = new JTable(data, columns);
		this.add(new JScrollPane(table));
		this.setTitle("Table View");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TableViewer();
			}
		});
	}

	/**
	 * 
	 */
}
