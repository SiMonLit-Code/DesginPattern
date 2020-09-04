package com.czz.designpattern.construct.bridge;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-03 16:57:00
 * @description :
 * 桥接（Bridge）模式包含以下主要角色。
 * 1、抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 * 2、扩展抽象化（Refined    Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 3、实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * 4、具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 */
public class Bridge {
    public static void main(String[] args) {
        Implementor impl=new ConcreteImplementor();
        Abstraction abstraction=new ConcreteAbstraction(impl);
        abstraction.operation();
    }
}

/**
 * 实现化角色
 */
interface Implementor{
    void operationImpl();
}

/**
 * 具体实现化角色
 */
class ConcreteImplementor implements Implementor{

    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问" );
    }
}

/**
 *
 * 抽象化角色
 */
abstract class Abstraction{
    protected Implementor imple;
    protected Abstraction(Implementor imple)
    {
        this.imple=imple;
    }
    public abstract void operation();
}

/**
 * 具体抽象化角色
 */
class ConcreteAbstraction extends Abstraction{

    protected ConcreteAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问" );
        imple.operationImpl();
    }
}