package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 12:18 PM
 * @description: Bordering extends City, 可用 id, name
 */
public class Bordering {

    private Country countries;

    public Bordering() {
    }

    public Bordering(Country countries) {
        this.countries = countries;
    }

    public Country getCountries() {
        return countries;
    }

    public Country setCountries(Country countries) {
        this.countries = new Country();
        return countries;

    }
}
