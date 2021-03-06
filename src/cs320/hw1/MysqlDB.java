package cs320.hw1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import cs320.hw1.models.*;

import com.mysql.jdbc.ResultSet;

public class MysqlDB {
	
	LMSConfiguration conf = new LMSConfiguration();
	public Connection dbConnection()
	{
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection( conf.url, conf.username, conf.password );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	public ResultSet selectStatement(String query, Connection connection)
	{
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = (Statement) connection.createStatement();
			rs = (ResultSet) stmt.executeQuery( query );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public void insertUpdateStatement(String query, Connection connection)
	{
		Statement stmt;
		try {
			stmt = (Statement) connection.createStatement();
			stmt.executeUpdate( query );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
