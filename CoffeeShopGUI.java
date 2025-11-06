// Project Final
// Christopher Davis and Others
// 04/26/2024

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CoffeeShopGUI extends JFrame implements ActionListener {
    private JLabel labelName, labelCoffeeType, labelExtras, labelTotal, labelPayment, labelOrderDetails;
    private JTextField nameField;
    private JComboBox<String> coffeeTypeComboBox;
    private JCheckBox[] extrasCheckBoxes;
    private JButton orderButton, payButton;
    private Map<String, Double> coffeePrices;
    private double totalCost = 0.0;
    private List<String> selectedExtras;

    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@oracle.gulfcoast.edu:1539:class";
    private static final String USER = "Cdavi";
    private static final String PASSWORD = "Java9979";

    // GUI Maker Code something idk it's 2 am
    public CoffeeShopGUI() {
        setTitle("Coffee Shop");
        setSize(400, 400);
        setLayout(null); // We'll manage the layout manually

        // Initialize components
        labelName = new JLabel("Enter Your Name:");
        labelName.setBounds(20, 20, 150, 20);
        add(labelName);

        nameField = new JTextField();
        nameField.setBounds(180, 20, 150, 20);
        add(nameField);

        labelCoffeeType = new JLabel("Select Coffee Type:");
        labelCoffeeType.setBounds(20, 60, 150, 20);
        add(labelCoffeeType);

        coffeeTypeComboBox = new JComboBox<>();
        coffeeTypeComboBox.setBounds(180, 60, 150, 20);
        add(coffeeTypeComboBox);

        labelExtras = new JLabel("Select Extras:");
        labelExtras.setBounds(20, 100, 150, 20);
        add(labelExtras);

        String[] extras = {"Milk", "Sugar", "Whipped Cream", "Caramel", "Chocolate Syrup"};
        extrasCheckBoxes = new JCheckBox[extras.length];
        for (int i = 0; i < extras.length; i++) {
            extrasCheckBoxes[i] = new JCheckBox(extras[i]);
            extrasCheckBoxes[i].setBounds(180, 100 + i * 20, 150, 20);
            add(extrasCheckBoxes[i]);
        }//end of for (int i = 0; i < extras.length; i++)

        labelTotal = new JLabel("Total:");
        labelTotal.setBounds(20, 200, 100, 20);
        add(labelTotal);

        labelPayment = new JLabel("");
        labelPayment.setBounds(20, 280, 300, 20);
        add(labelPayment);

        labelOrderDetails = new JLabel("");
        labelOrderDetails.setBounds(20, 240, 300, 40);
        add(labelOrderDetails);

        orderButton = new JButton("Place Order");
        orderButton.setBounds(150, 320, 120, 30);
        orderButton.addActionListener(this);
        add(orderButton);

        payButton = new JButton("Pay");
        payButton.setBounds(150, 360, 120, 30);
        payButton.addActionListener(this);
        payButton.setEnabled(false);
        add(payButton);

        // Fetch coffee types and prices from the database
        fetchCoffeeTypes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end of public CoffeeShopGUI()

    // Method to fetch coffee types, prices, and quantities from the database
    private void fetchCoffeeTypes() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT name, price FROM coffees";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            coffeePrices = new HashMap<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                coffeePrices.put(name, price);
                coffeeTypeComboBox.addItem(name);
            }//end of while (resultSet.next())
        } catch (SQLException e) {
            e.printStackTrace();
        }//end of catch (SQLException e)
    }// end of private void fetchCoffeeTypes()

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            String userName;
            do {
                userName = JOptionPane.showInputDialog(this, "Enter Your Name:");
                if (userName == null) return; // If the user cancels, exit
            } while (!isValidName(userName));

            nameField.setText(userName);

            String selectedCoffee = (String) coffeeTypeComboBox.getSelectedItem();
            double coffeePrice = coffeePrices.get(selectedCoffee);

            totalCost = coffeePrice;

            // Display coffee type in order details
            StringBuilder orderDetails = new StringBuilder("Order Details:\n");
            orderDetails.append("Coffee Type: ").append(selectedCoffee).append("\n");

            // Add extras and update total cost
            selectedExtras = new ArrayList<>();
            for (JCheckBox checkBox : extrasCheckBoxes) {
                if (checkBox.isSelected()) {
                    String extra = checkBox.getText();
                    selectedExtras.add(extra);
                    totalCost += 0.5; // Assume each extra costs $0.50
                    orderDetails.append("Extra: ").append(extra).append("\n");
                }// end of if (checkBox.isSelected())
            }// end of for (JCheckBox checkBox : extrasCheckBoxes)

            // Display total
            labelTotal.setText("Total: $" + String.format("%.2f", totalCost));
            labelOrderDetails.setText(orderDetails.toString());
            payButton.setEnabled(true);
        } else if (e.getSource() == payButton) {
            String paymentMethod;
            do {
                paymentMethod = JOptionPane.showInputDialog(this, "Total to pay: $" + String.format("%.2f", totalCost) +
                        "\nChoose payment method (cash or credit card):");
                if (paymentMethod == null) return; // If the user cancels payment, exit
            } while (!isValidPaymentMethod(paymentMethod));

            labelPayment.setText("Payment method: " + paymentMethod);
            payButton.setEnabled(false); // Disable pay button after payment
        }//end of else if (e.getSource() == payButton)
    }// end of public void actionPerformed(ActionEvent e)

    // Method to check if payment method is valid (cash or credit card)
    private boolean isValidPaymentMethod(String paymentMethod) {
        return paymentMethod != null && (paymentMethod.equalsIgnoreCase("cash") || paymentMethod.equalsIgnoreCase("credit card"));
    }// end of private boolean isValidPaymentMethod(String paymentMethod)

    // Method to validate user name (no numbers)
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }// end of  private boolean isValidName(String name)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CoffeeShopGUI());
    }//end of  public static void main(String[] args)
}// end of public class CoffeeShopGUI extends JFrame implements ActionListener
