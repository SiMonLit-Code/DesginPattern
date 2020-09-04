package com.czz.designpattern.construct.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 10:44:00
 * @description :
 * JDK代理基于接口的代理
 */
public class Test {
    public static void main(String[] args) {
        TemplateTest templateTest = new TemplateTestImpl();
        TemplateTest instance = (TemplateTest) Proxy.newProxyInstance(TemplateTest.class.getClassLoader(),
                new Class[]{TemplateTest.class},
                new ProxyTest(templateTest));
        instance.operation();


    }
}
