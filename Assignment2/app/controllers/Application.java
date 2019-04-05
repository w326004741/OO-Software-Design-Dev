package controllers;

import net.sf.ehcache.search.aggregator.Count;
import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import groovy.time.BaseDuration.From;
import models.*;


public class Application extends Controller {

    public static void index() {

        List<Country> countries = Country.findAll();
        List<City> cities = City.findAll();

        render(countries, cities);
    }

    public static void show(@Required Long countryId) {
        // Math.toIntExact(countriesId)): Long to int
        Country country = Country.find("byCountryId", Math.toIntExact(countryId)).first();

        // get cities of a country
        List<City> cityList = new ArrayList<>(country.getCities().values());

        // get cities of bordering country
        Map<Integer, Country> neighbor = country.getNeighbor();
        List<Country> neighborList = new ArrayList<Country>(neighbor.values());
        List<City> neighborCitiesList = new ArrayList<City>();
        for (Country cou : neighborList) {
            neighborCitiesList.addAll(cou.getCities().values());
        }

        render(country, neighborList, neighborCitiesList, cityList);
    }


    /**
     * check page for Plan Journey, select a start city -> select an end city -> click 'Plan Journey' button
     * -> output display under button
     */
    public static void check(Integer fid, Integer tid) {
        List<Country> countries = Country.findAll();
        List<City> cities = City.findAll();

//        String str = null;
        List<String> str = new ArrayList<>();
        if (fid != null && tid != null) {
            str.add(PlannerProcessor.findWay(fid, tid).toString());
        }
        render(countries, cities, str);
    }


    /**
     * @param fid from city id
     * @param tid to city id
     */
    public static void planJourney(Integer fid, Integer tid) {
        System.out.println(fid + " ; " + tid);
        City cityFrom = City.find("byCityId", fid).first();
        City cityTo = City.find("byCityId", tid).first();

        if (validation.hasErrors()) {
            render("Application/check.html");
        }
        String username = session.get("username");
        if (cityFrom != null && cityTo != null && username != null) {
            flash.success("Hi %s!, Journey plan found from %s to %s", username, cityFrom.getName(), cityTo.getName());
        } else {
            flash.error("username is %s!. \n start city is %s!. \n end city is %s!.", username, cityFrom, cityTo);
        }
        check(fid, tid);
    }


}