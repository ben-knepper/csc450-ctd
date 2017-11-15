import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.border.MatteBorder;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Viewer extends JFrame {
	JFrame frame;
	JPanel panel = new JPanel();
	JButton[] btnEmployees = new JButton[40];
	JLabel[] columnTitles;
	String[] daysOfTheWeek = {"Name", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	/**
	 * Create the application.
	 */
	public Viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		setSize(new Dimension(600,800));
		setLayout(new MigLayout(""));
		panel.setLayout(new MigLayout(""));

		System.out.println(daysOfTheWeek[2]);

		columnTitles = new JLabel[daysOfTheWeek.length];
		for(int i = 0; i < daysOfTheWeek.length;i++){
			columnTitles[i] = new JLabel(daysOfTheWeek[i]);
			panel.add(columnTitles[i]);
		}
		panel.add(new JLabel(""),"wrap");
		for (int i = 0; i < 40; i++) {
			btnEmployees[i] = new JButton("Employee " + (i + 1));
			panel.add(btnEmployees[i],"wrap");
		}
		System.out.println(btnEmployees[0].getText());
		
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		Viewer viewer = new Viewer();
	};

}
