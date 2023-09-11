import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create a menu bar for navigation between customer list and address screens
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Navigation");
            JMenuItem customerListMenuItem = new JMenuItem("Customer");
            JMenuItem addressMenuItem = new JMenuItem("Address");

            // Add action listeners to open customer and address screens
            customerListMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to open the customer screen goes here
                    CustomerListScreen customerListScreen = new CustomerListScreen();
                    customerListScreen.setVisible(true);
                }
            });

            addressMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Code to open the address screen goes here
                    AddressScreen addressScreen = new AddressScreen(null);
                    addressScreen.setVisible(true);
                }
            });

            menu.add(customerListMenuItem);
            menu.add(addressMenuItem);
            menuBar.add(menu);
            frame.setJMenuBar(menuBar);

            frame.pack();
            frame.setVisible(true);
        });
    }
}