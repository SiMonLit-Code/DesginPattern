package com.czz.designpattern.create.factory;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 15:15:00
 * @description :
 */
public class ProductFactory implements AbstractFactory{

    @Override
    public Product createFactory() {
        System.out.println("工厂开始生产");
        return new Product().createProduct();
    }
}
