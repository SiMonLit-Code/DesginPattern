package com.czz.designpattern.behavior.command;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 14:32:00
 * @description :
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

