import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddressScreen extends JFrame {
    private JLabel customerIdLabel;
    private JTextField shortNameField;
    private JTextField fullNameField;
    private JTextField address1Field;
    private JTextField address2Field;
    private JTextField address3Field;
    private JTextField cityField;
    private JTextField postalCodeField;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;

    public AddressScreen(String customerId) {
        setTitle("Address Management");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        // Create labels and text fields for customer details
        customerIdLabel = new JLabel("Customer ID: " + customerId);
        shortNameField = new JTextField(20);
        fullNameField = new JTextField(20);
        address1Field = new JTextField(20);
        address2Field = new JTextField(20);
        address3Field = new JTextField(20);
        cityField = new JTextField(20);
        postalCodeField = new JTextField(20);

        // Create buttons for address management
        addButton = new JButton("Add");
        modifyButton = new JButton("Modify");
        deleteButton = new JButton("Delete");

        // Add an action listener to the Add button for adding addresses
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate postal code before adding
                if (validatePostalCode(postalCodeField.getText())) {
                    // Add address logic here
                } else {
                    JOptionPane.showMessageDialog(AddressScreen.this, "Invalid Postal Code", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add an action listener to the Modify button for modifying addresses
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Modify address logic here
            }
        });

        // Add an action listener to the Delete button for deleting addresses
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete address logic here
            }
        });

        // Create a panel to organize components
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(customerIdLabel);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(new JLabel("Short Name:"));
        panel.add(shortNameField);
        panel.add(new JLabel("Full Name:"));
        panel.add(fullNameField);
        panel.add(new JLabel("Address 1:"));
        panel.add(address1Field);
        panel.add(new JLabel("Address 2:"));
        panel.add(address2Field);
        panel.add(new JLabel("Address 3:"));
        panel.add(address3Field);
        panel.add(new JLabel("City:"));
        panel.add(cityField);
        panel.add(new JLabel("Postal Code:"));
        panel.add(postalCodeField);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleteButton);

        add(panel);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    // Postal code validation using regular expression
    private boolean validatePostalCode(String postalCode) {
        String postalCodePattern = "^[A-Za-z]\\d[A-Za-z][-]?\\d[A-Za-z]\\d$";
        Pattern pattern = Pattern.compile(postalCodePattern);
        Matcher matcher = pattern.matcher(postalCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddressScreen addressScreen = new AddressScreen("1"); // Pass the customer ID here
            addressScreen.setVisible(true);
        });
    }
}
