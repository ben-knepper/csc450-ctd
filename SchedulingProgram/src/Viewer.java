import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
		JTable table;
		TableColumn columnModel;
		// Table Data
		int[] colLength = new int[date.getDaysInMonth()+1]; //Creates an int array equal to the length of days for the current month + 1 (So the value lines up with other column names that may be added.
		ArrayList<String> colNames = new ArrayList<String>();// Test length for column titles
		String[] employees = new String[colLength.length];
		String[] dayInfo = new String[colLength.length];
		Object[][] data = new Object[employees.length][colLength.length]; // Initializes data array to employee length as rows and colNames length as columns
		
		// Sets data in each of the data Object's cells
		for (int i = 0; i < colLength.length; i++) {
			colNames.add(Integer.toString(i));
			employees[i] = ("Employee " + i);
			dayInfo[i] = ("Venue " + i);
			data[i][0] = employees[i];
			for(int j = 1; j < colLength.length; j++){
				data[i][j] = dayInfo[i];
			}

		}
		
		colNames.set(0, "Name");
		table = new JTable(data, colNames.toArray());
		
		// Table resizing
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		columnModel = table.getColumnModel().getColumn(0);
		columnModel.setPreferredWidth(120);
		for(int i = 1; i < colLength.length; i++){
			table.setRowHeight(20);
			columnModel = table.getColumnModel().getColumn(i);
			columnModel.setPreferredWidth(60);
		}
		


		// Sets a particular Column as JButtons
		table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());


		// SET CUSTOM EDITOR TO TEAMS COLUMN
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor(new JTextField()));

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
		setText((obj == null) ? "" : obj.toString());

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
	private Boolean clicked;
	JDialog infoBox = new JDialog();

	public ButtonEditor(JTextField txt) {
		super(txt);

		btn = new JButton();
		btn.setOpaque(true);

		// WHEN BUTTON IS CLICKED
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fireEditingStopped();
			}
		});
	}

	// OVERRIDE A COUPLE OF METHODS
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		clicked = true;
		return btn;
	}

	// IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			JOptionPane.showMessageDialog(null,"Fix me");
		}
		// SET IT TO FALSE NOW THAT ITS CLICKED
		clicked = false;
		return new String(lbl);
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
		super.fireEditingStopped();
	}
}