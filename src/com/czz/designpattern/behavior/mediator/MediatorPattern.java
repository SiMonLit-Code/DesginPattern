package com.czz.designpattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-09 16:54:00
 * @description :
 * 中介者模式包含以下主要角色。
 * 1、抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 2、具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 3、抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 4、具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        colleague1.send("我的电话号码123456789");

    }
}

/**
 * 抽象中介
 */
abstract class Mediator{
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague, String message);
}

/**
 * 具体中介
 */
class ConcreteMediator extends Mediator{
    //单例中介
    private static ConcreteMediator concreteMediator = new ConcreteMediator();

    private ConcreteMediator(){}

    public static ConcreteMediator getInstance(){
        if (concreteMediator == null) {
            concreteMediator = new ConcreteMediator();
        }
        return concreteMediator;
    }

    private static List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void relay(Colleague colleague,String message) {
        colleagues.stream().filter(x -> {
            if (!colleague.equals(x))
                return true;
            return false;
        }).forEach(x -> x.receive(colleague.toString()+"--"+message));
    }
}

/**
 * 抽象同事类
 */
interface Colleague {
    void receive(String message);
    void send(String message);
}

/**
 * 具体同事类1
 */
class ConcreteColleague1 implements Colleague{
    private Mediator mediator = ConcreteMediator.getInstance();

    public ConcreteColleague1() {
        //向中介注册
        mediator.register(this);
    }

    @Override
    public void receive(String message) {
        //收到中介消息
        System.out.println("收到"+message);
    }

    @Override
    public void send(String message) {
        //向中介发送消息
        mediator.relay(this,message);
    }
}
/**
 * 具体同事类2
 */
class ConcreteColleague2 implements Colleague{
    private Mediator mediator = ConcreteMediator.getInstance();

    public ConcreteColleague2() {
        //向中介注册
        mediator.register(this);
    }

    @Override
    public void receive(String message) {
        //收到中介消息
        System.out.println("收到"+message);
    }

    @Override
    public void send(String message) {
        //向中介发送消息
        mediator.relay(this,message);
    }
}