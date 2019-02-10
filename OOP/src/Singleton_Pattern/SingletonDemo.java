package Singleton_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/10 - 9:04 PM
 * @description: 饿汉式单例模式  EagerSingleton pattern
 */
public class SingletonDemo {

    /**
     * 饿汉式单例模式  EagerSingleton pattern
     * 在类加载时就完成了初始化，所以类加载较慢，但获取对象速度快
     * 该类初始化时，立即在家这个new的对象（没有延时加载的优势）。
     * 加载类时，天然的是线程安全的
     */
    private static SingletonDemo s = new SingletonDemo();

    /**
     * 上来就先创建私有化的构造器
     * <p>
     * 构造函数定义为私有化
     * 作用： 不能在别的类中来获取该类的对象，只能在类自身中得到自己的对象
     */
    private SingletonDemo() {
    }

    /**
     * 静态，方法没有同步，调用效率高 （类加载时已初始化，不会有多线程的问题，所以没有同步synchronized）
     * 所有类 or 对象 只能通过该 public 的方法类获取该类的对象（s），并进行其他操作
     * <p>
     * 公开访问点getInstance() - 不需要同步，因为在类加载时已经初始化完毕，也不需要判断null，直接返回
     */
    public static SingletonDemo getInstance() {
        return s;
    }
}
