package Strategy_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 10:34 PM
 * @description: ${description}
 */
public class Client {
    public static void main(String[] args) {

        Strategy s1 = new OldCustomerManyStragety();
        Context ctx = new Context(s1);
        Strategy s2 = new NewCustomerFewStrategy();
        Context ctx1 = new Context(s2);

        ctx.printPrice(998);
        ctx1.printPrice(998);
    }
}
