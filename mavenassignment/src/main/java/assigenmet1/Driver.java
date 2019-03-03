package assigenmet1;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: ${description}
 */
public class Driver {
    //  Class called Class 类自己调用自己并初始化 new 对象
    static Driver main = new Driver();

    public static void JSONArray() {
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

        int countriesId = 0;
        String countriesName = null;
        int capital = 0;

        /**用countriesArray遍历得到每个国家的内容(id,name,capital)*/
        System.out.println("\nList all the Cities & Capital in a country: ");
        for (int i = 0; i < countriesArray.length(); i++) {
            countriesId = countriesArray.getJSONObject(i).getInt("id");
            countriesName = countriesArray.getJSONObject(i).getString("name");
            capital = countriesArray.getJSONObject(i).getInt("capital");
            System.out.println("Country ID = " + (i + 1) + ", Country Name = " + countriesName + ", Country Capital = " + capital);

            /** Get cityArray using JSONArray, 遍历cityArray得到每个城市的内容(id,name)
             * 初始化并实例化Capital, Set CapitalID & CapitalName,输出该国家的Capital*/
            JSONArray cityArray = countriesArray.getJSONObject(i).getJSONArray("cities");
            for (int j = 0; j < cityArray.length(); j++) {
                cityId = cityArray.getJSONObject(j).getInt("id");
                cityName = cityArray.getJSONObject(j).getString("name");
                Cities cities = new Cities(cityId, cityName);
                System.out.print(cities.toString() + ", ");

                Capital c = new Capital(); // Initialization Capital to set CapitalId & CapitalName
                c.setCapitalId(cityArray.getJSONObject(0).getInt("id"));
                c.setCapitalName(cityArray.getJSONObject(0).getString("name"));
                System.out.println(c.toString());

            }
            System.out.println();
        }
        System.out.println("=================== 输出 borderingObject 结果===================");
        JSONObject borderingObject = data.getJSONObject("bordering");
        JSONArray borderingArray = data.getJSONObject("bordering").getJSONArray("1");
        System.out.println(borderingObject);
        System.out.println("1 : " + borderingArray);
        System.out.println();
    }

    public static void main(String[] args) {
        JSONArray();

        Countries countries1 = new Countries(1, "Ireland");
        Countries countries2 = new Countries(1, "Ireland");
        Cities c1 = new Cities(101, "Dublin");
        Cities c2 = new Cities(102, "Galway");

//        JourneyLeg journeyLeg = new JourneyLeg(new ByBus());
//        journeyLeg.travel(c2, c1);
//        System.out.println();

        JourneyLeg journeyLeg1 = new JourneyLeg();
        journeyLeg1.compareCountry(countries1, countries2, c1, c2);
    }
}

//        /**Create a Map<>*/
//        Map<String, Countries> countriesMap = new HashMap<String, Countries>();
//
//        /**I can still use proper capitalisation in the title! */
//        Countries c1 = new Countries("Ireland", 1, 101);
//        Countries c2 = new Countries("United Kingdom", 2, 201);
//        Countries c3 = new Countries("United States", 3, 301);
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
//        Set<Map.Entry<String, Countries>> set = countriesMap.entrySet();
//        Iterator<Map.Entry<String, Countries>> iter = set.iterator();
//        while (iter.hasNext()) {
//            Map.Entry<String, Countries> me = iter.next();
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
////        Countries c = countriesMap.get("ireland");
////        System.out.println(c.getName());

//        /***
//         *   能不能用一个循环（for） 一次性导入所有的data.json内容
//         */
//    }

