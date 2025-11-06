// Brew Beans Coffee
// Green Team - Emma Nguyen, Justin Williams, Christopher Davis, Moya Harper, Claudia Carroll
// 4/28/2024 (due date)
// Any code without a name with it is to be assumed worked on by Justin and Christopher
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class greenGroupCoffeeBeanFinal extends JFrame implements ActionListener{
	static double CustomerTotal1 = 0;
	
	
	
	public static void main(String[] args) {
		
		// Justin finalized GUI using Christopher, Claudia, and Emma's code 
		// All action keys made by Justin
		
		// initliazing some of the GUI elements
		JLabel labelCoffeeType, labelTotal, LabelPrice, labelWelcome, orderTitle, cartTitle;
	    JComboBox<String> coffeeTypeComboBox;
	    JButton AddToCart, payButton, Cart, BackToOrder, ClearButton, catalogButton;
	    //double CustomerTotal1 = 0; //wlp
	    JTextField userTextField;
	    JPasswordField passwordField;
	    JLabel CusTotal = new JLabel("Total Price: $" + CustomerTotal1);// was requiring it to initalise for no apparent reason
		
	    // declaring some custom fonts
		Font labelHeadingFont = new Font("Arial", Font.PLAIN, 40);
		Font labelFont = new Font("Arial", Font.PLAIN, 25);
		Font defaultFont = new Font("Arial", Font.PLAIN, 16);
		Font lineFont = new Font("Arial", Font.PLAIN, 15);
		
		/* initilazing declaring format
		 * 
		 * creating of element 
		 * setting font
		 * setting placement
		 * adding to frame
		 * 
		 * if needed setting color
		 * 
		 * other elements as needed
		 */
		
		
// Start of GUI welcome screen page		
		
		// declaring of the frame
		JFrame welcomeScreen = new JFrame("Welcome Screen");
		welcomeScreen.setTitle("Welcome Page");
		welcomeScreen.setSize(1920, 1080);
		welcomeScreen.setLayout(null); // We'll manage the layout manually
		//welcomeScreen.getContentPane().setBackground(Color.GRAY);
		
		// page header section
		// title
		labelWelcome = new JLabel("~ Brew Bean Coffee ~");
		labelWelcome.setFont(labelHeadingFont);
		labelWelcome.setBounds(550, 50, 500, 100); // needs to be centered 
		welcomeScreen.add(labelWelcome);
		 
		// subtitle info text
		JLabel labelDescription = new JLabel("An online coffee supply retailer. Here at Brew Bean Coffee, we offer a range of "); // i want this not to be in a straight line but for future ref
		labelDescription.setFont(labelFont);
		labelDescription.setBounds(310, 100, 2000, 100); // needs to be centered 
		welcomeScreen.add(labelDescription);
		JLabel labelDescription2 = new JLabel("supplies for your coffee shop needs!"); // i want this not to be in a straight line but for future ref
		labelDescription2.setFont(labelFont);
		labelDescription2.setBounds(545, 125, 2000, 100); // needs to be centered 
		welcomeScreen.add(labelDescription2);
		 
		// some cosmetics stuff
		JLabel labelLine = new JLabel("+_________________________                    _______________                            ++++++++++++++++++++++++++++++++++++++++++++++                            _______________                    _________________________+");
		labelLine.setFont(lineFont);
		labelLine.setBounds(0, 175, 5000, 100); // needs to be centered 
		welcomeScreen.add(labelLine);
		// end page header
		
		// start button section
		// catalog button
		catalogButton = new JButton("Catalog");
		catalogButton.setFont(labelFont);
		catalogButton.setBounds(550, 275, 400, 50);
		catalogButton.setBackground(Color.white);
		welcomeScreen.add(catalogButton);
		 
		// login button
		JButton toLoginButton = new JButton("Order Now");
		toLoginButton.setFont(labelFont);
		toLoginButton.setBackground(Color.white);
		toLoginButton.setBounds(550, 375, 400, 50);
		welcomeScreen.add(toLoginButton);		
		
		// new user button
		JButton toAddUserButton = new JButton("New User");
		toAddUserButton.setFont(labelFont);
		toAddUserButton.setBackground(Color.white);
		toAddUserButton.setBounds(550, 475, 400, 50);
		welcomeScreen.add(toAddUserButton);
		
		welcomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeScreen.setVisible(true);
		//welcomeScreen.setVisible(false);
// end welcome screen
		
// Start of GUI catalog screen
		// declaring of frame
		JFrame catalogScreen = new JFrame("Catalog Screen");
 		catalogScreen.setTitle("Catalog Page");
 		catalogScreen.setSize(1920, 1080);
 		catalogScreen.setLayout(null); // We'll manage the layout manually
 		//catalogScreen.getContentPane().setBackground(Color.GRAY);
 	    
 		// page header
 		JLabel labelLogo = new JLabel("~ Brew Bean Coffee ~");
        labelLogo.setFont(labelHeadingFont);
        labelLogo.setBounds(550, 50, 500, 100); // needs to be centered 
        catalogScreen.add(labelLogo);
         
        JLabel labelLine2 = new JLabel("+_________________________                    _______________                            ++++++++++++++++++++++++++++++++++++++++++++++                            _______________                    _________________________+");
        labelLine2.setFont(lineFont);
        labelLine2.setBounds(0, 150, 5000, 100); // needs to be centered 
        catalogScreen.add(labelLine2);
         
        // info text
        JLabel labelCatalog = new JLabel("Catalog of items we offer"); // 
        labelCatalog.setFont(labelFont);
        labelCatalog.setBounds(600, 100, 1000, 100); // needs to be centered 
        catalogScreen.add(labelCatalog);
        // end page header
        
        // some button 
        // home button
        JButton homeButton = new JButton("HOME");
        homeButton.setFont(defaultFont);
        homeButton.setBounds(50, 225, 100, 50); // place it wherever
        homeButton.setBackground(Color.WHITE);
        catalogScreen.add(homeButton);
        
        // login button
        JButton toLoginFromCatButton = new JButton("LOGIN");
        toLoginFromCatButton.setFont(defaultFont);
        toLoginFromCatButton.setBounds(1345, 225, 100, 50); // place it wherever
        toLoginFromCatButton.setBackground(Color.WHITE);
        catalogScreen.add(toLoginFromCatButton);
        // end button  
        
        // descriptions go after
        // declaring needed labels 
        JLabel coffeeMachineLabel, capressoBarTitle, capressoUltTitle, eileenTitle, coffeGrinderTitle, capressoBarDesc, capressoUltDesc, eileenDesc, coffeGrinderDesc, capressoUltDesc2, coffeGrinderDesc2, 
        		coffeeTypeLabel, sumatraTitle, guatamalaTitle, columbiaTitle, brazilTitle, ethiopiaTitle, espressoTitle, sumatraDesc, guatamalaDesc, columbiaDesc, brazilDesc, brazilDesc2, ethiopiaDesc, ethiopiaDesc2, espressoDesc, espressoDesc2,
        		lineDesign, lineDesign2;
        
        // some custom fonts
        Font catalogLabel = new Font("Arial", Font.BOLD, 25);
     	Font catalogTitle = new Font("Arial", Font.PLAIN, 20);
     	Font catalogDesc = new Font("Arial", Font.ITALIC, 16);
     	
     	// machine section
     	// header title section
     	coffeeMachineLabel = new JLabel("Coffee and Brewing Machines");
     	coffeeMachineLabel.setFont(catalogLabel);
     	coffeeMachineLabel.setBounds(150, 250, 1000, 100);
     	catalogScreen.add(coffeeMachineLabel);
     	
     	lineDesign = new JLabel("_______________________________________");
     	lineDesign.setFont(catalogLabel);
     	lineDesign.setBounds(50, 265, 1000, 100);
     	catalogScreen.add(lineDesign);
     	// end header section
		
     	// product section
     	// product 1
     	capressoBarTitle = new JLabel("CapressoBar Model #351 .............................................. $99.99");
     	capressoBarTitle.setFont(catalogTitle);
     	capressoBarTitle.setBounds(55, 300, 1000, 100);
     	catalogScreen.add(capressoBarTitle);
     	capressoBarDesc = new JLabel("A fully programmable pump espresso machine and 10-cup coffee maker");
     	capressoBarDesc.setFont(catalogDesc);
     	capressoBarDesc.setBounds(55, 325, 1000, 100);
     	catalogScreen.add(capressoBarDesc);
     	capressoBarDesc = new JLabel("complete with GoldTone filter");
     	capressoBarDesc.setFont(catalogDesc);
     	capressoBarDesc.setBounds(55, 345, 1000, 100);
     	catalogScreen.add(capressoBarDesc);
     	
     	// product 2
     	capressoUltTitle = new JLabel("Capresso Ultima ........................................................... $129.99");
     	capressoUltTitle.setFont(catalogTitle);
     	capressoUltTitle.setBounds(55, 400, 1000, 100);
     	catalogScreen.add(capressoUltTitle);
     	capressoUltDesc = new JLabel("Coffee and Espresso and Cappuccino Machine. Brews from one espresso");
     	capressoUltDesc.setFont(catalogDesc);
     	capressoUltDesc.setBounds(55, 425, 1000, 100);
     	catalogScreen.add(capressoUltDesc);
     	capressoUltDesc2 = new JLabel("to two six ounce cups of coffee");
     	capressoUltDesc2.setFont(catalogDesc);
     	capressoUltDesc2.setBounds(55, 445, 1000, 100);
     	catalogScreen.add(capressoUltDesc2);
		 
     	// product 3
     	eileenTitle = new JLabel("Eileen 4-cup French Press ............................................. $32.50");
     	eileenTitle.setFont(catalogTitle);
     	eileenTitle.setBounds(55, 500, 1000, 100);
     	catalogScreen.add(eileenTitle);
     	eileenDesc = new JLabel("A unique coffeemaker from those proud craftsmen in windy Normandy.");
     	eileenDesc.setFont(catalogDesc);
     	eileenDesc.setBounds(55, 525, 1000, 100);
     	catalogScreen.add(eileenDesc);
     	
     	// product 4
     	coffeGrinderTitle = new JLabel("Coffee Grinder ................................................................. $28.50");
     	coffeGrinderTitle.setFont(catalogTitle);
     	coffeGrinderTitle.setBounds(55, 575, 1000, 100);
     	catalogScreen.add(coffeGrinderTitle);
     	coffeGrinderDesc = new JLabel("Avoid blade grinders! This mill grinder allows you to choose a");
     	coffeGrinderDesc.setFont(catalogDesc);
     	coffeGrinderDesc.setBounds(55, 600, 1000, 100);
     	catalogScreen.add(coffeGrinderDesc);
     	coffeGrinderDesc2 = new JLabel("a coarse grind.");
     	coffeGrinderDesc2.setFont(catalogDesc);
     	coffeGrinderDesc2.setBounds(55, 620, 1000, 100);
     	catalogScreen.add(coffeGrinderDesc2);
     	
     // coffe section initlazing all element stuff
     	// coffee header title
     	coffeeTypeLabel = new JLabel("Coffee Types");
     	coffeeTypeLabel.setFont(catalogLabel);
     	coffeeTypeLabel.setBounds(1100, 250, 1000, 100);
     	catalogScreen.add(coffeeTypeLabel);
     	
     	lineDesign2 = new JLabel("_______________________________________");
     	lineDesign2.setFont(catalogLabel);
     	lineDesign2.setBounds(900, 265, 1000, 100);
     	catalogScreen.add(lineDesign2);
		// end header
     	
     	// product section
     	//product 5
     	sumatraTitle = new JLabel("Sumatra ........................................................................... $10.50");
     	sumatraTitle.setFont(catalogTitle);
     	sumatraTitle.setBounds(900, 300, 1000, 100);
     	catalogScreen.add(sumatraTitle);
     	sumatraDesc = new JLabel("Spicy and intense with herbal aroma. ");
     	sumatraDesc.setFont(catalogDesc);
     	sumatraDesc.setBounds(900, 325, 1000, 100);
     	catalogScreen.add(sumatraDesc);
     	
     	// product 6
     	guatamalaTitle = new JLabel("Guatamala ....................................................................... $10.00");
     	guatamalaTitle.setFont(catalogTitle);
     	guatamalaTitle.setBounds(900, 380, 1000, 100);
     	catalogScreen.add(guatamalaTitle);
     	guatamalaDesc = new JLabel("Heavy body, spicy twist, aromatic and smokey flavor.");
     	guatamalaDesc.setFont(catalogDesc);
     	guatamalaDesc.setBounds(900, 405, 1000, 100);
     	catalogScreen.add(guatamalaDesc);
		 
     	// product 7
     	columbiaTitle = new JLabel("Columbia ......................................................................... $10.80");
     	columbiaTitle.setFont(catalogTitle);
     	columbiaTitle.setBounds(900, 460, 1000, 100);
     	catalogScreen.add(columbiaTitle);
     	columbiaDesc = new JLabel("Dry, nutty flavor and smoothness");
     	columbiaDesc.setFont(catalogDesc);
     	columbiaDesc.setBounds(900, 485, 1000, 100);
     	catalogScreen.add(columbiaDesc);
     	
     	// product	8
     	brazilTitle = new JLabel("Brazil ............................................................................... $10.80");
     	brazilTitle.setFont(catalogTitle);
     	brazilTitle.setBounds(900, 540, 1000, 100);
     	catalogScreen.add(brazilTitle);
     	brazilDesc = new JLabel("well-balanced mellow flavor, a medium body with hints of cocoa and");
     	brazilDesc.setFont(catalogDesc);
     	brazilDesc.setBounds(900, 565, 1000, 100);
     	catalogScreen.add(brazilDesc);
     	brazilDesc2 = new JLabel(" a mild, nut-like aftertaste");
     	brazilDesc2.setFont(catalogDesc);
     	brazilDesc2.setBounds(900, 585, 1000, 100);
     	catalogScreen.add(brazilDesc2);
     	
     	// product 9
     	ethiopiaTitle = new JLabel("Ethiopia ........................................................................... $10.00");
     	ethiopiaTitle.setFont(catalogTitle);
     	ethiopiaTitle.setBounds(900, 640, 1000, 100);
     	catalogScreen.add(ethiopiaTitle);
     	ethiopiaDesc = new JLabel("distinctive berry-like flavor and aroma, reminds many of a fruity,");
     	ethiopiaDesc.setFont(catalogDesc);
     	ethiopiaDesc.setBounds(900, 665, 1000, 100);
     	catalogScreen.add(ethiopiaDesc);
     	ethiopiaDesc2 = new JLabel("memorable wine. ");
     	ethiopiaDesc2.setFont(catalogDesc);
     	ethiopiaDesc2.setBounds(900, 685, 1000, 100);
     	catalogScreen.add(ethiopiaDesc2);
     	
     	// product 10
     	espressoTitle = new JLabel("Espresso ......................................................................... $10.00");
     	espressoTitle.setFont(catalogTitle);
     	espressoTitle.setBounds(900, 740, 1000, 100);
     	catalogScreen.add(espressoTitle);
     	espressoDesc = new JLabel("dense, caramel-like sweetness with a soft acidity. Roasted somewhat ");
     	espressoDesc.setFont(catalogDesc);
     	espressoDesc.setBounds(900, 765, 1000, 100);
     	catalogScreen.add(espressoDesc);
     	espressoDesc2 = new JLabel("darker than traditional Italian.");
     	espressoDesc2.setFont(catalogDesc);
     	espressoDesc2.setBounds(900, 785, 1000, 100);
     	catalogScreen.add(espressoDesc2);
     		
     	catalogScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	catalogScreen.setVisible(false);

// end catalog page	    
        
// START of GUI for Login
        
        // itialzing frame
        JFrame Login = new JFrame("Welcome");
        Login.setTitle("User Login");
        Login.setSize(1920, 1080);
        Login.setLayout(new GridBagLayout());
	    
        // grid 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Username label
        JLabel userLabel = new JLabel("Username:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        Login.add(userLabel, constraints);

        // Username text field
        userTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        Login.add(userTextField, constraints);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        Login.add(passwordLabel, constraints);

        // Password field
        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        Login.add(passwordField, constraints);

        // Login button
        JButton loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        Login.add(loginButton, constraints);
	    	    
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.setVisible(false);
// end login page
        
        
// START of GUI for Create User

        // itilaizing frame
        JFrame CreateUser = new JFrame("Create User");
        CreateUser.setTitle("Create User");
        CreateUser.setSize(1920, 1080);
        CreateUser.setLayout(new GridBagLayout());
	    
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Username label
        userLabel = new JLabel("Create Username:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        CreateUser.add(userLabel, constraints);

        // Username text field
        JTextField userTextFieldADD = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        CreateUser.add(userTextFieldADD, constraints);

        // Password label
        passwordLabel = new JLabel("New Password:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        CreateUser.add(passwordLabel, constraints);

        // Password field
        JPasswordField passwordFieldADD = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        CreateUser.add(passwordFieldADD, constraints);

        // add user button
        JButton AddUser = new JButton("Add User");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        CreateUser.add(AddUser, constraints);
	    	    
        CreateUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateUser.setVisible(false);
// end create user page        
        
//Start of GUI for Cart
         
        // itilaszing frame
        JFrame CartScreen = new JFrame("Shopping Cart");
        CartScreen.setTitle("Shopping Cart");
        CartScreen.setSize(1920, 1080);
        CartScreen.setLayout(null); // We'll manage the layout manually

        // page header
        // title
		cartTitle = new JLabel("Your Cart");
		cartTitle.setFont(labelHeadingFont);
		cartTitle.setBounds(660, 50, 500, 100);
		CartScreen.add(cartTitle);
        
        JLabel labelLine4 = new JLabel("+_________________________                    _______________                            ++++++++++++++++++++++++++++++++++++++++++++++                            _______________                    _________________________+");
        labelLine4.setFont(lineFont);
        labelLine4.setBounds(0, 125, 5000, 100); // needs to be centered 
        CartScreen.add(labelLine4);
        // end page header
        
        // button stuff
        // back button
        BackToOrder = new JButton("BACK");
        BackToOrder.setFont(defaultFont);
        BackToOrder.setBounds(50, 200, 100, 50); // place it wherever
        BackToOrder.setBackground(Color.WHITE);
        CartScreen.add(BackToOrder);
      
        // clear cart button
        ClearButton = new JButton("Clear Cart");
        ClearButton.setFont(defaultFont);
        ClearButton.setBounds(1025, 500, 120, 50);
        ClearButton.setBackground(Color.RED);
        CartScreen.add(ClearButton);
        
        // pay button
        payButton = new JButton("Pay With Card on File");
        payButton.setFont(defaultFont);
        payButton.setBounds(860, 575, 200, 50);
        CartScreen.add(payButton);
        
        // end button stuff
            
        // the item layout section
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setFont(defaultFont);
        // Create a JScrollPane around the content panel
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set bounds for the JScrollPane (adjusting as necessary)
        scrollPane.setBounds(500, 260, 500, 300);

        // Add the JScrollPane to the JFrame
        CartScreen.add(scrollPane);
        // end item display
          
        CartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CartScreen.setVisible(false);	    
// end cart screen
        
// Start of GUI for Thank you page
        // intialzing frame
        JFrame OrderThanks = new JFrame("Thank You!");
        OrderThanks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OrderThanks.setSize(1920, 1080);
        
        // Layout manager
        OrderThanks.setLayout(new BorderLayout());
        OrderThanks.getContentPane().setBackground(new Color(235, 235, 250)); // Light pastel background

        // Thank you message
        JLabel messageLabel = new JLabel("Thank You for Your Order!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(new Color(25, 25, 112)); 
        OrderThanks.add(messageLabel);
        
        
        OrderThanks.setLocationRelativeTo(null); // Center frame
        OrderThanks.setVisible(false);
// end thank yous screen        
        
//Start of GUI for order screen
        
        // itlaizng of frame
		JFrame orderScreen = new JFrame("OrderScreen");
		orderScreen.setTitle("OrderScreen");
		orderScreen.setSize(1920, 1080);
		orderScreen.setLayout(null); // We'll manage the layout manually
		
		// some custom fonts for order
		Font orderLabelFont = new Font("Arial", Font.BOLD, 25);
		Font orderTextFont = new Font("Arial", Font.BOLD, 21);
		
		// page header
		// title
		orderTitle = new JLabel("Order Selection");
		orderTitle.setFont(labelHeadingFont);
		orderTitle.setBounds(660, 50, 500, 100);
		orderScreen.add(orderTitle);
        
        JLabel labelLine3 = new JLabel("+_________________________                    _______________                            ++++++++++++++++++++++++++++++++++++++++++++++                            _______________                    _________________________+");
        labelLine3.setFont(lineFont);
        labelLine3.setBounds(0, 125, 5000, 100); // needs to be centered 
        orderScreen.add(labelLine3);
        // end page header
        
        // item selection section
        // header
		labelCoffeeType = new JLabel("Select Coffee Type:");
		labelCoffeeType.setFont(orderLabelFont);
        labelCoffeeType.setBounds(100, 250, 1000, 100);
        orderScreen.add(labelCoffeeType);
        

        // getting the products
        Connection conn = null;
        try {

               // getting connection
               conn = openDBConnection();
               
               // Create a Statement object.
               
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               
               String sqlStatement = "Select ProductName From BB_Product";
               
               // Send the statement to the DBMS.
               
               ResultSet result = stmt.executeQuery(sqlStatement);
                              
               int I = 0;
               while (result.next())
               { I++;
               }//end of while (result.next())
               
              String[] TestDropDown = new String[I];
              I = 0;
              
              ResultSet ResultList = stmt.executeQuery(sqlStatement);
              while (ResultList.next())
              { TestDropDown[I] = ResultList.getString("ProductName");
            	  
            	  I++;
              }//end of while (ResultList.next())
         
        // product selection dropdown
        coffeeTypeComboBox = new JComboBox(TestDropDown);
        coffeeTypeComboBox.setFont(orderTextFont);
        coffeeTypeComboBox.setBounds(380, 275, 400, 50);
        orderScreen.add(coffeeTypeComboBox);

        // total display
        labelTotal = new JLabel("Total: ");
        labelTotal.setFont(orderLabelFont);
        labelTotal.setBounds(600, 600, 400, 20);
        orderScreen.add(labelTotal);
        
        // total amount display
        LabelPrice = new JLabel("");
        LabelPrice.setFont(orderLabelFont);
        LabelPrice.setBounds(750, 600, 400, 20);
        orderScreen.add(LabelPrice);
        
        // item quanity
        SpinnerModel model = new SpinnerNumberModel(0, 0, 500, 1);
        JSpinner NumCounter = new JSpinner(model);
        NumCounter.setFont(orderTextFont);
        NumCounter.setBounds(850, 275, 100, 50);
        orderScreen.add(NumCounter);
        
        // add to cart button
        AddToCart = new JButton("Add To Cart");
        AddToCart.setFont(defaultFont);
        AddToCart.setBounds(650, 650, 200, 50); // place it wherever
        orderScreen.add(AddToCart);
       
        // cart button
        Cart = new JButton("View Cart");
        Cart.setFont(defaultFont);
        Cart.setBounds(1250, 225, 150, 50); // place it wherever
        Cart.setBackground(Color.WHITE);
        orderScreen.add(Cart);
        

        orderScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderScreen.setVisible(false);
// end GUI for item selctiom
        
        
        
        
// GUI for cart
        Cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("welcome");
            	orderScreen.setVisible(false);
            	//wlp changed to the to a JLabel and placed after the calculation 
            	CusTotal.setText("Total Price: $" + CustomerTotal1);//wlp
            	CusTotal.setFont(orderLabelFont); //wlp moved 
            	CusTotal.setBounds(510, 585, 400, 50);//wlp moved 
                CartScreen.add(CusTotal);//wlp moved 
            	
            	CartScreen.setVisible(true);
            }//end of public void actionPerformed(ActionEvent e)

        });//end of  Cart.addActionListener(new ActionListener() 
        

        // clear cart button
        ClearButton.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Clear?");
        		CustomerTotal1 = 0;
        		CusTotal.setText("Total Price: $" + CustomerTotal1);
        		scrollPane.removeAll();
        		scrollPane.invalidate();
        		scrollPane.validate();
        		scrollPane.repaint();
        	}//end of public void actionPerformed(ActionEvent e) 
        	
        });//end of ClearButton.addActionListener(new ActionListener()
        
        // location: start at cart -> order selection
        BackToOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("welcome");
            	
            	CartScreen.setVisible(false);
            	orderScreen.setVisible(true);
            }//end of public void actionPerformed(ActionEvent e) 

        });//end of  BackToOrder.addActionListener(new ActionListener() 
		 
        // located login screen
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("welcome");
            	           	
            	Connection conn = null;
                PreparedStatement stmt = null, stmt2 = null;
                ResultSet rs = null, rs2 = null;
                boolean loginSuccess = false;
                int idShopper = 0;
                
            	try {
                    conn = openDBConnection();
                    String sql = "SELECT * FROM BB_Shopper WHERE username = ? AND password = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, userTextField.getText());
                    stmt.setString(2, String.valueOf(passwordField.getPassword()));

                    rs = stmt.executeQuery();
                            	
                    if (rs.next()) {
                        loginSuccess = true;  //  login true if a row is found
                     
                    sql = "SELECT IDSHOPPER FROM BB_Shopper WHERE username = ? AND password = ?";
                    stmt2 = conn.prepareStatement(sql);
                    stmt2.setString(1, userTextField.getText());
                    stmt2.setString(2, String.valueOf(passwordField.getPassword()));
                    
                    rs2 = stmt.executeQuery();
                        if (rs2.next()) {
                            // Retrievin the IDSHOPPER value from the ResultSet
                            idShopper = rs2.getInt("IDSHOPPER");
                            System.out.println("IDSHOPPER: " + idShopper);
                     
                        }//end of if (rs2.next())  
                     // Get the current date in java.util.Date format
                        
                   java.util.Date today = new java.util.Date();
                        // Convert it to java.sql.Date format
                   
                   java.sql.Date sqlDate = new java.sql.Date(today.getTime());
                   System.out.println(sqlDate);
                   sql = "INSERT INTO BB_AUDIT_LOGON VALUES (?, ?)";
                   stmt2 = conn.prepareStatement(sql);
                   stmt2.setInt(1, idShopper);
                   stmt2.setDate(2, sqlDate);
                        
                   int rowsAffected = stmt2.executeUpdate();
                   System.out.println(rowsAffected + " rows inserted.");

                    }//end of if (rs.next()) 
                    
                } catch (SQLException ex) {
                 
                    ex.printStackTrace();  // Print the exception details
                } finally {

                    	closeResultSetConnection(rs);
                        closeDBConnection(conn);
                        closeStatementConnection(stmt);

                }//end of finally
             
                if (loginSuccess) {
                    Login.setVisible(false);
                    orderScreen.setVisible(true);
                }	else {
                	JOptionPane.showMessageDialog(null, "Incorrect Login Information Please Try Again.");
                }// end of else 

            }//end public void actionPerformed(ActionEvent e)
        });// end loginButton.addActionListener(new ActionListener() 
        
        // located cart screen
        // adding products to the cart
        AddToCart.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// initialzing 
        		String ItemName = coffeeTypeComboBox.getSelectedItem().toString();
        		int ItemQuanity = (int) NumCounter.getValue();
        		int quanity = Integer.parseInt(getData1("Stock", "BB_Product", ItemName));
        		
        		// validating quanity
        		if (ItemQuanity == 0) { // cant add nothing
        			JOptionPane.showMessageDialog(null, "Cant select 0");
        		} else if (ItemQuanity > quanity) { // if they add over stock limit
        			JOptionPane.showMessageDialog(null, "There is only "+ quanity +" items, sorry for the inconvenience");
        		}//end of else if (ItemQuanity > quanity)
        		
        		//calc cost
        		
        		Double Price = Double.parseDouble(getData1("Price", "BB_Product", ItemName));       		
        		Double Tprice = ItemQuanity * Price; // math to find the total price of certain item	
        		LabelPrice.setText("$" + Tprice); // formatting    		
                JLabel label = new JLabel(ItemName + "  Quanity: "+ ItemQuanity + "  Price EA: $" + Price);  // Create a JLabel with the text
                label.setFont(defaultFont);
                contentPanel.add(label);  // Add the label to the JPanel
                CustomerTotal1 = CustomerTotal1 + Tprice;  //wlp changed to static double
               
                CartScreen.setVisible(false);
                orderScreen.setVisible(true);
        	}//end public void actionPerformed(ActionEvent e) 
        	
        });//end  AddToCart.addActionListener(new ActionListener()
        
        } catch (SQLException e) {
               e.printStackTrace();
        }//end catch
        finally{
        	closeDBConnection(conn);  
        }//end of finally
        
 // actionListeners that only job is to "move screens"       
        
        // start at welcome -> catalog screen
        // location welcome page
        catalogButton.addActionListener(new ActionListener() { 
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		welcomeScreen.setVisible(false);
        		catalogScreen.setVisible(true);
        	} // end actionEvent
        }); // end catalogButton.addActionListener
        
        // start at welcome -> login screen
        // located welcome page
        toLoginButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		welcomeScreen.setVisible(false);
        		Login.setVisible(true);
        	} // end actionEvent
        });// end toLoginButton.addActionListener
        
        // start at welcome -> create user screen
        // located welcome page
        toAddUserButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		welcomeScreen.setVisible(false);
        		CreateUser.setVisible(true);
        	} // end actionEvent
        }); // end toAddUserButton.addActionListener
        
        // start at catalog -> login screen
        // located catalog page. get here from welcome page
        toLoginFromCatButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		catalogScreen.setVisible(false);
        		Login.setVisible(true);
        	} // end actionEvent
        }); // end toLoginFromCatButton.addActionListener

        // start at catalog -> welcome screen
        // "back button"
        homeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		catalogScreen.setVisible(false);
        		welcomeScreen.setVisible(true);
        	} // end actionEvent
        }); // end homeButton.addActionListener
        
     // location: cart screen -> thank you screen
        payButton.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent e) {
        		OrderThanks.setVisible(true);
        		CartScreen.setVisible(false);
        		System.out.println("Payed");
        	}//end of public void actionPerformed(ActionEvent e)
        	
        });//end of payButton.addActionListener(new ActionListener()
        
// END actionListeners that only job is to "move screens"
        
        // start create user -> login screen
        // creating a new user
        AddUser.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		// username password validation
        		if (userTextFieldADD.getText() != null && userTextFieldADD.getText().length() <= 7 && passwordFieldADD.getPassword() != null && String.valueOf(passwordFieldADD.getPassword()).length() <= 7) {
        			if(SQLShopper(userTextFieldADD.getText(), String.valueOf(passwordFieldADD.getPassword()))) {
        				JOptionPane.showMessageDialog(null, "UserName Already Exists");
        			}else { // moves screens
        				CreateUser.setVisible(false);
            			Login.setVisible(true);
        			} // end nested if else
        		} else { // validation for not meeting correct character limti
        			JOptionPane.showMessageDialog(null, "UserName and Password must be less then 8 Characters long");
        		} // end first if else 
        		
        	} // end actionEvent
        }); // end AddUser.addActionListener
        

        
	}// end of public static void main(String[] args)
// end main / of GUI stuff		

	
	// method to insert shopper info into bb_shopper table in SQL
		public static Boolean SQLShopper(String username, String password) { // Claudia
			String SQLdata = null;
			String sqlStatement = null;
			Boolean Exist = false;
			try {
				// connecting to database
				Connection conn = openDBConnection();
				
				// creating Statement object
				Statement stmt = conn.createStatement();
				
				// statement to check if username and password are already in system
				sqlStatement = "SELECT * FROM bb_shopper WHERE username = ?";
				PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
				pstmt.setString(1, username);
				ResultSet result = pstmt.executeQuery();
				
				
				// converting result to string and assigning it to SQLdata
				while (result.next()) {
					SQLdata = result.getString("username");
					System.out.println(SQLdata);
				} // end while
				
				
				//need to return to tell user if username exist
				if (SQLdata != null) {
					Exist = true;
				} else {
					Exist = false;
				}
				
				// if username and password aren't already in bb_shopper, inserting new shopper into bb_shopper
				if (SQLdata == null || SQLdata.isEmpty()) {
					// String for SELECT statement
					sqlStatement = "INSERT INTO bb_shopper (idshopper, username, password) VALUES (bb_shopper_seq.nextval, ?, ?)";
					PreparedStatement insertStmt = conn.prepareStatement(sqlStatement);
					insertStmt.setString(1, username);
					insertStmt.setString(2, password);
					insertStmt.executeUpdate();
					
					
				} // end if
				
				// closing database connection
				closeDBConnection(conn);
			} // end try
			
			catch (SQLException e) {
				e.printStackTrace();
			} // end catch
			return Exist;
			
		} // end SQLShopper()
	
	
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

            if (conn != null) {
            	System.out.println("connected");
            } else {
                System.out.println("connection failed");
            }//end of if
            
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch (SQLException e) {
            e.printStackTrace();
		}//end of catch
		
		return conn;
		
	}//end of openDBConnection()
	
	// method to close database connection
	
	public static void closeDBConnection(Connection conn) { // Claudia		
		try {
        	if(conn!=null) {
          	  conn.close();
            } //end of if
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } //end of try/catch
		
	} //end of closeDBConnection
	
	public static void closeStatementConnection(PreparedStatement conn) { // Claudia		
		try {
        	if(conn!=null) {
          	  conn.close();
            } //end of if
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } //end of try/catch
		
	} //end of closeDBConnection
	
	public static void closeResultSetConnection(ResultSet conn) { // Claudia		
		try {
        	if(conn!=null) {
          	  conn.close();
            } //end of if
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } //end of try/catch
		
	} //end of closeDBConnection
	
	// method to calculate and return cost of order

	public static String getData1(String columnName, String tableName, String productName) { // Claudia
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
			
			while (result.next()) {
				sqlData = result.getString(columnName);
			}//end of while
			
			// closing database connection
			
			closeDBConnection(conn);
		}//end of try	
		catch (SQLException e) {
			e.printStackTrace();
		}//end of catch		
		return sqlData;
	}//end of public static String getData1(String columnName, String tableName, String productName) 


	@Override
	public void actionPerformed(ActionEvent e) {
		// This was being required by class 
		
	}
}//end of public class KityscriptedFinal extends JFrame implements ActionListener