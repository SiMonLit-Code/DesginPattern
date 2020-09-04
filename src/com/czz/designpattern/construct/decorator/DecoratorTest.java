package com.czz.designpattern.construct.decorator;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-03 18:05:00
 * @description :
 *  模式的结构
 * 装饰模式主要包含以下角色。
 * 1、抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 2、具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 3、抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 4、具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class DecoratorTest {


    public static void main(String[] args) {
        Component component=new ConcreteComponent();
        Decorator decorator=new ConcreteDecorator(component);
        decorator.operation();
    }
}

/**
 * 需要装饰的方法，将方法抽象
 */
interface Component{
//    String name = null;
    void operation();
}

/**
 * 具体需要装饰的方法
 */
class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}

/**
 * 抽象装饰器
 */
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
    public void operation(){
        component.operation();
    }
}

/**
 * 具体抽象装饰器
 */
class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }


    public void operation(){
        component.operation();
        addedFunction();
    }
    public void addedFunction()
    {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}