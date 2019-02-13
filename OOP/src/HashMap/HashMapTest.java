package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weichen Wang
 * @date 2019/2/12 - 11:26 PM
 * @description: ${description}
 */
public class HashMapTest {
    public static void main(String[] args) {
        // create a Map
        Map<String, TVSeries> seriesIndex = new HashMap<>();
        // put something in it
        TVSeries s = new TVSeries("twin peaks");
        seriesIndex.put("twin peaks", s);

        // check if a key is present
        if (seriesIndex.containsKey("Twin Peaks")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // get the value for that key
        TVSeries s1 = seriesIndex.get("twin peaks");
        System.out.println(s1.getName());
    }

}
