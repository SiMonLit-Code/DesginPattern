package com.czz.designpattern.create.builder;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 16:50:00
 * @description :
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //组装方法
    public Product construct() {
        builder.partB();
        builder.partA();
        builder.partC();
        return builder.getProduct();
    }
}
