package controllers;

import exceptions.DataFormatException;

import models.City;
import models.Country;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import play.mvc.Controller;
import play.mvc.With;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:44 PM
 * @description: ${description}
 */
@With(Secure.class)
public class CountryLoader extends Controller {

    public static void loader() {
        render();
    }

    public static void uploadJSON(File jsonData, boolean clearData) {

        try {
            System.out.println(clearData);
            if (clearData) play.test.Fixtures.deleteDatabase();

            InputStream input = new FileInputStream(jsonData);
            /** call the populateDatabase(InputStream input) function**/
            populateDatabase(input);

            flash.success("File uploaded successfully and database updated");
        } catch (FileNotFoundException fe) {
            flash.error("Upload Failed! JSON File Not Found");
            fe.printStackTrace();
        } catch (DataFormatException de) {
            flash.error("Data formatting error: " + de.getMessage());
            de.printStackTrace();
        } catch (JSONException je) {
            flash.error("JSON library exception raised while loading the file..."); // 加载文件时引发JSON库异常…
            je.printStackTrace();
        }
        loader();
    }

    private static void populateDatabase(InputStream input)
            throws DataFormatException, FileNotFoundException, JSONException {

        // Parse the JSON file and make sure it's not completely broken.
        JSONTokener parser = new JSONTokener(input);
        JSONObject data = new JSONObject(parser);

        // Check if file has the key "countries"
        if (!data.has("countries")) {
            throw new DataFormatException("No Key 'countries', nothing I can do with these data.", data);
        }
        // Load the array of countries
        JSONArray countriesArray = data.getJSONArray("countries");

        // Check if the data for "customers" is a an array
        if (!(countriesArray instanceof JSONArray)) {
            throw new DataFormatException("Key 'countries' must point to a JSON array.", data);
        }

        // Loop through all countries
        for (int i = 0; i < countriesArray.length(); i++) {
            JSONObject countriesJSON = countriesArray.getJSONObject(i);

            if (!(countriesJSON.has("id") && countriesJSON.get("id") instanceof Integer))
                throw new DataFormatException("All countries must be id.", data);

            if (!(countriesJSON.has("name") && countriesJSON.get("name") instanceof String))
                throw new DataFormatException("All countries must be name.", data);

            if (!(countriesJSON.has("capital") && countriesJSON.get("capital") instanceof Integer)) {
                throw new DataFormatException("All countries must be capital.", data);
            }

            Integer countryId = countriesJSON.getInt("id");
            String countryName = countriesJSON.getString("name");
            Integer countryCapitalId = countriesJSON.getInt("capital");
//            System.out.println(countriesId, countriesName, countriesCapitalId);

            // id != Id， must capital Id
            if (null != Country.find("byCountryId", countryId).first())
                throw new DataFormatException("There is already an existing countries with id " + countryId, data);

            System.out.println("countryId: " + countryId);
            System.out.println("countryName: " + countryName);

            City capital = null;
            Country country = new Country(countryId, countryName);
//            country.save();

//            City capital = null;
            // countriesCapital 的type是city 不是 Integer
//            Country country = new Country(countryId, countryName);
//            country.save();

            //cities JSON Array 内部数组
            if (countriesJSON.has("cities") && countriesJSON.get("cities") instanceof JSONArray) {
                /**如果是，拿数组*/
                JSONArray citiesArray = countriesJSON.getJSONArray("cities");
                /**遍历拿数组内容*/
                for (int j = 0; j < citiesArray.length(); j++) {
                    JSONObject citiesJSON = citiesArray.getJSONObject(j);

                    if (!citiesJSON.has("id") && citiesJSON.get("id") instanceof Integer) {
                        throw new DataFormatException("Missing cities id for countries " + countryName, data);
                    }
                    if (!citiesJSON.has("name") && citiesJSON.get("name") instanceof String) {
                        throw new DataFormatException("Missing cities name for countries " + countryName, data);
                    }
                    if (!citiesJSON.has("population") && citiesJSON.get("population") instanceof Integer) {
                        throw new DataFormatException("Missing cities population for countries " + countryName, data);
                    }

                    Integer citiesId = citiesJSON.getInt("id");
                    String citiesName = citiesJSON.getString("name");
                    Integer citiesPopulation = citiesJSON.getInt("population");

                    System.out.println(citiesId);
                    System.out.println(citiesName);
                    System.out.println(citiesPopulation);


                    if (null != City.find("byCityId", citiesId).first()) {
                        throw new DataFormatException("There is already an existing cities with Id " + citiesId, data);
                    }

                    City city = new City(citiesId, citiesName, citiesPopulation);
                    city.save(); // city save into database done

                    country.cities.put(citiesId, city);

                    // countryCapitalId as byCityId, if capitaId = cityId,
                    capital = City.find("byCityId", countryCapitalId).first();
                    country.capital = capital;  // set country capital
                    country.save();  // save country capital into database

                    System.out.println("capital id: " + country.capital);
                    //country.cities.put(citiesId, city); // 代替 putCity方法：cities.put(city.getId, city)
//                    country.save();
                }
            }
        }

//        // Now that we have all the countries, deal with borders
        if (data.has("bordering")) {
            JSONObject borderingJSON = data.getJSONObject("bordering");
            for (String k : borderingJSON.keySet()) {
                Integer countriesId = Integer.parseInt(k);
                Country country = Country.find("byCountryId", countriesId).first();

                if (null == country) {
                    throw new DataFormatException("There is no countries with Id " + countriesId, data);
                }

                JSONArray borderingArray = borderingJSON.getJSONArray(k);
                for (int i = 0; i < borderingArray.length(); i++) {
                    Integer borderingCountriesNumber = borderingArray.getInt(i);

                    Country country1 = Country.find("byCountryId", borderingCountriesNumber).first();

                    if (null == country1) {
                        throw new DataFormatException("There is no countries with Id " + countriesId, data);
                    }

                    country.neighbor.put(borderingCountriesNumber, country1);
                }

            }
        }
    }
}
