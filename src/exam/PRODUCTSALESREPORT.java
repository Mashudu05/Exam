public class ProductSalesReport {
    public static void main(String[] args) {
        // Product sales data for two years, 4 quarters each (Year 1 and Year 2)
        int[][] salesData = {
            {300, 150, 700}, // Year 1: Q1, Q2, Q3
            {250, 200, 600}, // Year 2: Q1, Q2, Q3
        };

        // Variables to hold total, average, maximum, and minimum
        int totalSales = 0;
        int maxSales = Integer.MIN_VALUE;
        int minSales = Integer.MAX_VALUE;
        int numberOfQuarters = salesData.length * salesData[0].length;  // Total quarters for 2 years

        // Calculate total sales, max and min sales
        for (int year = 0; year < salesData.length; year++) {
            for (int quarter = 0; quarter < salesData[year].length; quarter++) {
                int sales = salesData[year][quarter];
                totalSales += sales;
                if (sales > maxSales) {
                    maxSales = sales;
                }
                if (sales < minSales) {
                    minSales = sales;
                }
            }
        }

        // Calculate average sales
        double averageSales = (double) totalSales / numberOfQuarters;

        // Display the report
        System.out.println("Product Sales Report for 2 Years");
        System.out.println("=================================");
        System.out.printf("Total Sales: %d\n", totalSales);
        System.out.printf("Average Sales: %.2f\n", averageSales);
        System.out.printf("Maximum Sales: %d\n", maxSales);
        System.out.printf("Minimum Sales: %d\n", minSales);
        System.out.println("=================================");
    }
}
