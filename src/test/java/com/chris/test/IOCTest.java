package com.chris.test;

import com.chris.bean.Person;
import com.chris.config.MainConfig;
import com.chris.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("resource")
public class IOCTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);


    @Test
    public void test00(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void test01(){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

}
