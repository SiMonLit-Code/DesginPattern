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
    // 只需维护一个代理对象
    Object object;

    public ProxyTest(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法动态代理前");
        Object invoke = method.invoke(object, args);
        System.out.println("方法动态代理后");
        return invoke;
    }
}
