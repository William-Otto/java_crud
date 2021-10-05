package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://b3f8b970ef59bd:98a600ae@us-cdbr-east-04.cleardb.com/heroku_50b38d9f9035a10?reconnect=true";
		String user = "b3f8b970ef59bd";
		String password = "98a600ae";
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void createTableAthlete() {
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS athletes ("
				+ "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(50) NOT NULL,"
				+ "age INT NOT NULL,"
				+ "sex VARCHAR(50) NOT NULL,"
				+ "committee VARCHAR(200) NOT NULL,"
				+ "sport VARCHAR(50) NOT NULL,"
				+ "gold INT NOT NULL,"
				+ "silver INT NOT NULL,"
				+ "bronze INT NOT NULL" 
				+ ");";
		
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error creating table athletes - " + 
					e.getLocalizedMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

