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
