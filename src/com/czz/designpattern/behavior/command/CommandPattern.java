package com.czz.designpattern.behavior.command;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 14:32:00
 * @description :
 *
 * 1. 模式的结构
 * 命令模式包含以下主要角色。
 * 1、抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 * 2、具体命令角色（Concrete    Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * 3、实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * 4、调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。
 */
public class CommandPattern {
    public static void main(String[] args) {
        //创建一个指令
        Command command =new ConcreteCommand();
        //创建一个发送者
        Invoker invoker=new Invoker();
        //设置指令
        invoker.setCommand(command);
        //执行指令
        System.out.println("指令执行中");
        command.execute();

    }
}

/**
 * 调用者
 */
class Invoker{
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void call(){
        System.out.println("执行指令");
        command.execute();
    }
}

/**
 * 抽象命令
 */
interface Command{
    void execute();
}

/**
 * 具体指令
 */
class ConcreteCommand implements Command{
    //定义接收者
    Receiver receiver;

    ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        System.out.println("具体指令---");
    }
}

/**
 * 接收者
 */
class Receiver{
    public void action(){
        System.out.println("接收信息");
    }
}

