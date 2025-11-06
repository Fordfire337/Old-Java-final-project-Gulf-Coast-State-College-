
import java.sql.*;

public class DemoChangeData {

	public static void main(String[] args) {		
		
		Connection conn = null;
        try {
               // registering Oracle driver class
               Class.forName("oracle.jdbc.driver.OracleDriver");

               // getting connection
         //******************* ADD YOUR USERNAME AND PASSWORD BELOW ********************
               conn = DriverManager.getConnection(
            		   "jdbc:oracle:thin:@oracle.gulfcoast.edu:1539:class",
                       "WPAYNEOM", "password"); 
               // Create a Statement object.
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatement1 = "SELECT customer_last_name, customer_first_name, Customer_city FROM customers  order by Customer_city";
               
               // Send the statement to the DBMS.
               ResultSet result1 = stmt.executeQuery(sqlStatement1);
               
               // Display a header for the listing.
               System.out.println("Customers Found in the Database");
               System.out.println("-----------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (result1.next())
               {
                  System.out.println(result1.getString("customer_last_name") + ", " + result1.getString("customer_first_name")+ " -- " + result1.getString("customer_city"));
               }//end while to output customer last and first name                             
               
               // Create a string with a SELECT statement.
               String sqlStatement2 = "Update customers set Customer_city = 'PCB' where customer_city = 'Washington'";
               
               // Send the statement to the DBMS.
               stmt.executeQuery(sqlStatement2);  //since we are not using the query to retrieve information no need to assign to a variable
               
               // Display a header for the listing.
               System.out.println("\n\n*****City Updated in the Customers Table*****");
               System.out.println("");
               
               
               // Create a string with a SELECT statement.
               String sqlStatement3 = "SELECT customer_last_name, customer_first_name, Customer_city FROM customers where Customer_city = 'PCB'";
               
               // Send the statement to the DBMS.
               ResultSet result3 = stmt.executeQuery(sqlStatement3);
               
               // Display a header for the listing.
               System.out.println("\n\nCustomers Found in the Database with city of PCB");
               System.out.println("-----------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (result3.next())
               {
                  System.out.println(result3.getString("customer_last_name") + ", " + result3.getString("customer_first_name")+ " -- " + result3.getString("customer_city"));
               }//end while to output customer last and first name
               
               // Create a string with an INSERT statement.
               String sqlStatement4 = "insert into customers values (99, 'Wendy', 'Payne', '5230 West Highway 98', 'Panama City', 'FL', '32401', '850-872-3876', null)";
               stmt.executeQuery(sqlStatement4);    //Send the statement to the DBMS         
               
               
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


