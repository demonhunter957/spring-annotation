package com.chris.config;

import com.chris.bean.lifecycle.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chris.bean.lifecycle")
public class MainConfigLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    // @Scope("prototype") 如果bean是多实例，则容器不会调用销毁方法
    public Car car(){
        return new Car("Benz");
    }
}
