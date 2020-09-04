package com.czz.designpattern.construct.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 10:34:00
 * @description :
 */
public class ProxyTest implements InvocationHandler {
    TemplateTest templateTest;

    public ProxyTest(TemplateTest templateTest) {
        this.templateTest = templateTest;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法动态代理前");
        Object invoke = method.invoke(templateTest, args);
        System.out.println("方法动态代理后");
        return invoke;
    }
}
