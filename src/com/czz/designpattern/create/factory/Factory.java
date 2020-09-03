package com.czz.designpattern.create.factory;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 15:04:00
 * @description :
 * 一、工厂方法模式的主要优点有：
 * 1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
 * 2、在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
 *
 * 二、工厂方法模式由抽象工厂、具体工厂、抽象产品和具体产品等4个要素构成。本节来分析其基本结构和实现方法。
 *  模式的结构
 * 1、工厂方法模式的主要角色如下。
 * 2、抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 3、具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 4、抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 5、具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * 对于简单的生产过程，可以省略抽象工厂
 */
public class Factory {
    public static void main(String[] args) {
        AbstractFactory af=new ProductFactory();
        Product product = af.createFactory();
        System.out.println(product);
    }

}
