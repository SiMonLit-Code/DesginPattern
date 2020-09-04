package com.czz.designpattern.behavior.templatemethod;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 11:46:00
 * @description :
 *
 * 抽象类（Abstract Class）：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。这些方法的定义如下。
 *
 * ① 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。
 *
 * ② 基本方法：是整个算法中的一个步骤，包含以下几种类型。
 * 1、抽象方法：在抽象类中申明，由具体子类实现。
 * 2、具体方法：在抽象类中已经实现，在具体子类中可以继承或重写它。
 * 3、钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。
 */
public class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass abstractClass=new ConcreteClass();
        abstractClass.TemplateMethod();
    }

}

/**
 * 抽象类
 */
abstract class AbstractClass{
    //抽象方法1
    public abstract void abstractMethod1();
    //抽象方法2
    public abstract void abstractMethod2();
    //具体方法
    public void specificMethod(){
        System.out.println("抽象类的具体方法");
    }

    //钩子方法
    public boolean hookMethod(){
        return true;
    }

    //模板方法
    public void TemplateMethod(){
        if (hookMethod()){
            specificMethod();
        }
        abstractMethod1();
        abstractMethod2();
    }
}

/**
 * 实现抽象类中抽象方法
 */
class ConcreteClass extends AbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("实现抽象方法1");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("实现抽象方法2");
    }

    //重写父类钩子函数，控制方法
    @Override
    public boolean hookMethod() {
        return false;
    }
}


