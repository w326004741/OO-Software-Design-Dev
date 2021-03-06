import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {


    @Before  // This function will first in this test
    public void setup() {
        // Clear the database
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveCity() {
        // create a city object
        City city = new City(101, "Dublin", 554554);

        // Save to the database
        city.save();

        // Find the city with "Name = Galway",只能是name,不能是CityName,因为City内没有cityName这个字段，只是继承了Place中的name
        City city1 = City.find("byName", "Dublin").first();

        // Check that the city exists
        assertNotNull(city1);   // 判断city1 object 不为 null

        // Check if the City Name of found City matches with Galway
        assertEquals("Dublin", city1.getName());
    }

    @Test
    public void createAndRetrieveCountry() {
        // create a country object
        Country country = new Country(1, "Ireland");
        // Save to the database
        country.save();
        // Find the country with "Name = Ireland",
        Country country1 = Country.find("byName", "Ireland").first();
        // Check that the country exists
        assertNotNull(country1);

        // Check if the Country Name of found Country matches with Ireland
        assertEquals(country.getName(), "Ireland");

        assertEquals(country.getName(), country1.getName());

    }

}
