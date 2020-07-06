package com.chris.test;

import com.chris.bean.Person;
import com.chris.config.MainConfigProperty;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class PropertyTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigProperty.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //从配置环境中获取配置文件中的值
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }
}
