package com.chris.config;

import com.chris.bean.Person;
import com.chris.dao.MyDao;
import com.chris.filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.chris", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyDao.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
@Import(MyDao.class)
public class MainConfig {

    @Bean(value = "person")
    public Person person(){
        return new Person("chris", 18);
    }

    @Bean(value = "person01")
    public Person person01(){
        return new Person("jack", 20);
    }
}
