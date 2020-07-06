package com.chris.test;

import com.chris.config.MainConfigAutoWired;
import com.chris.dao.MyDao;
import com.chris.service.MyService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiredTest {

    @Test
    public void printBeans(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutoWired.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutoWired.class);
        MyService myService = applicationContext.getBean(MyService.class);
        myService.print();

    }
}
