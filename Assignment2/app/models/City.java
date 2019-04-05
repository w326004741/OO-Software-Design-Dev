package models;

import play.db.jpa.Model;

import javax.persistence.*;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:20 PM
 * @description: ${description}
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class City extends Model {

    private Integer cityId;  // cannot be id, cuz The superclass Model already has Long id automatically generated
   
	private String name;
    private Integer population;

    @ManyToOne   // Many Cities could be have One Countries
    public Country country;

    public City(Integer cityId, String name, Integer population) {
        this.cityId = cityId;
        this.name = name;
        this.population = population;
    }

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		City other = (City) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}
    
}
