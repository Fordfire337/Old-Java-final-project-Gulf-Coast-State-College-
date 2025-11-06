import java.sql.*;
import java.util.ArrayList;

public class Main {

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
       		               // Test connection is null or not
               if (conn != null)
                     System.out.println("Connection established successfully!");
               else
                     System.out.println("No Connection!");
               
               
               
               // Create a Statement object.
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatement = "Select ProductName, Description From BB_Product";
               
               // Send the statement to the DBMS.
               ResultSet result = stmt.executeQuery(sqlStatement);
               
               ArrayList<String> DropDownList = new ArrayList<String>();
               int I = 0;
               while (result.next())
               {
            	   DropDownList.add(result.getNString(I));
            	   I++;
                  System.out.println(result.getString("ProductName"));
               }//end while to output customer last and first name

               for (i=1) {
            	   System.out.println(DropDownList.get(i)) 
               }

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
}//end demo class

