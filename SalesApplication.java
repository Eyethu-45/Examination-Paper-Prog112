import java.util.Scanner;

public class SalesApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Single-dimensional array for product names[cite: 4]
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array for monthly sales data (3 products x 3 months)[cite: 4]
        int[][] sales = new int[3][3];

        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                sales[i][j] = scanner.nextInt();
            }
        }

        // Instantiate Product and PrintProduct
        Product productObj = new Product(products, sales);
        PrintProduct printer = new PrintProduct(productObj);
        
        // Print Report
        printer.printReport();

        scanner.close();
    }
