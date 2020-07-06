package com.chris.config;

import com.chris.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/person.properties")
public class MainConfigProperty {

    @Bean
    public Person person(){
        return new Person();
    }
}
