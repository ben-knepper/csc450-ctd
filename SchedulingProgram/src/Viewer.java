import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.alee.laf.WebLookAndFeel;
import com.seaglasslookandfeel.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

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
	saveFile,
	addBlacklisted, searchBlacklistedEmployee;
	static JTable table;

	
	public Viewer() {
		// FORM TITLE
		super("Table Schedule View");
		
		TableColumn columnModel;
		JMenuBar menuBar = new JMenuBar();
		JMenu empMenu = new JMenu("Employees");
		JMenu venMenu = new JMenu("Venues");
		JMenu fileMenu = new JMenu("File");
		JMenu blackListMenu = new JMenu("Blacklist");
		JPanel panel = new JPanel();
		
		ArrayList<Employee> empList = new ArrayList<Employee>();

		// Get employee data and stores into a list. Sets look and feel to Nimbus. This can be changed if we don't like it.
		try {
			empList = Database.getEmployees();
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		    	System.out.println(info.getClassName());
//		        if ("metal".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		// Table Data
		

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
		
		//File Menu Items
		saveFile = new JMenuItem("Export to Excel");
		
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
		
		// Add File Menu Items to the File Menu
		fileMenu.add(saveFile);
		
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
		
		
		
		saveFile.addActionListener(this);
		
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
		menuBar.add(fileMenu);
		menuBar.add(empMenu);
		menuBar.add(venMenu);
		menuBar.add(blackListMenu);
		
		
		// Adds the JTable with the Scroll pane to a Panel so Menus can be displayed on the Frame
		panel.setLayout(new BorderLayout());
		panel.add(pane, BorderLayout.CENTER);
		
		
		// Frame settings
		setSize(634, 920);
		setLocation(800,300);
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
		String 	inputID;
		Venue venue = null;
		Employee employee = null;
		boolean inputMan = false;
		Object[] empColNames = {"ID", "Name","Phone Number","Email"};
		Object[] venColNames = {"ID", "Name", "Table amount","Address"};
		JTable empInfoTable, venInfoTable;
		JDialog empInfoBox, venInfoBox;
		
		



		// Actions for File Menu Items

//		if(menuItem.getSource().equals(saveFile)){
//			saveLocation = new String("");
//			SaveSchedule(table,);
//		}
//		if(menuItem.getSource().equals(saveFile)){
//			saveLocation = new String("")
//			SaveSchedule(table,);
//		}

		// Actions for Employee Menu Items
		if(menuItem.getSource().equals(searchEmployee)){
			empInfoBox = new JDialog();
			inputID = JOptionPane.showInputDialog("Enter a Employee ID: ");
			
			try {
				employee = Database.searchEmployeeID(inputID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object[][] empInfoRows = {{employee.getId(),employee.getFullName(),employee.getPhone(),employee.getEmail()}};
			empInfoTable = new JTable(empInfoRows, empColNames);
			empInfoBox.setTitle(employee.getFullName());
			empInfoBox.add(new JScrollPane(empInfoTable));
			empInfoBox.pack();
			empInfoBox.setLocation(1450, 500);
			empInfoBox.setVisible(true);
			System.out.println("Employee " + employee.getFullName() + " found!");
		}
		
		
		if(menuItem.getSource().equals(addEmployee)){
			//TODO ADD MULTI TEXT FIELD BOX TO ADD EMPLOYEE
			System.out.println("Added Employee ");
		}
		
		
		if(menuItem.getSource().equals(removeEmployee)){
			inputID = JOptionPane.showInputDialog("Enter the Employee ID for the employee you wish to remove: ");
			try {
				employee = Database.searchEmployeeID(inputID);
				Database.removeEmployee(inputID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Employee " + employee.getFullName() + " has been removed.");
		}
		
		
		if(menuItem.getSource().equals(updateEmployee)){
			System.out.println("Update Employee");
		}
		
		
		// Actions for Venue Menu Items
		if(menuItem.getSource().equals(searchVenue)){
			venInfoBox = new JDialog();
			inputID= JOptionPane.showInputDialog("Enter a Venue ID Name: ");
			
			try {
				venue = Database.searchVenueID(inputID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Object[][] venInfoRows = {{venue.getID(),venue.getName(),venue.getTables(),venue.getAddress()}};
			
			venInfoTable = new JTable(venInfoRows, venColNames);
			
			venInfoBox.setTitle(venue.getName());
			venInfoBox.add(new JScrollPane(venInfoTable));
			venInfoBox.pack();
			venInfoBox.setLocation(1450, 500);
			venInfoBox.setVisible(true);
			System.out.println("Venue " + venue.getName()+ " found!");
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
	public void createEmployeeInfoBox(){
//		final String [] addEmpInfoTexts = {"User ID: ", "First Name: ","Last Name: ", "Phone Number: ","Email: "};
//		final int COLS = 8;
//		JPanel empInputPanel = new JPanel();
//		for (int i = 0; i < addEmpInfoTexts.length; i++) {
//			String labelText = addEmpInfoTexts[i];
//			empInputPanel.add(new JLabel(labelText));
//			
//			JTextField textField = new JTextField(COLS);
//			empInputPanel.add(textField);
//		}
//		empInputPanel.setBorder(BorderFactory.createTitledBorder("Enter Employee Information"));
//		empInputPanel.setSize(400, 400);
//		empInputPanel.setVisible(true);
		
		JPanel empInputPanel = new JPanel();
		String[] empInfo = {"User ID: ", "First Name: ","Last Name: ", "Phone Number: ","Email: "};
		JLabel[] empLabels = new JLabel[5];
		for(int i = 0; i<empLabels.length;i++){
			empLabels[i] = new JLabel(empInfo[i],SwingConstants.RIGHT);
			empInputPanel.add(empLabels[i], BorderLayout.WEST);

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
	JDialog empInfoBox;


	
	

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
				empInfoBox = new JDialog();
				JScrollPane scrollPane = new JScrollPane(empInfoTable);
				scrollPane.setSize(400, 400);
				empInfoBox.add(scrollPane);
				empInfoBox.setTitle(employee.getFullName());
				empInfoBox.pack();
				empInfoBox.setVisible(true);
				//JOptionPane.showMessageDialog(null, new JScrollPane(empInfoTable), employee.getFullName().toString(), JOptionPane.INFORMATION_MESSAGE);
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