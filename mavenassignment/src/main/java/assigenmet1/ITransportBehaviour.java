package assigenmet1;

/**
 * @author Weichen Wang
 * @date 2019/2/25 - 2:26 PM
 * @description: ITransportBehaviour interface is a behaviour interface 行为接口，下面实现了3个子类（Train, Bus, Plane）,每个子类都重写了自己的方法
 * JourneyLeg class 在内部声明Transport 为接口类型，这样JourneyLeg 类就可以通过 调用（实例化）ITransportBehaviour 来动态调用他的每一个子类（子类的内部方法）
 * <p>
 * <p>
 * behavior
 */
public interface ITransportBehaviour {

    public void transportChoice(Cities c1, Cities c2);

}
