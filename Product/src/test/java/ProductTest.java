import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.yourcompany.yourproject.Product;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        String[] names = {"Product A", "Product B"};
        int[][] sampleSales = {
            {10, 20, 30},
            {5, 10, 15}
        };

        Product product = new Product(names, sampleSales);
        int expectedTotal = 90;
        int actualTotal = product.GetTotalProductsSold();

        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        String[] names = {"Product A", "Product B"};
        int[][] sampleSales = {
            {10, 20, 30},
            {10, 20, 30}
        };

        Product product = new Product(names, sampleSales);
        double expectedAverage = 20.0;
        double actualAverage = product.GetAverageProductSold();

        assertEquals(expectedAverage, actualAverage, 0.001);
    }
}