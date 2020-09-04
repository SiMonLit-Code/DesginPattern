package com.czz.designpattern.behavior.state;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-04 16:07:00
 * @description :
 */
public class StatePattern {
    public static void main(String[] args) {
        Content content=new Content();
        content.state.setScore(12);
        content.addScore(20);
        content.addScore(120);
        content.addScore(-120);
    }
}

/**
 * 抽象状态
 */
abstract class State{
    private int score;
    private Content content;
    public abstract void checkState();
//    public abstract void handle();


    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score){
        this.score+=score;
        checkState();
    }
}
/**
 * 具体状态
 */
class ConcreteStateA extends State{

    public ConcreteStateA(Content content) {
        setContent(content);
    }

    @Override
    public void checkState() {
        if (getScore()>50){
            System.out.println("当前状态"+ConcreteStateA.class.getName());
            getContent().setState(new ConcreteStateB(getContent()));
            System.out.println("之后状态"+ConcreteStateB.class.getName());
        }
    }
}

class ConcreteStateB extends State{
    public ConcreteStateB(Content content) {
        setContent(content);
    }

    @Override
    public void checkState() {
        if (getScore()<50){
            System.out.println("当前状态"+ConcreteStateB.class.getName());
            getContent().setState(new ConcreteStateA(getContent()));
            System.out.println("之后状态"+ConcreteStateA.class.getName());
        }
    }
}

/**
 * 环境类
 */
class Content{
    //测试

    State state;

    public Content() {
        this.state = new ConcreteStateA(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addScore(int s){
        state.addScore(s);
    }




}

