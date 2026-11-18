package org.yourcompany.yourproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProductApp extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu, toolsMenu;
    JMenuItem exitItem, processItem, clearItem;

    JLabel lblCustomer, lblProduct, lblPrice;
    JTextField txtCustomer, txtPrice;
    JComboBox<String> cmbProduct;
    JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        toolsMenu = new JMenu("Tools");

        exitItem = new JMenuItem("Exit");
        processItem = new JMenuItem("Process");
        clearItem = new JMenuItem("Clear");

        exitItem.addActionListener(this);
        processItem.addActionListener(this);
        clearItem.addActionListener(this);

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomer = new JTextField();
        txtCustomer.setBounds(150, 30, 230, 25);
        add(txtCustomer);

        lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(150, 80, 230, 25);
        add(cmbProduct);

        lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 130, 230, 25);
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 180, 230, 35);
        btnProcess.addActionListener(this);
        add(btnProcess);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitItem) {
            System.exit(0);
        } else if (e.getSource() == processItem || e.getSource() == btnProcess) {
            processSalesData();
        } else if (e.getSource() == clearItem) {
            clearControls();
        }
    }

    private void processSalesData() {
        if (txtCustomer.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be completed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(txtPrice.getText());
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than zero!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String customer = txtCustomer.getText();
            String product = (String) cmbProduct.getSelectedItem();

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customer + "\n" +
                             "Product: " + product + "\n" +
                             "VAT: R " + vat + "\n" +
                             "COMMISSION: R " + commission + "\n" +
                             "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            saveReportToFile(customer, product, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for price!", "Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReportToFile(String customer, String product, double vat, double commission, double total) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));
            writer.println("DATA LOG");
            writer.println("****************************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("****************************************");
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    private void clearControls() {
        txtCustomer.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new ProductApp();
    }
}