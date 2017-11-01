import java.sql.*;
import java.util.ArrayList;

// based on www.vogella.com/tutorials/MySQLJava/article.html
public final class Database
{
	private final String database_name = "faf9072";
	private final String sql_username = "faf9072";
	private final String sql_passwd = "xyreddf15";
	
	private Connection connection;
	private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
	
	public ArrayList<Employee> readEmployees() throws Exception
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try
		{
			connect();
			
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(
					"FROM employee SELECT *");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				String firstName = resultSet.getString("fName");
				String lastName = resultSet.getString("lName");
				String id = resultSet.getString("employeeID");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				boolean isManager = resultSet.getBoolean("isManager");
				
				Employee employee;
				if (isManager)
					employee = new Manager(firstName, lastName, id, phone, email);
				else
					employee = new Employee(firstName, lastName, id, phone, email);
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
	public ArrayList<Venue> readVenues() throws Exception
	{
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try
		{
			connect();
			
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(
					"FROM venue SELECT *");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				int tables = resultSet.getInt("tableNum");
				
				Venue venue = new Venue(name, address, tables);
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
	
	private void connect() throws Exception
	{
		try
		{
			// load MySql driver
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://webdev.cislabs.uncw.edu/~faf9072/" + database_name,
					sql_username, sql_passwd);
		}
		catch (Exception e) { throw e; }
		finally { close(); }
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
