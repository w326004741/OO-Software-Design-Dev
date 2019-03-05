package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 12:17 PM
 * @description: 从内到外 先定义JSON对象内的内部对象数组 即 cities
 */
public class City {
    private int id;
    private String name;
    private int population;
    private Country country;

    // Default Constructor
    public City() {
        
    }

    // Override Constructor
    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	// getter & setter
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

    public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
    public String toString() {
        return "City{" + "'id' = '" + id + "', 'name' = '" + name + "', " + "'population' = '" + population + "'}";
    }
}
