package test;

import com.czz.designpattern.create.builder.Builder;
import com.czz.designpattern.create.builder.ConcreteBuilder;
import com.czz.designpattern.create.builder.Director;
import com.czz.designpattern.create.builder.Product;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 16:55:00
 * @description :
 */
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder=new ConcreteBuilder();
        Director director=new Director(builder);
        Product construct = director.construct();
        System.out.println(construct);
    }
}
