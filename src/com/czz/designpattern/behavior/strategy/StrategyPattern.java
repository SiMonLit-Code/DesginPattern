package com.czz.designpattern.behavior.strategy;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 14:01:00
 * @description :
 * 模式的结构
 * 策略模式的主要角色如下。
 * 1、抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * 2、具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
 * 3、环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 *
 * 在一个使用策略模式的系统中，当存在的策略很多时，客户端管理所有策略算法将变得很复杂，
 * 如果在环境类中使用策略工厂模式来管理这些策略类将大大减少客户端的工作复杂度
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Content content=new Content();

        Strategy A = new ConcreteStrategyA();
        content.setStrategy(A);
        content.operator();
        System.out.println("-------");
        Strategy B=new ConcreteStrategyB();
        content.setStrategy(B);
        content.operator();
    }
}

/**
 * 抽象策略类
 */
interface Strategy{
    public void strategy();
}

/**
 * 具体策略方法
 */
class ConcreteStrategyA implements Strategy{

    @Override
    public void strategy() {
        System.out.println("策略方法A");
    }
}
class ConcreteStrategyB implements Strategy{

    @Override
    public void strategy() {
        System.out.println("策略方法B");
    }
}

/**
 * 环境类，客户端执行环境
 */
class Content{
    Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //执行策略方法
    void operator(){
        strategy.strategy();
    }
}