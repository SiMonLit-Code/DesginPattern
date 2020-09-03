package com.czz.designpattern.create.builder;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 16:48:00
 * @description : 实现建造者
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void partA() {
        product.setPartA("建造A");
    }

    @Override
    public void partB() {
        product.setPartB("建造B");
    }

    @Override
    public void partC() {
        product.setPartC("建造C");
    }
}
