package Lab_1;

import java.util.*;

/**
 * @author Weichen Wang
 * @date 2019/1/23 - 11:06 AM
 * @description: ${description} 系列->季->集书 Series->Season->Episodes
 */
// Media provide a title and a running time
public class Series extends Media {

    /**
     * for functional requirements 5: list all the episodes in order(for Season an Series)
     */
    private SortedSet<Season> seasons = new TreeSet<>();

    // default constructor for Media title
    public Series(String title) {
        super(title);
    }

    /**
     * Wrapping the list of season by providing only the access methods we want to allow
     */
    public void addSeason(Season season) {
        this.seasons.add(season);
    }

    /**
     * @return 防止通过调用getEpisodes()并添加内容插入list of episodes，
     * 所以使用 unmodifiableSortedSet return一个不可修改的版本
     * 尝试添加或删除内容都会引发Exception
     * 用受控制的 addEpisode(Episodes) 方法来代替
     */
    public SortedSet<Season> listSeasons() {
        return Collections.unmodifiableSortedSet(seasons);
    }

    /**
     * Recursively computes the running time out of the running times of the
     * episodes.递归计算剧集运行时间的运行时间
     * for each 可以直接调用 listEpisodes()方法
     */
    @Override
    public int getRunningTime() {
        int t = 0;
        for (Season s : listSeasons()) {
            t += s.getRunningTime();
        }
        return t;
    }

    @Override
    public String toString() {
        /**
         * I use {@link StringBuilder} instead of concatenating things to a plain String
         * because it's the recommended way when you have to put together a complex
         * string.
         */
        StringBuilder s = new StringBuilder();
        s.append("=== " + getTitle() + " ===");
        s.append("\n");
        /**
         * Check this out: to print the number of seasons, we don't count our list of
         * seasons, because it may be incomplete! for example, if only seasons 2 and 4
         * are added, counting the seasons would return 2, but if instead we look at the
         * highest season number, we know there should be at least 4! This trick of
         * using Collections.max() works because our seasons are in a SortedSet, so it
         * is possible to find the highest automatically.
         */
        s.append("- total running time: " + getRunningTime() + " min");
        s.append("\n");
        for (Season season : listSeasons()) {
            s.append(seasons);
        }
        return s.toString();
    }
}
