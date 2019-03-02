package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/3/2 - 3:14 PM
 * @description: ${description}
 */
public class Capital {
    private int capitalId;
    private String capitalName;

    public Capital() {
        this.capitalId = 0;
        this.capitalName = "";
    }

    public Capital(int capitalId, String capitalName) {
        this.capitalId = capitalId;
        this.capitalName = capitalName;
    }

    public int getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(int capitalId) {
        this.capitalId = capitalId;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "capitalId=" + capitalId +
                ", capitalName='" + capitalName + '\'' +
                '}';
    }
}
