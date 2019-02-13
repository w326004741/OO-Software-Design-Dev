package assigenmet1;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: ${description}
 */
public class Countries {

    private String name;
    private int id;
    private int capital;
    private List<String> cities = new ArrayList<String>();


    public Countries(String name) {
        this.name = name;
    }

    public Countries(String name, int id, int capital) {
        this.name = name;
        this.id = id;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCapital() {
        return capital;
    }

    public List<String> getCities() {
        return cities;
    }
}
