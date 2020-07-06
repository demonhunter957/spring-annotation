package com.chris.config;

import com.chris.bean.Color;
import com.chris.bean.ColorFactoryBean;
import com.chris.bean.Person;
import com.chris.bean.Red;
import com.chris.condition.LinuxCondition;
import com.chris.condition.WindowsCondition;
import com.chris.importer.MyImportBeanDefinitionRegistrar;
import com.chris.importer.MyImportSelector;
import org.springframework.context.annotation.*;

@Configuration()
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) //导入组件，id默认是全类名
public class MainConfig2 {

    @Bean
    /*
     * @Scope 调整作用域
     * singleton：默认，单实例，IOC容器启动的时候会创建对象，以后每次获取就从容器中拿
     * prototype:多实例,IOC容器启动的时候不会调用方法创建对象，而是每次获取的时候才会调用
     * request:同一个请求创建一个实例对象
     * session:同一个session创建一个实例对象
     */
    @Scope(value = "singleton")
    /*
     * @Lazy 懒加载
     * 仅针对于单实例，作用是容器启动的时候不创建对象，仅在第一次获取的时候创建对象并初始化
     */
    @Lazy
    public Person person() {
        System.out.println("给容器中添加person...");
        return new Person("Peter", 20);
    }


    /*
     * @Conditional 按照一定条件给容器中注册bean
     * 这个注解也可以放在类上
     */

    @Bean(value = "bill")
    @Conditional(value = {WindowsCondition.class})
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean(value = "linus")
    public Person person02() {
        return new Person("Linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
