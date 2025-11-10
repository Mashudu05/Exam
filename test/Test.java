
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSalesTest {

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Arrange: supply sales data
        double[] salesData = {100.0, 200.0, 300.0};
        ProductSales productSales = new ProductSales(salesData);
        
        // Act: calculate total sales
        double totalSales = productSales.TotalSales();
        
        // Assert: check that total sales is as expected
        assertEquals(600.0, totalSales, "The total sales should be 600.0");
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        // Arrange: supply sales data
        double[] salesData = {100.0, 200.0, 300.0};
        ProductSales productSales = new ProductSales(salesData);
        
        // Act: calculate average sales
        double averageSales = productSales.AverageSales();
        
        // Assert: check that the average sales is as expected
        assertEquals(200.0, averageSales, "The average sales should be 200.0");
    }
}
