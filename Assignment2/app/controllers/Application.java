package controllers;

import net.sf.ehcache.search.aggregator.Count;
import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {

        List<Country> countries = Country.findAll();
//        List<City> cities = City.findAll();

        render(countries);
    }

    public static void show(Integer countryId) {
        // Math.toIntExact(countriesId)): Long to int
//        Country country = Country.find("byCountryId", Math.toIntExact(countryId)).first();
        Country country = Country.find("byCountryId", countryId).first();

        Map<Integer, Country> neighbor = country.neighbor;
        Map<Integer, City> cities = new HashMap<>();

        for (Integer borderingId : neighbor.keySet()) {
            Country value = neighbor.get(borderingId);
            System.out.println(borderingId + " " + value.name);

            cities = value.cities;
            for (Integer cityId : cities.keySet()) {
                City value1 = cities.get(cityId);
                System.out.println("City id:" + cityId + " " + value1.name);
            }

            System.out.println(value.cities.size());

        }

        render(country, neighbor, cities);
    }


    /**
     * Action method for check.html view template.c
     * check 只处理check页面的内容，和读JSON文件内容无关
     * check page for Plan Journey, select a start city -> select an end city -> click 'Plan Journey' button
     * -> output display under button
     */
    public static void check() {
        List<Country> countries = Country.findAll();
        List<City> cities = City.findAll();

        render(countries, cities);
    }


    //    // accountId 对应了check.html内的label
    public static void planJourney(@Required Long countriesId, @Required Long citiesId) {
        Country country = Country.findById(countriesId);
        City city = City.findById(citiesId);


        if (validation.hasErrors()) {
            render("Application/check.html");
        }

        if (country.cities.containsValue(city)) {
            flash.success("Yes %s has city id %s", country.name, city.cityId);
        } else {
            flash.error("No %s has not city id %s", country.name, city.cityId);
        }
        check();
    }


}