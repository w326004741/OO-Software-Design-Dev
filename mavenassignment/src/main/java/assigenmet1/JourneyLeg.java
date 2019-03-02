package assigenmet1;


/**
 * @author Weichen Wang
 * @date 2019/2/15 - 5:07 PM
 * @description: JourneyLeg has Transport <>--> 聚合关系 Aggregation</>   Leg ： 单程
 * <p>
 * 该类可能需要被继承 extends，因为
 */
public class JourneyLeg {

    /**
     * 定义一个抽象方法，从一个City 到 另一个City, 由3个子类继承（ByPlane, ByTrain, ByBus）
     * 实现Polymorphism 多态性
     * 每个 JourneyLeg 都会引用实现 Transport接口的对象
     */
    private Transport transport;  // declare data member(JourneyLeg Has Transport (Aggregation聚合))
    private Countries countries;

    public JourneyLeg() {
//        Cities c1 = new Cities();
//        Cities c2 = new Cities();
    }

    // Constructor 实例化transport
    public JourneyLeg(Transport transport, Countries countries) {
        this.transport = transport;
        this.countries = countries;
    }

    // JourneyLeg 对象不自己处理transport行为，而是委托给transport引用的对象
    public void ChoiceTransport(Cities c1, Cities c2) {
        c1 = new Cities();
        c2 = new Cities();
        if (c1 == c2) {
            return;
        } else if (c1 != c2) {

        }


//        Cities c3 = selectStop(c1, c2);
    }

//    private Cities selectStop(Cities c1, Cities c2) {
//    }

    @Override
    public String toString() {
        return "JourneyLeg{" + "transport=" + transport + '}';
    }
}
