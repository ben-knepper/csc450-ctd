import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class Viewer {
	Database db = new Database();
	ArrayList<Employee> employees;
	
	
	JButton[] btnEmployees;
	
	private JFrame frame;
	private JPanel panel = new JPanel();

	JLabel lblName = new JLabel("Name:");
	JLabel lblLastName = new JLabel("Last Name:");

	JTextField txtFirstName = new JTextField(20);
	JTextField txtLastName = new JTextField(20);

	JLabel lblID = new JLabel("Employee ID:");
	JLabel lblPhone = new JLabel("Phone Number:");
	JLabel lblEmail = new JLabel("Email:");
	JLabel lblAddress = new JLabel("Address");
	private final JLabel lblEmployee = new JLabel("Employee 1");
	private final JLabel lblEmployee_1 = new JLabel("Employee 2");

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Viewer window = new Viewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Viewer() {
		initialize();
	}
	
	public void populateNames(){
		// Convert string to JLabel to load into frame.
		for(int i = 0; i <= employees.size(); i++){
		};
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][]", "[][]"));
		
		JLabel lblName_1 = new JLabel("Name");
		frame.getContentPane().add(lblName_1, "cell 0 0");
		for(int i = 0; i < 40; i++){
			btnEmployees [i] = new JButton("Employee " + i);
			frame.getContentPane().add(btnEmployees[i], "cell 0 " + i);
		}
		JLabel lblPhone_1 = new JLabel("Phone");
		frame.getContentPane().add(lblPhone_1, "cell 1 0");
		
		JLabel lblJanuary = new JLabel("January 1");
		frame.getContentPane().add(lblJanuary, "cell 2 0");
		
		
		JLabel label = new JLabel("9196107512");
		frame.getContentPane().add(label, "cell 1 1");
		
		JLabel lblJohnScotts = new JLabel("John Scott's");
		frame.getContentPane().add(lblJohnScotts, "cell 2 1");
		//frame.getContentPane().add(panel, "cell 0 0");

	}

}
