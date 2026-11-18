import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        // Arrange
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20}, // 63
            {15, 10, 12}, // 37
            {18, 15, 20}  // 53
        }; // Total = 153
        
        Product product = new Product(products, sales);
        int expectedTotal = 153;

        // Act
        int actualTotal = product.GetTotalProductsSold();

        // Assert
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        }; // 153 / 9 entries = 17
        
        Product product = new Product(products, sales);
        double expectedAverage = 17.0;

        // Act
        double actualAverage = product.GetAverageProductSold();

        // Assert
        assertEquals(expectedAverage, actualAverage, 0.001);
    }
}
