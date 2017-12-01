import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.*;

/**
 * Viewer class that implements JButton objects into a 2d Object array viewable
 * on a JTable. Objects are clickable to display information related to the
 * object in question. JButtons have their own instance so data can be
 * manipulated to display individualized data.
 * 
 *
 *	http://camposha.info/source/java-jtable-button-column/
 */
public class Viewer extends JFrame implements ActionListener{
	private static JMenuItem 	
	addEmployee, removeEmployee, updateEmployee, searchEmployee,
	addVenue, removeVenue, updateVenue, searchVenue,
	addBlacklisted, searchBlacklistedEmployee;

	public Viewer() {
		// FORM TITLE
		super("Table Schedule View");
		
		JTable table;
		TableColumn columnModel;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		JMenuBar menuBar = new JMenuBar();
		JMenu empMenu = new JMenu("Employees");
		JMenu venMenu = new JMenu("Venues");
		JMenu blackListMenu = new JMenu("Blacklist");
		JPanel panel = new JPanel();


		// Table Data
		
		// Get employee data and stores into a list.
		try {
			empList = Database.getEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(empList.size());
		// Initializes array row length to total employee size from database. Columns set to 
		Object[] colDays = {"Name","Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};
		Object[][] data = new Object[empList.size()][colDays.length];
		
		// Sets data in each of the data Object's cells
		for (int i = 0; i < empList.size(); i++) {
			data[i][0] = empList.get(i); 

		}
		
		table = new JTable(data, colDays);

		// Table resizing
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		columnModel = table.getColumnModel().getColumn(0);
		columnModel.setPreferredWidth(180);		
		
		for(int i = 1; i < colDays.length; i++){
			table.setRowHeight(20);
			columnModel = table.getColumnModel().getColumn(i);
			columnModel.setPreferredWidth(60);
		}
		


		// Sets a particular Column as JButtons
		table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());


		// SET CUSTOM EDITOR TO TEAMS COLUMN
		table.getColumnModel().getColumn(0).setCellEditor(
				new ButtonEditor(new JTextField()));

		// SCROLLPANE,SET SZE,SET CLOSE OPERATION
		JScrollPane pane = new JScrollPane(table);
		
		
		// Any and all things related to the swing components being attached to the frame
		
		// Employee Menu Items
		addEmployee = new JMenuItem("Add Employee");	
		removeEmployee = new JMenuItem("Remove Employee");
		updateEmployee = new JMenuItem("Update Employee");
		searchEmployee = new JMenuItem("Search Employee");
		
		// Venue Menu Items
		addVenue = new JMenuItem("Add Venue");
		removeVenue = new JMenuItem("Remove Venue");
		updateVenue = new JMenuItem("Update Venue");
		searchVenue = new JMenuItem("Search Venue");
		
		// Blacklist Menu Items
		addBlacklisted = new JMenuItem("Add Blacklisted Employee");
		searchBlacklistedEmployee = new JMenuItem("Search Blacklisted Employees");
		
		// Add Employee Menu Items to the Employee Menu
		empMenu.add(searchEmployee);
		empMenu.add(updateEmployee);
		empMenu.add(addEmployee);
		empMenu.add(removeEmployee);
		
		// Add Venue Menu Items to the Employee Menu
		venMenu.add(searchVenue);
		venMenu.add(updateVenue);
		venMenu.add(addVenue);
		venMenu.add(removeVenue);
		
		// Add Blacklist Menu Items to the Blacklist Menu

		blackListMenu.add(searchBlacklistedEmployee);
		blackListMenu.add(addBlacklisted);
		
		// Action Listeners for different Menu Items
		
		
		
		addEmployee.addActionListener(this);
		removeEmployee.addActionListener(this);
		updateEmployee.addActionListener(this);
		searchEmployee.addActionListener(this);
		
		addVenue.addActionListener(this);
		removeVenue.addActionListener(this);
		updateVenue.addActionListener(this);
		searchVenue.addActionListener(this);
		
		addBlacklisted.addActionListener(this);
		searchBlacklistedEmployee.addActionListener(this);
		
		// Add Menus to the Menu Bar
		menuBar.add(empMenu);
		menuBar.add(venMenu);
		menuBar.add(blackListMenu);
		
		
		// Adds the JTable with the Scroll pane to a Panel so Menus can be displayed on the Frame
		panel.setLayout(new BorderLayout());
		panel.add(pane, BorderLayout.CENTER);
		
		
		// Frame settings
		setSize(634, 920);
		setLocation(400,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Adding different Swing components to the Frame
		setJMenuBar(menuBar);
		add(panel, BorderLayout.CENTER);

	}
	/**
	 *  Overrides actionPerformed to allow easier action listeners for all menu items.
	 * @param menuItem Menu Item that is passed and retrieves a specific function 
	 * call if the Menu Item equals a some JMenuItem.
	 */
	@Override 
	public void actionPerformed(ActionEvent menuItem){
		JTextField empID, empFName, empLName;
		String inputID;
		
		// Actions for Employee Menu Items
		// Add way to parse entered data and feed into the respective database functions.
		if(menuItem.getSource().equals(searchEmployee)){
			inputID = JOptionPane.showInputDialog("Enter Employee ID: ");
			System.out.println("Search Employee");
		}
		if(menuItem.getSource().equals(addEmployee)){
			System.out.println("Add Employee");
		}
		if(menuItem.getSource().equals(removeEmployee)){
			
			System.out.println("Remove Employee");
		}
		if(menuItem.getSource().equals(updateEmployee)){
			System.out.println("Update Employee");
		}
		
		// Actions for Venue Menu Items
		if(menuItem.getSource().equals(searchVenue)){
			inputID = JOptionPane.showInputDialog("Enter Venue ID: ");
			System.out.println("Search Venue");
		}
		if(menuItem.getSource().equals(addVenue)){
			System.out.println("Add Venue");

		}
		if(menuItem.getSource().equals(removeVenue)){
			System.out.println("Remove Venue");

		}
		if(menuItem.getSource().equals(updateVenue)){
			System.out.println("Update Venue");

		}
		
		// Actions for Blacklisting Employees
		if(menuItem.getSource().equals(addBlacklisted)){
			System.out.println("Add Blacklist");

		}
		if(menuItem.getSource().equals(searchBlacklistedEmployee)){
			System.out.println("Search Blacklisted");

		}
	}
	
	
	public static void main(String[] args) {
		Viewer bc = new Viewer();
		bc.setVisible(true);
	}
}



 /**
  *  Necessary Renderer class to override JTables distaste for JButtons.
  *  
  * @author Classical
  *
  */
class ButtonRenderer extends JButton implements TableCellRenderer {
	// CONSTRUCTOR
	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {

		// SET PASSED OBJECT AS BUTTON TEXT
		Employee employee = (Employee)obj;
		setText((employee == null) ? "" : employee.getFullName());

		return this;
	}

}

/**
 * Creates a JTable filled with instanced employee information for the button clicked. Includes
 * Name, ID, Phone number, and email.
 * @author Classical
 *
 */
class ButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private boolean clicked;
	Object [][] empInfoRows;
	Object[] empColNames = {"ID", "Name","Phone Number","Email"};
	JTable empInfoTable;
	
	

	public ButtonEditor(JTextField txt) {
		super(txt);

		btn = new JButton(txt.getText());
		btn.setOpaque(true);
	}

	// OVERRIDE A COUPLE OF METHODS
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
		
		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		Employee employee = (Employee)obj;
		lbl = (employee == null) ? "" : employee.getFullName();
		btn.setText(lbl);
		clicked = true;

		// WHEN BUTTON IS CLICKED
		for (ActionListener al : btn.getActionListeners())
			btn.removeActionListener(al);
		
		Object [][] empInfoRows = {{employee.getId(),employee.getFullName(),employee.getPhone(),employee.getEmail()}};
		empInfoTable = new JTable(empInfoRows, empColNames);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new JScrollPane(empInfoTable), employee.getFullName().toString(), JOptionPane.INFORMATION_MESSAGE);
			}
		});

		return btn;
	}

	// DON'T DEAD OPEN INSIDE
	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			// DON'T
		}
		clicked = false;
		return super.getCellEditorValue();
	}

	@Override
	public boolean stopCellEditing() {
		// SET CLICKED TO FALSE FIRST
		clicked = false;
		return super.stopCellEditing();
	}
	
	// DON'T DEAD OPEN INSIDE
	@Override
	protected void fireEditingStopped() {
		// DON'T
	}
}