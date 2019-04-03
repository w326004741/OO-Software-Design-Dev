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

    @Id
    public Integer id;
    public String name;
    public Integer population;

    @ManyToOne   // Many Cities could be have One Countries
    public Country country;


    // Override Constructor
    public City(Integer id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}
