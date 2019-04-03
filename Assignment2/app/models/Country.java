package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    //    @OneToOne  // every country must have one capital. One-to-One Associations
    public City capital;

    @OneToMany    // Country can have several Cities & each City has the one Country
    public Map<Integer, City> cities; // HashMap 是无序的  Integer = id
    // One Country could be have one or mang cities

    @OneToMany     // Country can have several neighbor country & each neighbor country has the one Country
    public Map<Integer, Country> neighbor; // Integer = id, bordering country,通过国家ID找到国家名字
    // One Country could be have one or many bordering country

    public Country(Integer countryId, String name) {
        this.countryId = countryId;
        this.name = name;
        this.cities = new HashMap<Integer, City>();
        this.neighbor = new HashMap<Integer, Country>();
    }


//    public Country(final Integer id, String name, City capital) {
//        this.id = id;
//        this.name = name;
//        this.capital = capital;
//        this.cities = new HashMap<Integer, City>();
//        this.neighbor = new HashMap<Integer, Country>();
//    }


}
