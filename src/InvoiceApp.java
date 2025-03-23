import javax.swing.*;

public class InvoiceApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceGUI gui = new InvoiceGUI();
            gui.setVisible(true);
        });
    }
}
