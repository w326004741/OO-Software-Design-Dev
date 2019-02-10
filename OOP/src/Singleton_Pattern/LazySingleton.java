package Singleton_Pattern;

/**
 * @author Weichen Wang
 * @date 2019/2/10 - 9:17 PM
 * @description: ${description}
 */
public class LazySingleton {
    /**
     *  Lazy Singleton 懒汉式 单例模式
     *  1. 类加载时，不初始化对象
     *  2. 比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢
     */

    /**
     * 静态static 私有data member，没有初始化
     * 类初始化时，不初始化这个对象（延时加载，等真正用的时候再创建 new ）
     * 关键点 - 类加载快，但访问类的唯一实例慢，static保证在自身类中获取自身对象
     */
    private static LazySingleton instance;

    /**
     * 构造函数私有化
     * 不能在别的类中来获取该类的对象，只能在类自身中得到自己的对象
     */
    private LazySingleton() {
    }


    /**
     * 静态static， 同步synchronized, 公开public 访问点
     * 方法同步，调用效率低
     * 关键点 - public保证对外公开，同步保证多线程时的正确性（因为类变量不是在加载时初始化的）
     * <p>
     * 如果存在 A，B 两个线程访问该public方法，A先访问，如果为空if(instance == null)，则A挂起，
     * 等A挂起结束后,则创建对象(instance = new LazySingleton())。
     * B 只能等待A 完全结束后才能访问该方法
     * <p>
     * synchronized 关键字 表示了 getInstance() 是一个同步方法
     * 依次来保证多线程情况下单例对象的唯一（避免多线程是并发创建多个对象） ，即每次只能访问一个对象
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) { // 如果该对象是第一次调用该方法获得实例，则new对象进行初始化
            instance = new LazySingleton();
        }
        return instance; // 如果不是第一次调用，则instance部位空，则直接返回instance的值
    }

}
