package com.czz.designpattern.construct.proxy.staticproxy;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 17:08:00
 * @description :
 * 1. 模式的结构
 * 代理模式的主要角色如下。
 * 1、抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 * 2、真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * 3、代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 */
public class ProxyTest{

    //真实主题
    class RealObject implements AbstractObject{
        public void request(){
            System.out.println("真实方法请求");
        }
    }

    //抽象主题
    interface AbstractObject{
        void request();
    }

    //代理
    class Proxy implements AbstractObject{
        private AbstractObject realObject;

        public Proxy(AbstractObject realObject) {
            this.realObject = realObject;
        }

        @Override
        public void request() {
            if (realObject==null){
                realObject=new RealObject();
            }
            /**
             * ...业务处理
             */
            realObject.request();
        }
    }

    public static void main(String[] args) {
        AbstractObject realObject = new ProxyTest().new RealObject();
        Proxy proxy = new ProxyTest().new Proxy(realObject);
        proxy.request();
    }
}
