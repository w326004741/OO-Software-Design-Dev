package Lab_1;

/**
 * @author Weichen Wang
 * @date 2019/1/23 - 11:05 AM
 * @description: ${description}
 */
public class Episodes extends Media implements Numbered<Episodes> {
    /**
     * Just defining two integer fields in the same line, not a problem.
     */
    private int runnningTime, number;
    private String seriesTitle;

    /**
     * overloaded constructor, alternate version without an episode title.
     * null as the episode title 对应Override constructor的super(title)
     * 该constructor提供给create不带title的Episodes
     */
    public Episodes(int runnningTime, int number, String seriesTitle) {
        this(null, runnningTime, number, seriesTitle);
    }

    /**
     * 该constructor提供给设置title的Episodes
     */
    public Episodes(String title, int runnningTime, int number, String seriesTitle) {
        super(title);// Necessary because the superclass Media only has a constructor with a String
        this.runnningTime = runnningTime;
        this.number = number;
        this.seriesTitle = seriesTitle;
    }

    /**
     * Necessary for ordering episodes, even when they were added in random order.
     * If this episode's number is greater than the number of the other episode that
     * I'm passing here, the method will return a positive value, or a negative
     * value vice versa, or zero if the episode numbers are the same. This is the
     * expected meaning of the {@link Comparable#compareTo(Object)} method: return a
     * value > 0 if and only if I am the greater element.
     * 目的：当Episode随机添加时，限制当前episodes number > 之前的episode number
     * 即 限制compareTo 返回正值 > 0
     */
    @Override
    public int compareTo(Episodes o) {
        return this.getNumber() - o.getNumber();
    }

    // implement getRunningTime() method from interface RunningTimeInterface
    @Override
    public int getRunningTime() {
        return runnningTime;
    }
    // getter method

    // implement getNumber() method from interface Numbered
    @Override
    public int getNumber() {
        return number;
    }

    /***
     * Encapsulation of seriesTitle
     */
    public String getSeriesTitle() {
        return seriesTitle;
    }

    @Override
    public String toString() {
        /**
         * I use {@link StringBuilder} instead of concatenating things to a plain String
         * because it's the recommended way when you have to put together a complex
         * string.
         */
        StringBuilder s = new StringBuilder();
        s.append("   *");
        s.append(" episode " + getNumber());
        s.append(": " + (hasTitle() ? getTitle() : "[untitled]"));
        s.append(" (" + getRunningTime() + " min)");
        return s.toString();
    }


}
