package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 2:49 PM
 * @description: ${description}
 * <p>
 * <p>
 * if between cities in non-bordering countries, travel by plane through their corresponding airports
 * 如果在非毗邻国家的城市之间，乘飞机通过相应的机场
 */
public class ByPlane implements ITransportBehaviour {

    public ByPlane() {
    }

    /**
     * Will calculate the shortest routes when user input a city
     * of origin city and destination city in the non-bordering country
     *
     * @param c1 origin city
     * @param c2 destination city
     * @return
     */
    public void transportChoice(City c1, City c2) {
        System.out.println("Travel from " + c1.getName() + " to " + c2.getName() + " by Plane");

    }
//    public String transportChoice(City c1, City c2) {
//        return "Travel from " + c1.getName() + " to " + c2.getName() + " by Plane";
//    }
}
