import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesApp extends JFrame {

    private final JTextArea salesDataArea;
    private final JLabel yearsLabel;
    private final int salesLimit = 500;

    // Sample sales data (for demonstration; in real applications this might come from a database or file)
    private final String[][] salesData = {
            {"Microphone", "300", "Speakers", "150", "Mixing Desk", "700"},
            {"Microphone", "250", "Speakers", "200", "Mixing Desk", "600"}
    };

    public ProductSalesApp() {
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
        yearsLabel = new JLabel("Years Processed: 2");
        panel.add(yearsLabel);
        
        add(panel, BorderLayout.SOUTH);
        
        // Create menu
        createMenuBar();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadDataItem = new JMenuItem("Load Product Data");
        loadDataItem.addActionListener(new LoadDataAction());
        toolsMenu.add(loadDataItem);

        JMenuItem saveDataItem = new JMenuItem("Save Product Data");
        saveDataItem.addActionListener(new SaveDataAction());
        toolsMenu.add(saveDataItem);

        JMenuItem clearDataItem = new JMenuItem("Clear");
        clearDataItem.addActionListener(e -> clearData());
        toolsMenu.add(clearDataItem);

        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
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
        yearsLabel.setText("Years Processed: " + salesData.length);
    }

    private void clearData() {
        salesDataArea.setText("");
        yearsLabel.setText("Years Processed: 0");
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
            // Save the text area contents to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
                writer.write(salesDataArea.getText());
                JOptionPane.showMessageDialog(null, "Data saved successfully to data.txt!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error saving data: " + ioException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()

