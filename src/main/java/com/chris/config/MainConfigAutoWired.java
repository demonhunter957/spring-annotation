package com.chris.config;

import com.chris.dao.MyDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
 * 1. @AutoWired 自动注入。这个是Spring的注解
 *  1) 默认按照类型去容器中找对应的bean
 *  2) @Qualifier 当容器里有多个类型为MyDao的bean时，指定要注入Qualifier指定名字的bean
 *  3) @Primary 当容器内有多个同类型的bean的时，默认首选bean。也可以继续使用@Qualifier指定首选的bean
 *
 * 2. @Resource(JRS250) @Inject(JSR330)。这两个是JAVA的注解。
 *  1) @Resource默认按照组件名称装配。如果使用@Resource，@Primary就不生效了
 *  2) @Inject: 需要导入javax.inject 这个包，和@Autowired功能一样，@Primary注解也能生效
 *
 *
 * 这些注解生效的原因：
 * 是因为org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor 这个后置处理器
 */
@Configuration
@ComponentScan({"com.chris.service", "com.chris.controller", "com.chris.dao" })
public class MainConfigAutoWired {

    @Bean(value = "myDao2")
    //当容器内有多个同类型的bean的时，默认首选bean
    @Primary
    public MyDao myDao(){
        MyDao myDao = new MyDao();
        myDao.setLabel("2");
        return myDao;
    }

}
