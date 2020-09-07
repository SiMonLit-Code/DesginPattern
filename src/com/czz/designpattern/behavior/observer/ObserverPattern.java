package com.czz.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 17:29:00
 * @description :
 *  模式的结构
 * 观察者模式的主要角色如下。
 * 1、抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 * 2、具体主题（Concrete    Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * 3、抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
 * 4、具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Observer o1 = new ConcreteObserverA();
        Observer o2 = new ConcreteObserverB();
        Subject subject = new ConcreteSubject();
        subject.add(o1);
        subject.add(o2);
        subject.notifyObserver();
    }
}

/**
 * 抽象主题
 */
abstract class Subject{
    protected List<Observer> observers = new ArrayList<>();

    //添加观察者方法
    public void add(Observer observer){
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer){
        observers.remove(observer);
    }

    //通知观察者方法
    public abstract void notifyObserver();

}

/**
 * 具体抽象方法
 */
class ConcreteSubject extends Subject{

    @Override
    public void notifyObserver(){
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        observers.stream().forEach(x -> {
            x.response(2);
        });
    }
}

/**
 * 抽象观察者
 */
interface Observer{
    void response(int money);
}

/**
 * 具体观察者
 */
class ConcreteObserverA implements Observer{

    @Override
    public void response(int money) {
        if (money > 0){
            System.out.println("A通知：大于零");
        }else {
            System.out.println("A通知：小于零");
        }

    }
}

class ConcreteObserverB implements Observer{

    @Override
    public void response(int money) {
        if (money > 0){
            System.out.println("B通知：大于零");
        }else {
            System.out.println("B通知：小于零");
        }
    }
}
