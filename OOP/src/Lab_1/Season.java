package Lab_1;

import java.util.*;

/**
 * @author Weichen Wang
 * @date 2019/1/23 - 11:06 AM
 * @description: ${description}
 */
public class Season implements RunningTimeInterface, Numbered<Season> {
    /**
     * SortedSet<> is a special set that maintains its elements in a natural order
     * TreeSet is the primary implementation of SortedSet. like List<> l = new ArrayList<>();
     * For episodes, the criterion for ordering is specified by the method compareTo(Episodes) in Episode class
     * 对于episodes, 排序标准由compareTo(Episodes)指定
     * TreeSet:无重复数据，自动排序(所保存内容)。主要依赖Comparable接口中的compareTo()方法判断是否是重复数据。如果是0，则认为是重复数据，不会被保存(输出)
     **/
    private SortedSet<Episodes> episodes = new TreeSet<>(); // for functional requirements 5: list all the episodes in order(for Season an Series)
    private int number;

    /**
     * When a season is created, it's empty. The episodes will be added later via
     * calls to addEpisode(). Alternatively, you can pass the collection of episodes
     * to an overloaded version of this constructor - you would have to define
     * public Season(int number, Collection<Episode> episodes) - note that I use
     * Collection, not bothering whether it's a set, a sorted set or a list: thanks
     * to Polymorphism I need not care!
     */
    public Season(int number) {
        this.number = number;
    }

    // Wrapping the list of episodes by providing only the access methods we want to allow
    public void addEpisode(Episodes episodes) {
        this.episodes.add(episodes); // call SortSet内的add()方法 添加Episode
    }

    /**
     * @return 防止通过调用getEpisodes()并添加内容插入list of episodes，
     * 所以使用 unmodifiableSortedSet return一个不可修改的版本
     * 尝试添加或删除内容都会引发Exception
     * 用受控制的 addEpisode(Episodes) 方法来代替
     */
    public SortedSet<Episodes> listEpisodes() {
        return Collections.unmodifiableSortedSet(episodes);
    }

    /**
     * Necessary for ordering seasons, even when they were added in random order.
     * If this season's number is greater than the number of the other seasons that
     * I'm passing here, the method will return a positive value, or a negative
     * value vice versa, or zero if the season numbers are the same. This is the
     * expected meaning of the {@link Comparable#compareTo(Object)} method: return a
     * value > 0 if and only if I am the greater element.
     */
    @Override
    public int compareTo(Season o) {
        return this.getNumber() - o.getNumber();
    }

    // Encapsulation of episode number
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Recursively computes the running time out of the running times of the
     * episodes.递归计算剧集运行时间的运行时间
     * for each 可以直接调用 listEpisodes()方法
     */
    @Override
    public int getRunningTime() {
        int t = 0;
        /** for each 可以直接调用 listEpisodes()方法*/
        for (Episodes e : listEpisodes()) {
            t += e.getRunningTime();
        }
        return t;
    }

    /**
     * Nice way to get a String representation of a season. Note that it depends
     * upon the string representation of the episodes, where it does "s.append(ep)".
     */
    @Override
    public String toString() {
        /**
         * I use {@link StringBuilder} instead of concatenating things to a plain String
         * because it's the recommended way when you have to put together a complex
         * string.
         */
        StringBuilder s = new StringBuilder();
        s.append(" Season #" + getNumber());
        s.append("\n");
        /**
         * Check this out: to print the number of episodes, we don't count our list of
         * episodes, because it may be incomplete! for example, if only episodes 2 and 4
         * are added, counting the episodes would return 2, but if instead we look at
         * the highest episode number, we know there should be at least 4! This trick of
         * using Collections.max() works because our episodes are in a SortedSet, so it
         * is possible to find the highest automatically
         * Collections.max(): 在SortedSet中，自动找到最大的元素.
         */
        s.append(" - episodes: at least " + Collections.max(listEpisodes()).getNumber());
        s.append("\n");
        s.append(" - total running time: " + getRunningTime() + " min");
        s.append("\n");
        for (Episodes ep : listEpisodes()) {
            s.append(ep);
            s.append("\n");
        }
        return s.toString();
    }
}
