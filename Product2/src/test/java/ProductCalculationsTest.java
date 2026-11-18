import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.yourcompany.yourproject.ProductCalculations;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);
        
        double expectedVat = 525.0; 
        double actualVat = calc.GetVat();
        
        assertEquals(expectedVat, actualVat, 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);
        
        double expectedTotal = 4200.0;
        double actualTotal = calc.GetTotal();
        
        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}