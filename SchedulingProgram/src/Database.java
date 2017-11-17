import java.sql.*;
import java.util.ArrayList;

// based on www.vogella.com/tutorials/MySQLJava/article.html
public final class Database
{
	private final String domain = "65.184.201.211";
	private final String port = "3306";
	private final String database_name = "csc450"; //"faf9072";
	private final String sql_username = "ctd"; //"faf9072";
	private final String sql_passwd = "eG*OSrpn4NZy"; //"xyreddf15";
	
	private Connection connection;
	private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ArrayList<Employee> employees;
	
    //Employee functions
	public ArrayList<Employee> getEmployees() throws Exception
	{
		employees = new ArrayList<Employee>();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call GetTable(employee);");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				String id = resultSet.getString("employeeID");
				String firstName = resultSet.getString("fName");
				String lastName = resultSet.getString("lName");
				String password = resultSet.getString("password");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				boolean isManager = resultSet.getBoolean("isManager");
				
				Employee employee;
				if (isManager)
					employee = new Manager(id, firstName, lastName, password, phone, email);
				else
					employee = new Employee(id, firstName, lastName, password, phone, email);
				employees.add(employee);
			}
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return employees;
	}
	
	public String getEmployeeInfo(String fName, String lName, String column) throws Exception
	{
		String info = new String();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call GetEmployeeInfo(?, ?, ?);");
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			preparedStatement.setString(3, column);
			resultSet = preparedStatement.executeQuery();
			
			info = resultSet.getString(column);
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return info;
	}
	
	public void addEmployee(String eID, String fName, String lName, String password, String phone, String email, Boolean isManager) throws Exception
	{
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call AddEmployee(?, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setString(1, eID);
			preparedStatement.setString(2, fName);
			preparedStatement.setString(3, lName);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, phone);
			preparedStatement.setString(6, email);
			preparedStatement.setBoolean(7, isManager);
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
	
	public void updateEmployee(String column, String value, String ID) throws Exception
	{
		try
		{
			connect();
		
			preparedStatement = connection.prepareStatement(
					"call UpdateEmployee(?, ?, ?);");
			preparedStatement.setString(1, column);
			preparedStatement.setString(2, value);
			preparedStatement.setString(3, ID);
		
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
	
	public void updateManager(Boolean isMan, String eID) throws Exception
	{
		try
		{
			connect();
		
			preparedStatement = connection.prepareStatement(
					"call UpdateManager(?, ?);");
			preparedStatement.setBoolean(1, isMan);
			preparedStatement.setString(2, eID);
		
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
	
	public Employee searchEmployee(String fName, String lName) throws Exception
	{
		Employee employee;
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call SearchEmployee(?, ?);");
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			resultSet = preparedStatement.executeQuery();
			
			String eID = resultSet.getString("employeeID");
			String password = resultSet.getString("password");
			String phone = resultSet.getString("phone");
			String email = resultSet.getString("email");
			
			employee = new Employee(eID, fName, lName, password, phone, email);
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return employee;
	}
	
	//Venue functions
	public ArrayList<Venue> getVenues() throws Exception
	{
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call GetTable(venue);");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				String id = resultSet.getString("venueID");
				String name = resultSet.getString("name");
				int tables = resultSet.getInt("tableNum");
				String address = resultSet.getString("address");
				
				Venue venue = new Venue(id, name, tables, address);
				venues.add(venue);
			}
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return venues;
	}
	
	public String getVenueInfo(String name, String column) throws Exception
	{
		String info = new String();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call GetVenueInfo(?, ?);");
			preparedStatement.setString(1, name);
			preparedStatement.setString(3, column);
			resultSet = preparedStatement.executeQuery();
			
			info = resultSet.getString(column);
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return info;
	}
	
	public void addVenue(String vID, String name, String tables, String address) throws Exception
	{
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call AddVenue(?, ?, ?, ?)");
			preparedStatement.setString(1, vID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, tables);
			preparedStatement.setString(4, address);
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
	
	public void updateVenue(String column, String value, String ID) throws Exception
	{
		try
		{
			connect();

			preparedStatement = connection.prepareStatement(
					"call UpdateVenue(?, ?, ?);");
			preparedStatement.setString(1, column);
			preparedStatement.setString(2, value);
			preparedStatement.setString(3, ID);
		
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
		
	public Venue searchVenue(String name) throws Exception
	{
		Venue venue;
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call SearchVenue(?)");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			
			String vID = resultSet.getString("venueID");
			int tables = resultSet.getInt("tableNum");
			String address = resultSet.getString("address");
			
			venue = new Venue(vID, name, tables, address);
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return venue;
	}
	
	//Blacklisted functions
	public ArrayList<ArrayList<String>> getBlacklisted() throws Exception
	{
		ArrayList<String> blacklist = new ArrayList<String>();
		ArrayList<ArrayList<String>> blacklists = new ArrayList<ArrayList<String>>();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call GetTable(blacklisted)");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next());
			{
				String eID = resultSet.getString("employeeID");
				String vID = resultSet.getString("venueID");
				
				blacklist.add(eID);
				blacklist.add(vID);
				blacklists.add(blacklist);
				
				blacklist.clear();
			}
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return blacklists;
	}
	
	public void addBlacklisted(String eID, String vID) throws Exception
	{
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call AddBlacklisted(?, ?)");
			preparedStatement.setString(1, eID);
			preparedStatement.setString(2, vID);
			
			preparedStatement.executeUpdate();					
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
	}
	
	public ArrayList<String> searchBlacklistedEmployee(String eID) throws Exception
	{
		ArrayList<String> blacklistedEmp = new ArrayList<String>();
		try
		{
			connect();
			
			preparedStatement = connection.prepareStatement(
					"call SearchBlacklistedEmployee(?)");
			preparedStatement.setString(1, eID);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				String vID = resultSet.getString("venueID");
				
				blacklistedEmp.add(vID);
			}
		}
		catch (Exception e) { throw e; }
		finally
		{
			close();
		}
		return blacklistedEmp;
	}
	
	//Connection functions
	private void connect() throws Exception
	{
		try
		{
			// load MySql driver
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + domain + ":" + port + "/" + database_name,
					sql_username, sql_passwd);
		}
		catch (Exception e) { throw e; }
	}
	
	private void close()
	{
		try
		{
			if (resultSet != null) resultSet.close();
			if (statement!= null) statement.close();
			if (connection != null) connection.close();
		}
		catch (Exception e) { }
	}
}
