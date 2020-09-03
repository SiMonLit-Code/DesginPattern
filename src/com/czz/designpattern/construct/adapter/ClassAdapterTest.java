package com.czz.designpattern.construct.adapter;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 17:52:00
 * @description :
 *  模式的结构
 * 适配器模式（Adapter）包含以下主要角色。
 * 1、目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * 2、适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * 3、适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *
 */
public class ClassAdapterTest {

    public static void main(String[] args) {
        //1、类适配，用的比较少
        Target target1=new ClassAdapter1();
        target1.request();
        //2、对象适配
        Target target2 = new ClassAdapter2();
        target2.request();
    }
}

/**
 * 适配器类,或者对象
 */
class ClassAdapter1 extends Adaptee implements Target {
    @Override
    public void request() {
        //适配方法
        specificRequest();
    }
}
//对象
class ClassAdapter2  implements Target {
    Adaptee adaptee=new Adaptee();
    @Override
    public void request() {
        //适配方法
        adaptee.specificRequest();
    }
}




/**
 * 适配者接口
 */
class Adaptee{
    public void specificRequest(){
        System.out.println("设配器正在调用");
    }
}

/**
 * 目标接口
 */
interface Target{
    //适配的方法
    void request();
}
