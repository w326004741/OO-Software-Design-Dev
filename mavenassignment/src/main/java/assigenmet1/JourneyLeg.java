package assigenmet1;

import java.util.HashMap;

/**
 * @author Weichen Wang
 * @date 2019/2/15 - 5:07 PM
 * @description: JourneyLeg has ITransportBehaviour Leg ： 单程
 */
public class JourneyLeg {
    /**
     * 定义一个抽象方法，从一个City 到 另一个City, 由3个子类继承（ByPlane, ByTrain, ByBus）
     * 实现Polymorphism 多态性
     * 每个 JourneyLeg 都会引用实现 Transport接口的对象
     */
    private ITransportBehaviour transport;  // reference object

    public JourneyLeg() {
    }

    // Constructor
    public JourneyLeg(ITransportBehaviour transport) {
        this.transport = transport;
    }

    public void travel(City c1, City c2) {
        this.transport.transportChoice(c1, c2);
//        System.out.println("called travel method");
    }

    /**
     * 1. if between cities within the same country, take a bus
     * 2. if between cities in bordering countries, take the train
     * 3. if between cities in non-bordering countries, travel by plane through their corresponding airports
     */
    public void compareCountry(int cityFromId, int cityToId) {
        JourneyLeg journeyLeg = null;
        HashMap<Integer, City> cities = Driver.CITIES;
        //HashMap<Integer, Country> counties = Driver.COUNTRIES;
        City cityFrom = cities.get(cityFromId);
        City cityTo = cities.get(cityToId);
        // if two cities are in same country then take the Bus 国内坐巴士
        if (cityFrom.getCountry() == cityTo.getCountry()) {
            journeyLeg = new JourneyLeg(new ByBus());
            journeyLeg.travel(cityFrom, cityTo);
            return;
        } else { // two cities are not in same country 国外
            if (cityFrom.getCountry().getNeighbor().get(cityTo.getCountry().getId()) != null) {// bordering country 边境国家
                // if two cites are both capital of country then take a plane 两城都为首都直接坐飞机
                if (cityFrom == cityFrom.getCountry().getCapital() && cityTo == cityTo.getCountry().getCapital()) {
                    journeyLeg = new JourneyLeg(new ByPlane());
                    journeyLeg.travel(cityFrom, cityTo);
                } else { // two cities that has one city is capital and another is not 有一非首都则做火车
                    journeyLeg = new JourneyLeg(new ByTrain());
                    journeyLeg.travel(cityFrom, cityTo);
                }
                return;
            }
            // no bordering country 非边境
            if (cityFrom == cityFrom.getCountry().getCapital()) {// 出发点为首都直接坐飞机到目的地国家首都
                journeyLeg = new JourneyLeg(new ByPlane());
                journeyLeg.travel(cityFrom, cityTo.getCountry().getCapital());
            } else {//出发点非首都,先做公交去首都再坐飞机去目的地国家首都
                journeyLeg = new JourneyLeg(new ByBus());
                journeyLeg.travel(cityFrom, cityFrom.getCountry().getCapital());
                journeyLeg = new JourneyLeg(new ByPlane());
                journeyLeg.travel(cityFrom.getCountry().getCapital(), cityTo.getCountry().getCapital());
            }
            if (cityTo == cityTo.getCountry().getCapital()) { // 目的地城市为首都结束行程(destination city is capital)
                return;
            } else { //目的地非首都 坐巴士去目的地
                journeyLeg = new JourneyLeg(new ByBus());
                journeyLeg.travel(cityTo.getCountry().getCapital(), cityTo);
                return;
            }
        }

    }
}

