package assigenmet1;

import java.util.Arrays;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 12:17 PM
 * @description: 从内到外 先定义JSON对象内的内部对象数组 即 cities
 * <p>
 * City 要 引用 population 类来判断 equal() & hashcode()
 * 非功能性要求：
 * 1. 一个国家的人口必须 大于或等于 其他城市的总人口
 * 2. 旅行计划必须优先考虑距离最短的的计划
 * 3. 如果有许多可能的计划都具有同样的距离，则计划更喜欢包括有坐飞机的计划(如果有的话)
 * 4. 持久性：国家的城市和首都都应该从JSON文件中读取
 */
public class City {
    private int id;
    private String name;
    private int population;

    // Default Constructor
    public City() {
        this.id = 0;
        this.name = "";
        this.population = 0;
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override Constructor
    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        City c = (City) o;
        return this.getPopulation() == c.getPopulation() && this.getName().equals(c.getName());
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        City cities = (City) o;
//
//        if (id != cities.id) return false;
//        return name != null ? name.equals(cities.name) : cities.name == null;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.getName(), this.getPopulation()});

    }

    // getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + '}';
    }
}
