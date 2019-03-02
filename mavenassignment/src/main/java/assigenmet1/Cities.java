package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 12:17 PM
 * @description: 从内到外 先定义JSON对象内的内部对象数组 即 cities
 */
public class Cities {
    private int id;
    private String name;

    // Default Constructor
    public Cities() {
        this.id = id;
        this.name = name;
    }

    // Override Constructor
    public Cities(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Cities{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
