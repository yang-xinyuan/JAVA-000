package com.base.springbase.common.beanassembly.annotation.test;

import com.base.springbase.common.beanassembly.annotation.config.AnnotationConfig;
import com.base.springbase.common.beanassembly.annotation.domain.AnnotationDomain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * annotation方式装配实现类
 */
public class AnnotationTest {
    public static void main(String[] args) {
        //加载Annotation注解装配
        // StudentConfig.class配置类，描扫当前包下的所有带有@Component()注解
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationDomain domain =context.getBean("annotationDomain",AnnotationDomain.class);

        System.out.println(domain.getId());
        System.out.println(domain.getName());
    }

}
