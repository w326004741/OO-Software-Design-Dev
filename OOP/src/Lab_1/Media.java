package Lab_1;

/**
 * @author Weichen Wang
 * @date 2019/2/6 - 10:41 AM
 * @description: ${description}
 */
// 抽象类Media提供了共用的title变量，给子类继承调用getTitle方法，并提供构造方法
// 还实现了RunningTimeInterface，Override接口内的方法getRunningTime,并设为abstract method 给子类实现方法内容
// Add a hasTitle()方法提供判断条件，判断子类是否存在title. return true or false

public abstract class Media implements RunningTimeInterface {

    private String title;

    public Media(String title) {
        this.title = title;
    }

    @Override
    public abstract int getRunningTime();

    // getter for title
    public String getTitle() {
        return title;
    }

    /**
     * @return true if and only if the title is not null
     * check if there is a title
     */
    public boolean hasTitle() {
        return title != null;
    }
}
