package testsuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class ExecuteDB {
	String url = "jdbc:postgresql://localhost:5432/demo";
    String user = "postgres";
    String password = "admin*";
    
    Connection con=null;
    Statement stmt = null;
    
	@Test
	public void test() throws SQLException {
		
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/demo",
	            "postgres", "admin");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      
	      
	      stmt = c.createStatement();
	         String sql = "SELECT * from employee;";        
	         
	         ResultSet rs = stmt.executeQuery(sql);
	           
	           while ( rs.next() ) {
	              int id = rs.getInt("user_id");
	              String  name = rs.getString("username");
	              String pwd  = rs.getString("password");
	              String  email = rs.getString("email");
	              
	              System.out.println( "USER ID = " + id );
	              System.out.println( "USER NAME = " + name );
	              System.out.println( "USER PASSWORD = " + pwd );
	              System.out.println( "USER EMAILID = " + email );	              
	              System.out.println();
	           }
	           
	           //Close Result set
	           rs.close();
	           
	           //Close Statement
	           stmt.close();
	           
	           //Close Connection
	           c.close();
	}
		
	}
