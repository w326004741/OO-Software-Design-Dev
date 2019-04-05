package models;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:50 PM
 * @description: 抽象类父类提供抽象方法给子类实现Plan Journey
 */
public abstract class GetWay {
    public abstract StringBuffer appenWay(City cfrom, City cto, StringBuffer str);
}
