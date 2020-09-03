package test;

import com.czz.designpattern.create.prototype.Prototype;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 14:52:00
 * @description :
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype1=new Prototype();
        prototype1.setName("张三");

        Prototype prototype2= (Prototype) prototype1.clone();
        prototype2.setName("李四");
        System.out.println("prototype1==prototype2:"+(prototype1==prototype2));
        System.out.println(prototype2.getName());
    }

}
