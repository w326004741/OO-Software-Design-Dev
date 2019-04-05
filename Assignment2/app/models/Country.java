package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:20 PM
 * @description: ${description}
 */
@Entity
public class Country extends Model {

    public Integer countryId;  // cannot be id, cuz The superclass Model already has Long id automatically generated

    public String name;

    private int population;

    @OneToOne  // every country must have one capital. One-to-One Associations
    private City capital;

    @OneToMany    // Country can have several Cities & each City has the one Country
    private Map<Integer, City> cities;


    @ManyToMany    // Country can have several neighbor country & each neighbor country has the one Country
    private Map<Integer, Country> neighbor;


    public Country(Integer countryId, String name) {
        this.countryId = countryId;
        this.name = name;
        this.cities = new HashMap<Integer, City>();
        this.neighbor = new HashMap<Integer, Country>();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Map<Integer, City> getCities() {
        return cities;
    }

    public void setCities(Map<Integer, City> cities) {
        this.cities = cities;
    }

    public Map<Integer, Country> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Map<Integer, Country> neighbor) {
        this.neighbor = neighbor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (countryId == null) {
            if (other.countryId != null)
                return false;
        } else if (!countryId.equals(other.countryId))
            return false;
        return true;
    }

    public int getPopulation() {
        int p = 0;
        for (City c : cities.values()) {
            p += c.getPopulation();
        }
        return p;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


//    public Country(Integer countryId, String name, City capital) {
//        this.countryId = countryId;
//        this.name = name;
//        this.capital = capital;
//        this.cities = new HashMap<Integer, City>();
//        this.neighbor = new HashMap<Integer, Country>();
//    }

    //    public Country(final Integer id, String name, City capital) {
//        this.id = id;
//        this.name = name;
//        this.capital = capital;
//        this.cities = new HashMap<Integer, City>();
//        this.neighbor = new HashMap<Integer, Country>();
//    }


}
