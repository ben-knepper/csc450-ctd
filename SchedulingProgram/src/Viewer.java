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
public class Viewer extends JFrame {
	public Viewer() {
		// FORM TITLE
		super("Table Schedule View");
		
		Time date = new Time();
		JTable table, empInfoTable;
		TableColumn columnModel;
		// Table Data
		
		Database db = new Database();
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			empList = db.getEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(empList.size());
		Object[] colDays = {"Name","Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};
		Object[][] data = new Object[empList.size()][colDays.length]; // Initializes data array to employee length as rows and colNames length as columns
		
		// Sets data in each of the data Object's cells
		for (int i = 0; i < empList.size(); i++) {
			data[i][0] = empList.get(i); //empList.get(i).getFirstName()+ " " + empList.get(i).getLastName();

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

		getContentPane().add(pane);
		setSize(1000, 800);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Viewer bc = new Viewer();
		bc.setVisible(true);
	}
}

 /**
  *  Necessary Renderer class to override JTables distaste for JButtons being inserted normally.
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
 * 
 * @author Classical
 *
 */
class ButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private boolean clicked;
	Object [][] empInfoRows;
	Object[] empColNames = {"Name","Phone Number","Email"};
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
		
		Object [][] empInfoRows = {{employee.getFullName(),employee.getPhone(),employee.getEmail()}};
		empInfoTable = new JTable(empInfoRows, empColNames);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new JScrollPane(empInfoTable));
			}
		});

		return btn;
	}

	// IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			//Fill with JTable emp info
		}
		// SET IT TO FALSE NOW THAT ITS CLICKED
		clicked = false;
		return super.getCellEditorValue();
	}

	@Override
	public boolean stopCellEditing() {
		// SET CLICKED TO FALSE FIRST
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		// DON'T
	}
}