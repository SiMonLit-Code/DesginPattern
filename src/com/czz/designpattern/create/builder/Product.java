package com.czz.designpattern.create.builder;

/**
 * @author : czz
 * @version : 1.0.0
 * @create : 2020-09-02 16:38:00
 * @description : 具体产品
 */
public class Product {

        private String partA;
        private String partB;
        private String partC;
        public void setPartA(String partA)
        {
            this.partA=partA;
        }
        public void setPartB(String partB)
        {
            this.partB=partB;
        }
        public void setPartC(String partC)
        {
            this.partC=partC;
        }
    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
