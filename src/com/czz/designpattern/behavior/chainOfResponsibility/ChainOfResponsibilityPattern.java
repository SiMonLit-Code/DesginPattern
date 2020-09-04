package com.czz.designpattern.behavior.chainOfResponsibility;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 15:25:00
 * @description :
 * 1. 模式的结构
 * 职责链模式主要包含以下角色。
 * 1、抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 2、具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 * 3、客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        //指派A的下一个处理器
        handlerA.setNext(handlerB);
        //执行
        handlerA.handleRequest(4000);
    }
}

/**
 * 抽象处理角色
 */
abstract class Handler{
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(int money);
}

/**
 * 具体处理角色
 */
class ConcreteHandlerA extends Handler{

    @Override
    public void handleRequest(int money) {
        if (money<1000){
            System.out.println("A已处理");
        }else if (getNext() != null){
            System.out.println("A无法处理");
            getNext().handleRequest(money);
        }else {
            System.out.println("无人处理");
        }
    }
}

/**
 * 具体处理角色
 */
class ConcreteHandlerB extends Handler{

    @Override
    public void handleRequest(int money) {
        if (money<3000){
            System.out.println("B已处理");
        }else if (getNext() != null){
            System.out.println("B无法处理");
            getNext().handleRequest(money);
        }else {
            System.out.println("无人处理");
        }
    }
}