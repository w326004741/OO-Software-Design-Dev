package assigenmet1;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Weichen Wang
 * @date 2019/2/11 - 3:44 PM
 * @description: ${description}
 */
public class TestCountriesFromJson {
    //  Class called Class 类自己调用自己并初始化 new 对象
    static TestCountriesFromJson main = new TestCountriesFromJson();

    public static void main(String[] args) {
        InputStream input = main.getClass().getResourceAsStream("/data.json");
        // JSONTokener：用来读取JSON格式的文件;构造函数传入inputStream or Reader or String
        JSONTokener parser = new JSONTokener(input);

        // JSONObject:就是一个JSON对象，各种getXXX()和put()方法，用的最多的类
        JSONObject data = new JSONObject(parser);
        // 测试JSONObject内是否存在countries
//        data.has("countries");
        if (data.has("countries")) {
            // JSONArray is class, type is ArrayListObject
            // countriesArray通过JSONObject的getJSONArray()方法得到countries数组
            JSONArray countriesArray = data.getJSONArray("countries");
            for (int i = 0; i < countriesArray.length(); i++) {
                // name接受countriesArray内JSONObject的String值（拿到所有countries数组中的name字段）
                String name = countriesArray.getJSONObject(i).getString("name");
                Countries countries = new Countries(name); // 把获取的JSON文件内容(name)给到countries
                System.out.print("===>" + countries.getName() + "\t\t");// get JSON文件中所有countries的name

                int capital = countriesArray.getJSONObject(i).getInt("capital");
                System.out.println(capital + "(Capital No)");
                // 数组内容就要用数组类型接受 JSONArray
                // 拿到JSON数组内的所有cities数组内容给city对象
                JSONArray city = countriesArray.getJSONObject(i).getJSONArray("cities");
                System.out.println(city);
            }
        }
        if (data.has("bordering")) {
            JSONObject bordering = data.getJSONObject("bordering");
            System.out.println("\n" + bordering);
        }


        Map<String, Countries> countriesMap = new HashMap<String, Countries>();

        Countries c1 = new Countries("Ireland", 1, 101);
        countriesMap.put("Ireland", c1);
        if (countriesMap.containsKey("Ireland")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        Countries c = countriesMap.get("Ireland");
        System.out.println(c.getName());
    }
}
