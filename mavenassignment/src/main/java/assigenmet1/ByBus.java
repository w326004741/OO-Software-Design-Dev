package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 2:49 PM
 * @description: ${description}
 */
public class ByBus implements ITransportBehaviour {


    public void transportChoice(City c1, City c2) {
        System.out.println("Travel from " + c1.getName() + " to " + c2.getName() + " by Bus");
    }
}
