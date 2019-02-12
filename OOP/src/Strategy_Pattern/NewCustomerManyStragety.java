package Strategy_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 10:23 PM
 * @description: ${description}
 */
public class NewCustomerManyStragety implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打九折");
        return standardPrice * 0.9;

    }
}
