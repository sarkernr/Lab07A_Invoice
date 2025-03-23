import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGUI extends JFrame {
    private JTextArea invoiceTextArea;
    private JTextField productNameField, productPriceField, quantityField;
    private Invoice invoice;

    public InvoiceGUI() {
        invoice = new Invoice();
        initUI();
    }

    private void initUI() {
        setTitle("Invoice Generator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);

        inputPanel.add(new JLabel("Unit Price:"));
        productPriceField = new JTextField();
        inputPanel.add(productPriceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new AddItemListener());
        inputPanel.add(addButton);

        JButton generateButton = new JButton("Generate Invoice");
        generateButton.addActionListener(new GenerateInvoiceListener());
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);

        invoiceTextArea = new JTextArea();
        invoiceTextArea.setEditable(false);
        add(new JScrollPane(invoiceTextArea), BorderLayout.CENTER);
    }

    private class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = productNameField.getText();
            double price = Double.parseDouble(productPriceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(name, price);
            LineItem item = new LineItem(product, quantity);
            invoice.addLineItem(item);

            JOptionPane.showMessageDialog(null, "Item added!");
            productNameField.setText("");
            productPriceField.setText("");
            quantityField.setText("");
        }
    }

    private class GenerateInvoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            invoiceTextArea.setText(invoice.toString());
        }
    }
}
