// Brew Beans Coffee
// Green Team - Emma Nguyen, Justin Williams, Morgan Davis, Moya Harper, Claudia Carroll
// 4/28/2024 (due date)

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class KityscriptedFinal extends JFrame implements ActionListener{
    
	
	public static void main(String[] args) {
		
		JLabel labelName, labelCoffeeType, labelExtras, labelTotal, labelPayment, labelOrderDetails;
	    JTextField nameField;
	    JComboBox<String> coffeeTypeComboBox;
	    JCheckBox[] extrasCheckBoxes;
	    JButton orderButton, payButton;
	    Map<String, Double> coffeePrices;
	    double totalCost = 0.0;
	    List<String> selectedExtras;

		
		JFrame GUI = new JFrame("My First GUI");

		GUI.setTitle("Coffee Shop");
		GUI.setSize(400, 400);
		GUI.setLayout(null); // We'll manage the layout manually

        // Initialize components
	/*	labelName = new JLabel("Enter Your Name:");
		labelName.setBounds(20, 20, 150, 20);
		GUI.add(labelName);

        nameField = new JTextField();
        nameField.setBounds(180, 20, 150, 20);
        GUI.add(nameField);
*/
        labelCoffeeType = new JLabel("Select Coffee Type:");
        labelCoffeeType.setBounds(20, 60, 150, 20);
        GUI.add(labelCoffeeType);
        
        
        
        
        
        
        
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
               String sqlStatement = "Select ProductName From BB_Product";
               
               // Send the statement to the DBMS.
               ResultSet result = stmt.executeQuery(sqlStatement);
               
               ArrayList<String> DropDownItems = new ArrayList<String>();
               
        int I = 0;
               while (result.next())
               { I++;
               }
               
              String[] TestDropDown = new String[I];

        coffeeTypeComboBox = new JComboBox(TestDropDown);
        coffeeTypeComboBox.setBounds(180, 60, 150, 20);
        GUI.add(coffeeTypeComboBox);

        labelExtras = new JLabel("Select Extras:");
        labelExtras.setBounds(20, 100, 150, 20);
        GUI.add(labelExtras);

        String[] extras = {"Milk", "Sugar", "Whipped Cream", "Caramel", "Chocolate Syrup"};
        extrasCheckBoxes = new JCheckBox[extras.length];
        for (int i = 0; i < extras.length; i++) {
            extrasCheckBoxes[i] = new JCheckBox(extras[i]);
            extrasCheckBoxes[i].setBounds(180, 100 + i * 20, 150, 20);
            GUI.add(extrasCheckBoxes[i]);
        }//end of for (int i = 0; i < extras.length; i++)

        labelTotal = new JLabel("Total:");
        labelTotal.setBounds(20, 200, 100, 20);
        GUI.add(labelTotal);

        labelPayment = new JLabel("");
        labelPayment.setBounds(20, 280, 300, 20);
        GUI.add(labelPayment);

        labelOrderDetails = new JLabel("");
        labelOrderDetails.setBounds(20, 240, 300, 40);
        GUI.add(labelOrderDetails);

        orderButton = new JButton("Place Order");
        orderButton.setBounds(150, 320, 120, 30);
       // orderButton.addActionListener(orderButton);
        GUI.add(orderButton);

        payButton = new JButton("Pay");
        payButton.setBounds(150, 360, 120, 30);
        //payButton.addActionListener(this);
        payButton.setEnabled(false);
        GUI.add(payButton);

       

        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
		

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
        
        
        
		// ideas
		// NOTE - may have to add more options later but this is a good start at least
		// use getData() to display checkboxes productnames from bb_product table (maybe leave out the things that aren't coffee? idk)
		// ie getData("productname", "bb_product", "Espresso");
		// use getData() display productimages from bb_product table next to the correct productname
		// ie getData("productimage", "bb_product", "Espresso");
		// use getData() display price from bb_product table for each
		// ie getData("price", "bb_product", "Espresso");
		// button to exit/place order
		// use changeData() to update stock and ordered in bb_product table
		// ie changeData("stock", "bb_product", "Espresso", "2"); (the 2 should probably be a variable where u keep track of how many of an item are sold)
	
	
	} // end brewBeansGUI
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	// method to connect to database
	public static Connection openDBConnection() { // Claudia
		Connection conn = null;
		
		// try to connect to database
		try {
            // registering Oracle driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // getting connection
            conn = DriverManager.getConnection(
         		   "jdbc:oracle:thin:@oracle.gulfcoast.edu:1539:class",
         		   "Jwill", "Java9033");
            
    		// test if connection is null or not
            // TODO take out connection notification when done (user doesn't need to be notified about connection)
            if (conn != null) {
            	System.out.println("connected");
            } else {
                System.out.println("connection failed");
            } // end if
            
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch (SQLException e) {
            e.printStackTrace();
		} // end catch
		
		return conn;
		
	} // end openDBConnection()
	
	// method to close database connection
	public static void closeDBConnection(Connection conn) { // Claudia		
		try {
        	if(conn!=null) {
          	  conn.close();
            } // end if
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } // end try/catch
		
	} // end closeDBConnection
	
	// method to return data from database as String
	public static String getData(String columnName, String tableName, String productName) { // Claudia
		String sqlData = null;
		
		try {
			// connecting to database
			Connection conn = openDBConnection();
			
			// creating Statement object
			Statement stmt = conn.createStatement();
			
			// String for SELECT statement
			String sqlStatement = "SELECT " + columnName 
					+ " FROM " + tableName 
					+ " WHERE productname = '" + productName + "'";
			
			// sending statement to DBMS
			ResultSet result = stmt.executeQuery(sqlStatement);
			
			// converting result to string and assigning it to sqlData
			// TODO test this more
			while (result.next()) {
				sqlData = result.getString(columnName);
			} // end while
			
			// closing database connection
			closeDBConnection(conn);
		} // end try
		
		catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		
		return sqlData;
	} // end getData()
	
	// method to change data in database
	public static void changeData(String columnName, String tableName, String productName, String value) { // Claudia
		// TODO test if value is digit and change accordingly
		try {
			// connecting to database
			Connection conn = openDBConnection();
			
			// creating Statement object
			Statement stmt = conn.createStatement();
			
			// String for SELECT statement
			String sqlStatement = "UPDATE " + tableName 
					+ " SET " + columnName + " = " + value
					+ " WHERE productname = '" + productName + "'";
			
			// sending statement to DBMS
			stmt.executeQuery(sqlStatement);
			
			// closing database connection
			closeDBConnection(conn);
		} // end try
		
		catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		
	} // end changeData()
	
	// method to calculate and return cost of order
	public static void calculateOrderCost() {} // end calculateOrderCost()
	
	// TODO validation methods
	
} // end GreenTeamFinalProject