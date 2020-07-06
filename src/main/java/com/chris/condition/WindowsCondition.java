package com.chris.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

    /**
     * @param context 判断条件的上下文
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取到IOC bean的创建工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取bean定义的注册类，这个对象可以判断容器中bean的注册情况，也可以给容器注册bean
        BeanDefinitionRegistry registry = context.getRegistry();

        //获取运行环境信息
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property.contains("Window");
    }
}
