package assigenmet1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: 再定义外层JSON对象 Countries
 */
public class Country {
    private int id;
    private String name;
    private HashMap<Integer, City> cities; //是有序的HashMap(order HashMap)
    private City capital;   // One Country only one Capital
    private HashMap<Integer, Country> neighbor;
    
    public Country() {
    	
    }

    public Country(final int id, String name, City capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.cities = new HashMap<Integer, City>();
        this.neighbor = new HashMap<Integer, Country>();
    }
    public void putCity(City city){
    	cities.put(city.getId(), city);
    }
    public void putNeighbor(Country country){
    	neighbor.put(country.getId(), country);
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

    public HashMap<Integer, City> getCities() {
		return cities;
	}

	public void setCities(HashMap<Integer, City> cities) {
		this.cities = cities;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public HashMap<Integer, Country> getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(HashMap<Integer, Country> neighbor) {
		this.neighbor = neighbor;
	}

	@Override
    public String toString() {
        return "Country{" + "name=" + name + ", id='" + id + '\'' + ", cities=" + cities +
                ", cities=" + cities + ", capital=" + capital + ", neighbor=" + neighbor.keySet() +'}';
    }
}
