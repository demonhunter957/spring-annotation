package com.chris.bean.lifecycle;


public class Car {

    private String brand;

    public Car(String brand) {
        System.out.println("car...constructor with parameter...");
        this.brand = brand;
    }

    public Car() {
        System.out.println("car...constructor...");
    }

    //对象创建完成，并赋值完毕时，调用的初始化方法
    public void init(){
        System.out.println("car...init...");
    }

    public void destroy(){
        System.out.println("car...destroy...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("car...setBrand...");
        this.brand = brand;
    }
}
