import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSalesApplication extends JFrame {

    private final JTextArea salesDataArea;
    private final JLabel yearsLabel;
    private final int salesLimit = 500;

    // Sales data (for demonstration; in real applications this might come from a database or file)
    private final String[][] salesData = {
            {"Microphone", "300", "Speakers", "150", "Mixing Desk", "700"},
            {"Microphone", "250", "Speakers", "200", "Mixing Desk", "600"}
    };

    public ProductSalesApplication() {
        setTitle("Product Sales Data");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area for displaying sales data
        salesDataArea = new JTextArea();
        salesDataArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(salesDataArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons and label
        JPanel panel = new JPanel();
        JButton loadButton = new JButton("Load Data");
        JButton saveButton = new JButton("Save Data");
        yearsLabel = new JLabel("Years Processed: 2");

        loadButton.addActionListener(new LoadDataAction());
        saveButton.addActionListener(new SaveDataAction());

        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(yearsLabel);
        
        add(panel, BorderLayout.SOUTH);
    }

    private void calculateAndDisplaySalesData() {
        int totalSales = 0;
        int count = 0;
        int aboveLimit = 0;
        int belowLimit = 0;

        for (String[] yearData : salesData) {
            for (int i = 1; i < yearData.length; i += 2) {
                int sales = Integer.parseInt(yearData[i]);
                totalSales += sales;
                count++;

                if (sales > salesLimit) {
                    aboveLimit++;
                } else {
                    belowLimit++;
                }
            }
        }

        double averageSales = totalSales / (double) count;

        // Display results in the text area
        salesDataArea.setText("Total Sales: " + totalSales + "\n" +
                "Average Sales: " + averageSales + "\n" +
                "Products Above Sales Limit: " + aboveLimit + "\n" +
                "Products Below Sales Limit: " + belowLimit + "\n");
    }

    private class LoadDataAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculateAndDisplaySalesData();
        }
    }

    private class SaveDataAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
            // In real applications, here you would implement code to save data (e.g., to a file)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductSalesApplication app = new ProductSalesApplication();
            app.setVisible(true);
        });
    }
}


