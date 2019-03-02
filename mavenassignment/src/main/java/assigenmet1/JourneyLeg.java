package assigenmet1;


/**
 * @author Weichen Wang
 * @date 2019/2/15 - 5:07 PM
 * @description: JourneyLeg has ITransportBehaviour <>--> 聚合关系 Aggregation</>   Leg ： 单程
 * <p>
 * 该类可能需要被继承 extends，因为
 */
public class JourneyLeg {
    /**
     * 定义一个抽象方法，从一个City 到 另一个City, 由3个子类继承（ByPlane, ByTrain, ByBus）
     * 实现Polymorphism 多态性
     * 每个 JourneyLeg 都会引用实现 Transport接口的对象
     */
    private ITransportBehaviour transport;  // declare data member(JourneyLeg Has ITransportBehaviour (Aggregation聚合))

    public JourneyLeg() {
    }

    // Constructor
    public JourneyLeg(ITransportBehaviour transport) {
        this.transport = transport;
    }

    public void travel(Cities c1, Cities c2) {
        this.transport.transportChoice(c1, c2);
//        System.out.println("called travel method");
    }

    /**
     * 1. if between cities within the same country, take a bus
     * 2. if between cities in bordering countries, take the train
     * 3. if between cities in non-bordering countries, travel by plane through their corresponding airports
     */
    public void compareCountry(Countries countries1, Countries countries2, Cities c1, Cities c2) {

//        if ((countries1 == countries2) && (c1 != c2)) {
//            JourneyLeg journeyLeg = new JourneyLeg(new ByBus());
//            journeyLeg.travel(c1, c2);
//        } else if ((countries1 != countries2) && (c1 != c2)) {
//            JourneyLeg journeyLeg1 = new JourneyLeg(new ByPlane());
//            journeyLeg1.travel(c1, c2);
//        }
    }
}

