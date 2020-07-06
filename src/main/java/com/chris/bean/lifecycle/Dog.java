package com.chris.bean.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
 * 使用JSR250规范管理生命周期
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog...constructor");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog...init..");
    }

    //容器移除之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("dog...destroy");
    }
}
