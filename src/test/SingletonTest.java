package test;

import com.czz.designpattern.create.singleton.Singleton;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 14:31:00
 * @description :
 */
public class SingletonTest {


    public static void main(String[] args) {
        Singleton.LazySingleton czz1= Singleton.LazySingleton.getInstance();
        Singleton.LazySingleton czz2= Singleton.LazySingleton.getInstance();
        System.out.println(czz1==czz2);
    }
}
