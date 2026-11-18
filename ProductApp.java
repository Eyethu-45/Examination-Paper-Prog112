import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    private JMenuBar menuBar;
    private JMenu fileMenu, toolsMenu;
    private JMenuItem exitItem, processItem, clearItem;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setupMenuBar();

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.35;
        formPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        txtCustomerName = new JTextField(15);
        formPanel.add(txtCustomerName, gbc);

        // Select Product
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.35;
        formPanel.add(new JLabel("Select Product:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        formPanel.add(cmbProduct, gbc);

        // Enter Price
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.35;
        formPanel.add(new JLabel("Enter Price:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        txtPrice = new JTextField(15);
        formPanel.add(txtPrice, gbc);

        // Process Button
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        btnProcess = new JButton("PROCESS");
        formPanel.add(btnProcess, gbc);

        add(formPanel, BorderLayout.CENTER);

        btnProcess.addActionListener(e -> processSale());
        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearFields());
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void setupMenuBar() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        toolsMenu = new JMenu("Tools");
        processItem = new JMenuItem("Process");
        clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = (String) cmbProduct.getSelectedItem();
        String priceText = txtPrice.getText().trim();

        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Customer Name and Price.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVAT();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            saveToDataFile(message);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToDataFile(String details) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("************************************");
            writer.println(details);
            writer.println("************************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
        txtCustomerName.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
