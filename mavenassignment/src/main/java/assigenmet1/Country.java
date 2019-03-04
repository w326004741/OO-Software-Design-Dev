package assigenmet1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: 再定义外层JSON对象 Country
 */
public class Country {
    private int id;
    private String name;
    private List<LinkedHashMap<String, Object>> cities; // LinkedHashMaP<> 是有序的HashMap(order HashMap)
    private List<City> citiesList = new ArrayList<City>();
    private int capital;   // One Country only one Capital
    private int countryPopulation;
    private City city;

    public Country() {
    }

    public Country(int id, String name, int capital, int countryPopulation) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.countryPopulation = countryPopulation;
//        this.city = city;
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

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public List<LinkedHashMap<String, Object>> getCities() {
        return cities;
    }

    public void setCities(List<LinkedHashMap<String, Object>> cities) {
        this.cities = cities;
    }

    public List<City> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<City> citiesList) {
        this.citiesList = citiesList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = new City(); // 初始化对象 聚合关系
    }

    /**
     * Capital
     */
    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                ", citiesList=" + citiesList +
                ", capital=" + capital +
                ", countryPopulation=" + countryPopulation +
                ", city=" + city +
                '}';
    }
}
