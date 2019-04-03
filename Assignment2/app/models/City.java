package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:20 PM
 * @description: ${description}
 */

@Entity
public class City extends Model {

    public Integer cityId;  // cannot be id, cuz The superclass Model already has Long id automatically generated
    public String name;
    public Integer population;

    @ManyToOne   // Many Cities could be have One Countries
    public Country country;

    public City(Integer cityId, String name, Integer population) {
        this.cityId = cityId;
        this.name = name;
        this.population = population;
    }

    // Override Constructor
//    public City(Integer id, String name, Integer population) {
//        this.id = id;
//        this.name = name;
//        this.population = population;
//    }
}
