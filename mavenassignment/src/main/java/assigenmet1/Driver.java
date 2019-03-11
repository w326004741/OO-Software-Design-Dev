package assigenmet1;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: ${description}
 */
public class Driver {
    static final HashMap<Integer, Country> COUNTRIES = new HashMap<Integer, Country>();// Country List 国家列表
    static final HashMap<Integer, City> CITIES = new HashMap<Integer, City>();// City List 城市列表
    static Scanner sc = new Scanner(System.in);
    static City city;
    static Country country;
    static Country bordering;

    // JSON file Parser
    public static void initArray() {
        // 获取InputStream，拿到JSON文件
        InputStream input = Driver.class.getResourceAsStream("/data.json");
        // JSONTokener 解析JSON文件
        JSONTokener parser = new JSONTokener(input);
        // JSONObject接受解析文件内容，存入JSONObject data
        JSONObject data = new JSONObject(parser);
        JSONArray countriesArray = data.getJSONArray("countries");

        /**用countriesArray遍历得到每个国家的内容(id,name,capital)*/
        for (int i = 0; i < countriesArray.length(); i++) {
            int countryId = countriesArray.getJSONObject(i).getInt("id");
            String countryName = countriesArray.getJSONObject(i).getString("name");
            int capitalId = countriesArray.getJSONObject(i).getInt("capital");
            City capital = null;
            country = new Country(countryId, countryName, capital);
            JSONArray cityArray = countriesArray.getJSONObject(i).getJSONArray("cities");
            for (int j = 0; j < cityArray.length(); j++) {
                int cityId = cityArray.getJSONObject(j).getInt("id");
                String cityName = cityArray.getJSONObject(j).getString("name");
                int population = cityArray.getJSONObject(j).getInt("population");
                city = new City(cityId, cityName, population);
                city.setCountry(country);
                country.putCity(city);
                if (capitalId == cityId) {
                    country.setCapital(city);
                }
                CITIES.put(city.getId(), city);
            }
            COUNTRIES.put(country.getId(), country);
        }

        for (int i = 0; i < countriesArray.length(); i++) {
            int countryId = countriesArray.getJSONObject(i).getInt("id");
            Country country = COUNTRIES.get(countryId);
            JSONArray borderingArray = countriesArray.getJSONObject(i).getJSONArray("bordering");
            for (int j = 0; j < borderingArray.length(); j++) {
                int borderingId = borderingArray.getInt(j);
                bordering = COUNTRIES.get(borderingId);
                country.putNeighbor(bordering);
            }
//            System.out.println(country.toString() + ", ");
        }
    }

    public static void main(String[] args) {
        initArray(); // reloading data 加载JSON数据
        while (true) {
            System.out.println();
            menu();
            int user = sc.nextInt();
            switch (user) {
                case 1:
                    listAllCountries(COUNTRIES); // List all the countries
                    break;
                case 2: // For every country, list the bordering countries
                    // and answer the question whether two countries are bordering or not
                    System.out.println("List bordering countries: ");
                    listBorderingCountries(COUNTRIES);
                    System.out.println("Please input FromCityId: ");
                    int cityFromId = sc.nextInt();
                    System.out.println("Please input ToCityId: ");
                    int cityToId = sc.nextInt();
                    isNeighbor(cityFromId, cityToId);
                    break;
                case 3: // Retrieve the population of a city or country(For City Population)
                    System.out.println("Please input City Id to Check the Population of a City: ");
                    int cityId = sc.nextInt();
                    populationCity(cityId);
                    break;
                case 4: // List all the cities in a country, or retrieve only the capital
                    listAllCities(CITIES);
                    break;
                case 5:  // The Best Travel Plan
                    System.out.println("Please input FromCityId:");
                    int cityFromId1 = sc.nextInt();
                    System.out.println("Please input ToCityId: ");
                    int cityToId1 = sc.nextInt();
                    travelPlan(cityFromId1, cityToId1);
                    break;
                case 6:  // Exit
                    System.out.println("Thanks for your use! Bye-Bye :-)");
                    System.exit(1);
                    break;
                default: // Error Input
                    System.err.println("\nSorry, We don't have this function, Please Enter Again.");
                    break;
            }
        }
    }

    // List all the Countries
    public static void listAllCountries(HashMap<Integer, Country> COUNTRIES) {
        System.out.println("===============List all the countries===============");
        Set<HashMap.Entry<Integer, Country>> countriesSet = COUNTRIES.entrySet();
        Iterator<HashMap.Entry<Integer, Country>> countriesIter = countriesSet.iterator();
        while (countriesIter.hasNext()) {
            HashMap.Entry<Integer, Country> hme = countriesIter.next();
            System.out.println(hme.getValue() + ",\n");
        }
    }

    // List all the cities in a countries
    public static void listAllCities(HashMap<Integer, City> CITIES) {
        Set<HashMap.Entry<Integer, City>> citiesSet = CITIES.entrySet();
        Iterator<HashMap.Entry<Integer, City>> citiesIter = citiesSet.iterator();
        System.out.println("\n==============List all the City in a Country(Id,Name,Population)==============:");
        while (citiesIter.hasNext()) {
            HashMap.Entry<Integer, City> hme = citiesIter.next();
            System.out.print(hme.getValue() + ",\t\t" + "In " + hme.getValue().getCountry().getName());
            System.out.println();
        }
    }

    // Check Bordering Country
    public static void isNeighbor(int cityFromId, int cityToId) {
        JourneyLeg journeyLeg = null;
        HashMap<Integer, City> cities = Driver.CITIES;
        HashMap<Integer, Country> countries = Driver.COUNTRIES;
        City cityFrom = cities.get(cityFromId);
        City cityTo = cities.get(cityToId);
        System.out.println(cityFromId + ": " + cityFrom.getName() + ", " + cityFrom.getCountry().getName() + "\n" + cityToId + ": " + cityTo.getName() + ", " + cityTo.getCountry().getName() + "\n");
        if (cityFrom.getCountry().getNeighbor().get(cityTo.getCountry().getId()) != null) {
            System.out.println("=====>️ True! They are bordering countries!");
            return;
        }
        System.out.println("====> False! They are not bordering countries!");
        return;
    }

    // Retrieve the Population of City
    public static void populationCity(int city) {
        JourneyLeg journeyLeg = null;
        HashMap<Integer, City> cities = Driver.CITIES;
        City city1 = cities.get(city);
        System.out.println("=====Population of a City======");
        System.out.println(city1.getName() + " population is: " + city1.getPopulation());
    }

    // Travel Plan
    public static void travelPlan(int cityFromId, int cityToId) {
        System.out.println("===============The Best Travel Plan could be=============== ");
        JourneyLeg journeyLeg1 = new JourneyLeg();
        journeyLeg1.compareCountry(cityFromId, cityToId);
    }

    // List all the bordering countries
    public static void listBorderingCountries(HashMap<Integer, Country> COUNTRIES) {
        System.out.println("===============List the bordering country===============");
        Set<HashMap.Entry<Integer, Country>> countriesSet = COUNTRIES.entrySet();
        Iterator<HashMap.Entry<Integer, Country>> countriesIter = countriesSet.iterator();
        while (countriesIter.hasNext()) {
            HashMap.Entry<Integer, Country> hme = countriesIter.next();
            System.out.println("<<" + hme.getValue().getName() + "'s bordering countries>>:  " + hme.getValue().getNeighbor() + ",\n");
        }
    }

    public static void menu() {
        System.out.println("====================================================");
        System.out.println("1. List all the countries");
        System.out.println("2. List all the bordering countries & Are they Neighbor Countries? (True/False)");
        System.out.println("3. Retrieve the population of a city or country");
        System.out.println("4. List all the cities in a country");
        System.out.println("5. The Best Travel Plan");
        System.out.println("6. Exit");
        System.out.println("=====================================================");
        System.out.print("Please enter number: ");
    }
}

