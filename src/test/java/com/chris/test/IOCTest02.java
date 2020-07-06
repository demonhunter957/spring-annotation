package com.chris.test;

import com.chris.bean.Person;
import com.chris.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest02 {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test00(){
        Person person = (Person)applicationContext.getBean("person");
        Person person2 = (Person)applicationContext.getBean("person");

        System.out.println(person == person2);
    }

    @Test
    public void test01(){
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void printBeans(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void testFactoryBean(){
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");

        //工厂bean其实获取的是getObject()方法创建的对象
        System.out.println("colorFactoryBean的类型: " + colorFactoryBean.getClass());
        //是否为单例由isSingleton()方法控制
        System.out.println(colorFactoryBean == colorFactoryBean2);

        //如果想获取工厂bean本身，就加一个& prefix
        Object colorFactoryBean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("colorFactoryBean的类型: " + colorFactoryBean3.getClass());
    }

}
