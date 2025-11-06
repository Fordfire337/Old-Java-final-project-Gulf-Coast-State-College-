
import java.sql.*;

public class DemoGetData {

	public static void main(String[] args) {		
		
		Connection conn = null;
        try {
               // registering Oracle driver class
               Class.forName("oracle.jdbc.driver.OracleDriver");

               // getting connection
         //******************* ADD YOUR USERNAME AND PASSWORD BELOW ********************
               conn = DriverManager.getConnection(
            		   "jdbc:oracle:thin:@oracle.gulfcoast.edu:1539:class",
                       "Jwill", "Java9033"); 
               // Create a Statement object.
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatement = "SELECT customer_last_name, customer_first_name FROM customers where customer_state = 'CA'";
               
               // Send the statement to the DBMS.
               ResultSet result = stmt.executeQuery(sqlStatement);
               
               // Display a header for the listing.
               System.out.println("Customers Found in the Database");
               System.out.println("-----------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (result.next())
               {
                  System.out.println(result.getString("customer_last_name") + ", " + result.getString("customer_first_name"));
               }//end while to output customer last and first name
                          
               
        } catch (ClassNotFoundException e) {
               e.printStackTrace();
        } catch (SQLException e) {
               e.printStackTrace();
        }//end catch
        finally{
               try {
                     if(conn!=null) conn.close(); // close connection
               } catch (SQLException e) {
                     e.printStackTrace();
               }//end finally to close connection
        }//end try
	}//end main
}//end DemoGetData class


