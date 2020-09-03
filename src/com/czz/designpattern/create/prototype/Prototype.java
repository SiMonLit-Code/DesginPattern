package com.czz.designpattern.create.prototype;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 14:45:00
 * @description :
 * 模式的结构
 * 1、原型模式包含以下主要角色。
 * 2、抽象原型类：规定了具体原型对象必须实现的接口。
 * 3、具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 4、访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 *
 * 原型模式通常适用于以下场景。
 * 1、对象之间相同或相似，即只是个别的几个属性不同的时候。
 * 2、对象的创建过程比较麻烦，但复制比较简单的时候。
 *
 */
public class Prototype implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype() {
        System.out.println("具体原型创建成功");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return super.clone();
    }
}
