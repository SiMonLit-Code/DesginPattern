package com.czz.designpattern.create.builder;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 16:36:00
 * @description :
 *
 * 建造者（Builder）模式的主要角色如下。
 * 1、产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 * 2、抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 3、具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 4、指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 *
 * 建造者（Builder）模式在应用过程中可以根据需要改变，如果创建的产品种类只有一种，只需要一个具体建造者，这时可以省略掉抽象建造者，甚至可以省略掉指挥者角色。
 */
public abstract class Builder {
    protected Product product=new Product();
    public abstract void partA();
    public abstract void partB();
    public abstract void partC();
    public Product getProduct(){
        return this.product;
    }
}
