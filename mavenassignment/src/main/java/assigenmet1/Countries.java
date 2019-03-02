package assigenmet1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: 再定义外层JSON对象 Countries
 */
public class Countries {
    private int id;
    private String name;
    private List<LinkedHashMap<String, Object>> cities; // LinkedHashMaP<> 是有序的HashMap(order HashMap)
    private List<Cities> citiesList = new ArrayList<Cities>();
    private Capital capital;   // One Country only one Capital

    public Countries() {
    }

    public Countries(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter & setter method
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LinkedHashMap<String, Object>> getCities() {
        return cities;
    }

    public void setCities(List<LinkedHashMap<String, Object>> cities) {
        this.cities = cities;
    }

    public List<Cities> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<Cities> citiesList) {
        this.citiesList = citiesList;
    }

    /**
     * Capital
     */
    public Capital getCapital() {
        return capital;
    }

    public Capital setCapital(Capital capital) {
        this.capital = new Capital();
        return capital;
    }

    @Override
    public String toString() {
        return "Countries{" + "id=" + id + ", name='" + name + '\'' + ", cities=" + cities +
                ", citiesList=" + citiesList + ", capital=" + capital + '}';
    }
}
