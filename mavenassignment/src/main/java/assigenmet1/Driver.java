package assigenmet1;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import sun.lwawt.macosx.CImage;
import sun.tools.tree.NewArrayExpression;

import java.io.InputStream;
import java.util.*;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: ${description}
 */
public class Driver {
    //  Class called Class 类自己调用自己并初始化 new 对象
    static Driver main = new Driver();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**获取InputStream，拿到JSON文件*/
        InputStream input = main.getClass().getResourceAsStream("/data.json");
        /**JSONTokener 解析JSON文件*/
        JSONTokener parser = new JSONTokener(input);
        /**JSONObject接受解析文件内容，存入JSONObject data*/
        JSONObject data = new JSONObject(parser);

        /** List all the countries
         * JSONArray get对象内的数组 countriesArray 可以用foreach() 遍历输出
         * JSONArray的类型为Object 可以查看源代码
         * 首先一般json对象是不保证顺序的  底层选择的map类型问题(LinkedHashMap有序)*/
        JSONArray countriesArray = data.getJSONArray("countries");

        System.out.println("List all the countries:");
        for (Object countries : countriesArray) {
            System.out.println(countries);
        }

        int cityId = 0;
        String cityName = null;
        int population = 0;

        int countriesId = 0;
        String countriesName = null;
        int capital = 0;
        JSONArray bordering;


        /**用countriesArray遍历得到每个国家的内容(id,name,capital)*/
        System.out.println("\n**********************List all the City & Capital in a country**********************");
//        int userInput = sc.nextInt();
//        sc.nextLine();
        for (int i = 0; i < countriesArray.length(); i++) {
            countriesId = countriesArray.getJSONObject(i).getInt("id");
            countriesName = countriesArray.getJSONObject(i).getString("name");
            capital = countriesArray.getJSONObject(i).getInt("capital");
            int countriesPopulation = 0; // country population 一定要是private local variable,如果是global variable,则会一直叠加
//            bordering = countriesArray.getJSONObject(i).getJSONArray("bordering");
//            System.out.println("Country ID = " + (i + 1) + ", Country Name = " + countriesName + ", Country Capital = " + capital);

            /** Get cityArray using JSONArray, 遍历cityArray得到每个城市的内容(id,name)
             * 初始化并实例化Capital, Set CapitalID & CapitalName,输出该国家的Capital*/
            JSONArray cityArray = countriesArray.getJSONObject(i).getJSONArray("cities");
            City cities = null;
            for (int j = 0; j < cityArray.length(); j++) {
                cityId = cityArray.getJSONObject(j).getInt("id");
                cityName = cityArray.getJSONObject(j).getString("name");
                population = cityArray.getJSONObject(j).getInt("population");
                /**把JSON内的cityArray的数据结果全部存入Map*/
                Map<String, City> cityByName = new HashMap<String, City>();
                cities = new City(cityId, cityName, population);
                cityByName.put(cityName, cities); // cityName = Key, city = Value 通过Key->Value
                /**把Map集合变成Set集合,用Iterator迭代输出*/
                Set<Map.Entry<String, City>> setCity = cityByName.entrySet();
                Iterator<Map.Entry<String, City>> iter = setCity.iterator();
//                System.out.println("City By Name Map:");
                while (iter.hasNext()) {
                    Map.Entry<String, City> me = iter.next();
                    System.out.println(me.getKey() + " = " + me.getValue().getId() + "\t(Key=Value.getId)");
                    System.out.println(me.getKey() + " = " + me.getValue().getName() + "\t(Key=Value.getName)");
                    System.out.println(me.getKey() + " = " + me.getValue().getPopulation() + "\t(Key=Value.getPopulation)");
//                    System.out.println();// 每个城市内容输出后的空行
                }
                countriesPopulation += population;
            }
//                Capital c = new Capital(); // Initialization Capital to set CapitalId & CapitalName
//                c.setCapitalId(cityArray.getJSONObject(0).getInt("id"));
//                c.setCapitalName(cityArray.getJSONObject(0).getString("name"));
//                System.out.println(c.toString());
            /**把JSON内的countriesArray的数据结果全部存入Map*/
            Map<City, Country> countriesPerCity = new HashMap<City, Country>();
            Country country = new Country(countriesId, countriesName, capital, countriesPopulation);
            countriesPerCity.put(cities, country);
            /**把Map集合变成Set集合,用Iterator迭代输出*/
            Set<Map.Entry<City, Country>> setCountry = countriesPerCity.entrySet();
            Iterator<Map.Entry<City, Country>> iter1 = setCountry.iterator();
//            System.out.println("Country Per City: ");
            while (iter1.hasNext()) {
                Map.Entry<City, Country> me1 = iter1.next();
//                System.out.println(me1.getKey() + " = " + me1.getValue().getId() + "\t(Key=Value.getId)");
//                System.out.println(me1.getKey() + " = " + me1.getValue().getName() + "\t(Key=Value.getName)");
                System.out.println(me1.getKey() + " = " + me1.getValue().getCapital() + "\t(Key=Value.getCapital)");
                System.out.println(me1.getKey() + " = " + me1.getValue().getCountryPopulation() + "\t(Key=Value.getCountryPopulation)");
            }
            System.out.println();
        }
        System.out.println("=================== 输出 borderingObject 结果===================");
        JSONObject borderingObject = data.getJSONObject("bordering");
        JSONArray borderingArray = data.getJSONObject("bordering").getJSONArray("1");
        System.out.println(borderingObject);
        System.out.println("1 : " + borderingArray);
        System.out.println();

        /**===========================分割线，以上都是JSONArray================================================*/
    }
}
////        Country countries1 = new Country(1, "Ireland", , c1);
//        JourneyLeg journeyLeg = new JourneyLeg(new ByBus());
//        journeyLeg.travel(c2, c1);
//        System.out.println();


//        Map<City, Country> countriesPerCity = new HashMap<City, Country>();
//        Country country = new Country(countriesId, countriesName);
//        Set<Map.Entry<City, Country>> setCountry = countriesPerCity.entrySet();
//        Iterator<Map.Entry<City, Country>> iter1 = setCountry.iterator();
//        while (iter1.hasNext()) {
//            Map.Entry<City, Country> me1 = iter1.next();
//            System.out.println(me1.getKey() + " = " + me1.getValue().getId() + "\tKey=Value.getId");
//            System.out.println(me1.getKey() + " = " + me1.getValue().getName() + "\tKey=Value.getName");
//            System.out.println(me1.getKey() + " = " + me1.getValue().getCapital() + "\tKey=Value.getCapital");
//            System.out.println(me1.getKey() + " = " + me1.getValue().getCity() + "\tKey=Value.getCity");
//            System.out.println();
//        }


//        /**Create a Map<>*/
//        Map<String, Country> countriesMap = new HashMap<String, Country>();
//
//        /**I can still use proper capitalisation in the title! */
//        Country c1 = new Country("Ireland", 1, 101);
//        Country c2 = new Country("United Kingdom", 2, 201);
//        Country c3 = new Country("United States", 3, 301);
//        /*
//         *  But for the key, I can just use lowercase to make it easier on the user
//         * 但是对于密钥，我可以使用小写来使用户更容易*/
//        countriesMap.put("ireland", c1);
//        countriesMap.put("united kingdom", c2);
//        countriesMap.put("united states", c3);
//
//
////        Set<String> set = countriesMap.keySet(); // 取得全部的Key
////        Iterator<String> iter = set.iterator();
////        while (iter.hasNext()) {
////            System.out.println(iter.next());
////        }
//        // 把Map集合变成Set集合
//        Set<Map.Entry<String, Country>> set = countriesMap.entrySet();
//        Iterator<Map.Entry<String, Country>> iter = set.iterator();
//        while (iter.hasNext()) {
//            Map.Entry<String, Country> me = iter.next();
//            // getCities() 数组为null
//            System.out.println(me.getKey() + " = " + me.getValue().getCities());
//            // 下面的get方法都是上面创建对象直接给的值，和json文件没有关系(怎么才能直接引用json文件内容全部put到Map)
//            System.out.println(me.getKey() + " = " + me.getValue().getId() + " \tKey=Value.getId");
//            System.out.println(me.getKey() + " = " + me.getValue().getName() + " \tKey=Value.getName");
//            System.out.println(me.getKey() + " = " + me.getValue().getCapital() + " \tKey=Value.getCapital");
//        }
//
////        countriesMap.putAll();
////        if (countriesMap.containsKey("ireland")) {
////            System.out.println(true);
////        } else {
////            System.out.println(false);
////        }
////
////        Country c = countriesMap.get("ireland");
////        System.out.println(c.getName());

//        /***
//         *   能不能用一个循环（for） 一次性导入所有的data.json内容
//         */
//    }

//    public static void JSONArray() {
//        /**获取InputStream，拿到JSON文件*/
//        InputStream input = main.getClass().getResourceAsStream("/data.json");
//        /**JSONTokener 解析JSON文件*/
//        JSONTokener parser = new JSONTokener(input);
//        /**JSONObject接受解析文件内容，存入JSONObject data*/
//        JSONObject data = new JSONObject(parser);
//
//        /** List all the countries
//         * JSONArray get对象内的数组 countriesArray 可以用foreach() 遍历输出
//         * JSONArray的类型为Object 可以查看源代码
//         * 首先一般json对象是不保证顺序的  底层选择的map类型问题(LinkedHashMap有序)*/
//        JSONArray countriesArray = data.getJSONArray("countries");
//
//        System.out.println("List all the countries:");
//        for (Object countries : countriesArray) {
//            System.out.println(countries);
//        }
//
//        int cityId = 0;
//        String cityName = null;
//        int population = 0;
//
//
//        int countriesId = 0;
//        String countriesName = null;
//        int capital = 0;
//        JSONArray bordering;
//
//        /**用countriesArray遍历得到每个国家的内容(id,name,capital)*/
//        System.out.println("\nList all the City & Capital in a country: ");
//        for (int i = 0; i < countriesArray.length(); i++) {
//            countriesId = countriesArray.getJSONObject(i).getInt("id");
//            countriesName = countriesArray.getJSONObject(i).getString("name");
//            capital = countriesArray.getJSONObject(i).getInt("capital");
////            bordering = countriesArray.getJSONObject(i).getJSONArray("bordering");
//            System.out.println("Country ID = " + (i + 1) + ", Country Name = " + countriesName + ", Country Capital = " + capital);
//
//            /** Get cityArray using JSONArray, 遍历cityArray得到每个城市的内容(id,name)
//             * 初始化并实例化Capital, Set CapitalID & CapitalName,输出该国家的Capital*/
//            JSONArray cityArray = countriesArray.getJSONObject(i).getJSONArray("cities");
//            for (int j = 0; j < cityArray.length(); j++) {
//                cityId = cityArray.getJSONObject(j).getInt("id");
//                cityName = cityArray.getJSONObject(j).getString("name");
//                population = cityArray.getJSONObject(j).getInt("population");
//
//                City cities = new City(cityId, cityName, population);
//                System.out.print(cities.toString() + ", ");
//
//                Capital c = new Capital(); // Initialization Capital to set CapitalId & CapitalName
//                c.setCapitalId(cityArray.getJSONObject(0).getInt("id"));
//                c.setCapitalName(cityArray.getJSONObject(0).getString("name"));
//                System.out.println(c.toString());
//
//            }
//            System.out.println();
//        }
//        System.out.println("=================== 输出 borderingObject 结果===================");
//        JSONObject borderingObject = data.getJSONObject("bordering");
//        JSONArray borderingArray = data.getJSONObject("bordering").getJSONArray("1");
//        System.out.println(borderingObject);
//        System.out.println("1 : " + borderingArray);
//        System.out.println();
//
//
//    }