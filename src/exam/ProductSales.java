
package exam;


public class ProductSales {
   public static void main(String[] args) {  
}
// Interface definition
public interface IProduct
{
    int TotalSales(int[][] productSales);
    double AverageSales(int[][] productSales);
    int MaxSale(int[][] productSales);
    int MinSale(int[][] productSales);
}

// Class implementation
public class ProductSales : IProduct
{
    // Method to calculate total sales
    public int TotalSales(int[][] productSales)
    {
        int total = 0;
        foreach (var sales in productSales)
        {
            foreach (var sale in sales)
            {
                total += sale;
            }
        }
        return total;
    }

    // Method to calculate average sales
    public double AverageSales(int[][] productSales)
    {
        int total = TotalSales(productSales);
        int count = 0;

        foreach (var sales in productSales)
        {
            count += sales.Length;
        }

        return count > 0 ? (double)total / count : 0.0; // avoid division by zero
    }

    // Method to find the maximum sale
    public int MaxSale(int[][] productSales)
    {
        int maxSale = int.MinValue;

        foreach (var sales in productSales)
        {
            foreach (var sale in sales)
            {
                if (sale > maxSale)
                {
                    maxSale = sale;
                }
            }
        }

        return maxSale;
    }

    // Method to find the minimum sale
    public int MinSale(int[][] productSales)
    {
        int minSale = int.MaxValue;

        foreach (var sales in productSales)
        {
            foreach (var sale in sales)
            {
                if (sale < minSale)
                {
                    minSale = sale;
                }
            }
        }

        return minSale;
    }
}  
}
