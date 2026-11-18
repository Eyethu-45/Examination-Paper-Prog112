import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVAT_WithValidData_ReturnsCorrectValue() {
        double price = 3500.00;
        ProductCalculations calc = new ProductCalculations(price);
        double expectedVAT = 525.00;

        double actualVAT = calc.GetVAT();

        assertEquals(expectedVAT, actualVAT, 0.001);
    }

    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        double price = 3500.00;
        ProductCalculations calc = new ProductCalculations(price);
        double expectedCommission = 175.00;

        double actualCommission = calc.GetCommission();

        assertEquals(expectedCommission, actualCommission, 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        double price = 3500.00;
        ProductCalculations calc = new ProductCalculations(price);
        double expectedTotal = 4200.00;

        double actualTotal = calc.GetTotal();

        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}
