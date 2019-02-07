package Lab_1;

import java.util.*;

/**
 * @author Weichen Wang
 * @date 2019/1/28 - 4:18 PM
 * @description: ${description} 系列->季->集书 Series->Season->Episodes
 */
public class MediaCatalog {
    /**
     * Reference its only instance. Part of the Singleton design pattern.
     * 引用该类存在的唯一的实例
     */
    private static MediaCatalog me;

    /**
     * The constructor is made Private, so we prevent anyone from creating other catalogs.
     * part of the Singleton design pattern
     * 目的： 让constructor private,这样该类就不会被实例化（No new MediaCatalog）
     */
    private MediaCatalog() {
    }

    /**
     * Encapsulation of 'me'. part of the Singleton design pattern
     * 如果 Object me 为 null(即不存在) 则 new MediaCatalog()。创建一个新的对象(开辟新的空间)
     * 如果存在，则return 该对象
     * 目的： 获取唯一可用的对象
     * 懒汉式 Lazy initialization lazy 初始化。 全局的单例实例在第一次被使用时构建
     */
    public static MediaCatalog getInstance() {
        if (me == null) {
            me = new MediaCatalog();
        }
        return me;
    }

    public static void main(String[] args) {

        // 获取唯一可用的对象. 不能new Object，因为constructor private,不能在外部类实例化该类对象
        MediaCatalog cat = MediaCatalog.getInstance();
        /**
         * Take a note of this: I define only one variable of each type and reuse it
         * over and over again for the next season, series or series title. That is
         * perfectly legal because the previous series/seasons etc. are not lost by just
         * replacing the variable: they were securely put away the moment I called
         * addSeason and addSeries !
         */
        String seriesTitle = "Black Mirror";
        Series series = new Series(seriesTitle); // Series Title: Black Mirror
        Season season = new Season(1); // Season 1
        season.addEpisode(new Episodes("The National Anthem", 1, 22, seriesTitle));
        // Adding an untitled episode, using the other constructor 创建没有title的Episode
        season.addEpisode(new Episodes(2, 32, seriesTitle));
        season.addEpisode(new Episodes("The Entire History of You", 3, 62, seriesTitle));
        series.addSeason(season); // 添加Season到series内 (SetSorted<Season>)
        cat.addSeries(series); // having built the series, add it to the catalog(目录)


        seriesTitle = "Kojak";
        series = new Series(seriesTitle); // Series Title: Kojak
        // Adding seasons in random order and skipping some seasons
        season = new Season(4);
        // Adding episodes in random order and skipping some episode
        season.addEpisode(new Episodes("A Summer Madness", 2, 32, seriesTitle));
        season.addEpisode(new Episodes("Birthday Party", 1, 22, seriesTitle));
        // test the Set<>,HashSet<> it will not be repeated twice 验证无重复输出
        season.addEpisode(new Episodes("Birthday Party", 1, 22, seriesTitle));
        season.addEpisode(new Episodes("A Hair-Trigger Away", 7, 9, seriesTitle));
        series.addSeason(season);

        season = new Season(2);
        season.addEpisode(new Episodes("Slay Ride", 6, 12, seriesTitle));
        // Adding an untitled episode, using the other constructor 创建没有title的Episode
        season.addEpisode(new Episodes(1, 15, seriesTitle));
        series.addSeason(season);
        // having built the series, add it to the catalog(目录)
        cat.addSeries(series);
        /**
         * Now just print the series one by one and watch the magic unfold:
         * - Seasons and episodes come up in the right order despite being added randomly(Season and episodes是自动排序(TreeSet),就算随即添加)
         * - Repeatedly added episodes show only once 无重复输出，重复添加的Episode仅输出一次
         * - Total running times are consistent 总运行时间一致
         * - Untitled episodes do not cause errors 无标题的episode不会报错
         * - Missing seasons or episodes do not cause errors 缺少seasons or episodes不会报错
         */
        for (Series s : cat.listSeries()) {
            System.out.println(s);
        }

    }

    /**
     * Set<>()的子接口： HashSet(无序且无重复输出), TreeSet(无重复输出，自动排序(所保存内容))
     * HashSet<>(): 无序且无重复输出
     */
    private Set<Series> series = new HashSet<>();

    /**
     * Set内自带 add() method
     * series.add()
     */
    public void addSeries(Series series) {
        this.series.add(series);
    }

    /**
     * @return 防止通过调用addSeries()并添加内容插入list of Series，
     * 所以使用 unmodifiableSet return一个不可修改的版本
     * 尝试添加或删除内容都会引发Exception
     * 用受控制的 addSeries(Series) 方法来代替
     */
    public Set<Series> listSeries() {
        return Collections.unmodifiableSet(series);
    }

}
