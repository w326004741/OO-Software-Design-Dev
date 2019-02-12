package Strategy_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 10:21 PM
 * @description: ${description}
 */
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("No Discount, 原价");
        return standardPrice;
    }
}
