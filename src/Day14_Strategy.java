public class Day_Strategy {
    static void main() {
        FeeCalculator calc = new FeeCalculator(new NoDiscount());
        System.out.println("Final Fee with No Discount: "+calc.finalFee(1000));
        calc.setDiscountStrategy(new SummerSaleDiscount());
        System.out.println("Final Fee with SummerSale Discount: "+calc.finalFee(1000));
    }
}
interface DiscountStrategy{
    double apply(double fee);
}
class SummerSaleDiscount implements DiscountStrategy {
    @Override
    public double apply(double fee){
        return fee * 0.7;
    }
}
class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double fee){
        return fee;
    }
}
class FeeCalculator{
    private DiscountStrategy  discountStrategy;
    public FeeCalculator(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }
    void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }
    double finalFee(double fee){
       return discountStrategy.apply(fee);
    }
}
