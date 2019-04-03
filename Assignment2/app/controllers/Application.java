package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {

        List<Country> countries = Country.findAll();
        List<City> cities = City.findAll();

        render(countries, cities);
    }

    /**
     * Action method for check.html view template.c
     * check 只处理check页面的内容，和读JSON文件内容无关
     */
//    public static void check() {
//        List<Country> country = Country.findAll();
//        List<City> city = City.findAll();
//
//        render(country, city);
//    }
//
//    // accountId 对应了check.html内的label
//    public static void postCountryAndCity(@Required Long countryId, @Required Long cityId) {
//        Country country = Country.findById(countryId);
//        City city = City.findById(countryId);
//
//        if (validation.hasErrors()) {
//            render("Application/check.html");
//        }
//
//        if (country.cities.containsValue(city)) {
//            flash.success("Yes %s is city id %s", country.name, city.id);
//        } else {
//            flash.error("No %s is not city id %s", country.name, city.id);
//        }
////        check();
//    }


}