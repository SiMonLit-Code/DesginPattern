package com.czz.designpattern.create.singleton;

import java.io.DataInputStream;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 14:17:00
 * @description :
 * 单例模式有 3 个特点：
 * 1、单例类只有一个实例对象；
 * 2、该单例对象必须由单例类自行创建；
 * 3、单例类对外提供一个访问该单例的全局访问点；
 */
public class Singleton {

    //懒汉式单例  该模式的特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
    /**
     * 注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
     * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点
     */
    public static class LazySingleton{

        private static volatile LazySingleton instance=null;

        //私有化构造函数，避免类在外部类实例化
        private LazySingleton() {}
        public static synchronized LazySingleton getInstance(){
            if (instance==null){
                instance=new LazySingleton();
            }
            return instance;
        }
    }

    //饿汉式单例  该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
    /**
     * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，
     * 可以直接用于多线程而不会出现问题。
     */
    public static class HungrySingleton{
        private static HungrySingleton instance=new HungrySingleton();

        //私有化构造函数，避免类在外部类实例化
        private HungrySingleton() { }
        public static HungrySingleton getInstance(){
            return instance;
        }
    }


    //双重检查方法
    public static class DoubleCheckSingleton{
        private static volatile DoubleCheckSingleton doubleCheckSingleton = null;
        private DoubleCheckSingleton(){}
        public static DoubleCheckSingleton getInstance(){
            if (doubleCheckSingleton == null){
                synchronized (DoubleCheckSingleton.class){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
            return doubleCheckSingleton;
        }
    }


    /**
     * 静态内部类，既实现懒加载，又实现进程安全
     * 创建外内类时，内部类不会被加载！
     */
    public static class InnerClassSingleton{
        public static final Singleton singleton = new Singleton();
    }
    public static Singleton getInstance(){
        return InnerClassSingleton.singleton;
    }
}
