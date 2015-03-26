package week10db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	public static void main (String[] args) throws ClassNotFoundException{
		//use the class loader to import the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//connect to a db
		String username = "bif712_143a03";
		String pw = "qhBQ5335";
		String dbURL = "jdbc:mysql://zenit.senecac.on.ca/bif712_143a03"; //include name of the database
		Connection conn = null;
		Statement stmt = null;
		String query1 = "select * from ORGANISM_GENE"; //prepare a query
		String insertQuery = "insert into ORGANISM_GENE (organism_id, organism_name, strain, gene_id, gene_name) values (5, 'test','' ,5 , 'test')";
		String deleteQuery = "delete from ORGANISM_GENE where gene_id = 5";
		System.out.println("attempting to connect to database: " + dbURL + "with usr: "+ username + " and pw: " + "pw");
		try {
			conn = DriverManager.getConnection(dbURL, username, pw);
			System.out.println("database connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//get instance of Statement to interact with the db
		try {
			stmt = conn.createStatement(); //we only need 1 statement obj, even when we have many queries
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		if (stmt != null){ //do stuff if statement isn't null
			System.out.println("we are now ready to execute some queries");
			// selecting entries
			try {
				ResultSet records = stmt.executeQuery(query1);	//execute the query to generate a result set
				while (records.next()){	//ResultSet.next() returns boolean so we can use it as a condition
					int id = records.getInt("organism_id");
					String name = records.getString("organism_name");
					int gId = records.getInt("gene_id");
					String gName = records.getString("gene_name");
					System.out.println("ID = " + id + "\torganism name = " + name + "\tgene_id = " + gId + "\tgene_name = " + gName);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//inserting entries
			System.out.println("inserting an item");
			try {
				stmt.executeUpdate(insertQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ResultSet records = stmt.executeQuery(query1);	//execute the query to generate a result set
				while (records.next()){	//ResultSet.next() returns boolean so we can use it as a condition
					int id = records.getInt("organism_id");
					String name = records.getString("organism_name");
					int gId = records.getInt("gene_id");
					String gName = records.getString("gene_name");
					System.out.println("ID = " + id + "\torganism name = " + name + "\tgene_id = " + gId + "\tgene_name = " + gName);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//delete entries ==> in this case our test row
			System.out.println("delete the test row that was added");
			try {
				stmt.executeUpdate(deleteQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ResultSet records = stmt.executeQuery(query1);	//execute the query to generate a result set
				while (records.next()){	//ResultSet.next() returns boolean so we can use it as a condition
					int id = records.getInt("organism_id");
					String name = records.getString("organism_name");
					int gId = records.getInt("gene_id");
					String gName = records.getString("gene_name");
					System.out.println("ID = " + id + "\torganism name = " + name + "\tgene_id = " + gId + "\tgene_name = " + gName);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
