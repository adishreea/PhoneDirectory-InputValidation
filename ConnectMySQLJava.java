import java.sql.*;

//to establish a JDBC connection
public class ConnectMySQLJava {
	public static final String url = "jdbc:mysql://grocerapp.c92wi7qbbarw.us-west-2.rds.amazonaws.com:3306/groceryDb";
	public static final String username = "surendra";
	public static final String password = "surendra";
	public static final String driver = "com.mysql.jdbc.Driver";

	public Connection createConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Connection to the database failed");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection to the database failed");
		}
		return con;
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Test connection
	// public static void main(String[] args)
	// {
	// 		System.out.println(createConnection());
	// }
}
