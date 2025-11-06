import java.sql.*;

public class Demo {

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

