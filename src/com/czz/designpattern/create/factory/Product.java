package com.czz.designpattern.create.factory;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 15:16:00
 * @description :
 */
public class Product implements AbstractProduct{


    @Override
    public Product createProduct() {
        System.out.println("生产了一个产品");
        return new Product();

    }

}
