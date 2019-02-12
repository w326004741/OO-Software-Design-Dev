package Strategy_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 10:28 PM
 * @description: 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化
 */
public class Context {

    private Strategy strategy; // 采用当前的算法对象

    // 可以通过构造器来注入
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 可以通过Set方法来注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double s) {
        System.out.println("报价：" + strategy.getPrice(s));
    }
}
