import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.border.MatteBorder;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import net.miginfocom.swing.MigLayout;

public class Viewer extends JFrame {
	JFrame frame;
	JPanel panel = new JPanel();
	JButton[] btnEmployees = new JButton[40];
	JLabel[] columnTitles;
	String[] daysOfTheWeek = { "Name", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	/**
	 * Initializes Viewer in a Mig Layout. Goal is to have Name and the days of
	 * the week on the top row, with employee names in the left (including their
	 * phone number), and in each cell after the employee's name, it will show
	 * where that employee works that day(most likely displayed in a short 3-4
	 * letter format for the **VENUE** with the hours.
	 * 
	 * 
	 * VENUE: Idea is to make it a JButton so when the user clicks on it, it
	 * will open a new window and display relevant information to that venue
	 * i.e. phone number, venue id, normal operating hours etc. If we do not
	 * know actual values, we can make them up.
	 */
	public Viewer() {
		/**
		 * Adjusts Viewer Window to Nimbus Theme. Looks better than default. We
		 * can change to something else later if we do not like.
		 */
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		setSize(new Dimension(600, 800));
		setLayout(new MigLayout(""));
		panel.setLayout(new MigLayout(""));

		columnTitles = new JLabel[daysOfTheWeek.length];
		// Adds initial column titles and makes it load into the first row before actual data gets populated in the layout.
		for (int i = 0; i < daysOfTheWeek.length; i++) {
			columnTitles[i] = new JLabel(daysOfTheWeek[i]);
			panel.add(columnTitles[i]);
		}
		// Skips to new row in the layout.
		panel.add(new JLabel(""), "wrap");
		// Adds employee name buttons to panel. Cannot load actual employee data from database so using test strings for now.
		for (int i = 0; i < 40; i++) {
			btnEmployees[i] = new JButton("Employee " + (i + 1));
			panel.add(btnEmployees[i], "wrap");
		}
		
		// Sets a border color around panel. I want to create a border around
		// each cell that becomes populated. Not sure how to do it yet, any
		// ideas would be cool thnx.
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		add(panel);
		setVisible(true);
	}

	/**
	 * Test main to check if it works. Has not been tested to work in other
	 * classes yet.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Viewer viewer = new Viewer();
	};

}
