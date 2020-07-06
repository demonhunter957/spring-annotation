package com.chris.service;

import com.chris.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class MyService {

    //@Autowired
    //当容器里有多个类型为MyDao的bean时，指定要注入名为myDao2的bean
    //@Qualifier("myDao2")

    //默认按照组件名装配，也可以指定name
    //@Resource(name = "myDao2")
    @Inject
    private MyDao myDao;

    public void print(){
        System.out.println(myDao);
    }
}
