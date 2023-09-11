import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerListScreen extends JFrame {
    private JTable customerTable;
    private JButton openAddressButton;
    private DefaultTableModel tableModel;

    public CustomerListScreen() {
        setTitle("Customer List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        // Create a table model for customer data
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Customer ID");
        tableModel.addColumn("Short Name");
        tableModel.addColumn("Full Name");

        // Populate the table with sample data (you should fetch data from the database)
        tableModel.addRow(new Object[]{"1", "Cust1", "John Doe"});
        tableModel.addRow(new Object[]{"2", "Cust2", "Jane Smith"});

        customerTable = new JTable(tableModel);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create a button to open the address screen
        openAddressButton = new JButton("Open Address");
        openAddressButton.setEnabled(false);

        // Add a list selection listener to enable the button when a customer is selected
        customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    openAddressButton.setEnabled(customerTable.getSelectedRow() != -1);
                }
            }
        });

        // Add an action listener to the openAddressButton to open the address screen
        openAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = customerTable.getSelectedRow();
                if (selectedRow != -1) {
                    String customerId = (String) tableModel.getValueAt(selectedRow, 0);
                    // Call a method to open the address screen with the selected customer's ID
                    openAddressScreen(customerId);
                }
            }
        });

        // Add components to the frame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(customerTable), BorderLayout.CENTER);
        panel.add(openAddressButton, BorderLayout.SOUTH);
        add(panel);

        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void openAddressScreen(String customerId) {
        // Create an AddressScreen instance and pass the selected customer's ID
        AddressScreen addressScreen = new AddressScreen(customerId);
        addressScreen.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomerListScreen customerListScreen = new CustomerListScreen();
            customerListScreen.setVisible(true);
        });
    }
}
