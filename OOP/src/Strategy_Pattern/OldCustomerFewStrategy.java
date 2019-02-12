package Strategy_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 10:21 PM
 * @description: ${description}
 */
public class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("八五折");
        return standardPrice * 0.85;
    }
}
