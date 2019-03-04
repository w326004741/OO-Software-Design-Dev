package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 2:49 PM
 * @description: 实现 Transport接口的实体类，
 * <p>
 * if between cities in bordering countries, take the train
 */
public class ByTrain implements ITransportBehaviour {

    public ByTrain() {
    }


    /**
     * Will calculate the shortest routes when user input a city
     * of origin city and destination city in the bordering country
     *
     * @param c1 origin city
     * @param c2 destination city
     * @return
     */

    public void transportChoice(City c1, City c2) {
        System.out.println("Travel from " + c1.getName() + " to " + c2.getName() + " by Train");

    }
//    public String transportChoice(City c1, City c2) {
//        return "Travel from " + c1.getName() + " to " + c2.getName() + " by Train";
//    }
}
