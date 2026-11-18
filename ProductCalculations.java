public class ProductCalculations implements IProductCalculations {
    private double price;

    private static final double VAT_RATE = 0.15;        // 15%
    private static final double COMMISSION_RATE = 0.05; // 5%

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVAT() {
        return price * VAT_RATE;
    }

    @Override
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    @Override
    public double GetTotal() {
        return price + GetVAT() + GetCommission();
    }
}
