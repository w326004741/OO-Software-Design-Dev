package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 2:49 PM
 * @description: if between cities within the same country, take a bus
 */
public class ByBus implements ITransportBehaviour {

    public ByBus() {
    }

    /**
     * Will calculate the shortest routes when user input a city
     * of origin city and destination city in the same country
     *
     * @param c1 origin city
     * @param c2 destination city
     * @return
     */
    public void transportChoice(City c1, City c2) {
        System.out.println("Travel from " + c1.getName() + " to " + c2.getName() + " by Bus");

    }
//    public String transportChoice(City c1, City c2) {
//        return "Travel from " + c1.getName() + " to " + c2.getName() + " by Bus";
//    }
}
