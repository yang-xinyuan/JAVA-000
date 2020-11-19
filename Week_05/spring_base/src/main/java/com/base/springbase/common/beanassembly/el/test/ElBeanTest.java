package com.base.springbase.common.beanassembly.el.test;

import com.base.springbase.common.beanassembly.el.config.ElConfig;
import com.base.springbase.common.beanassembly.el.domain.ElDomain;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring EL方式注入
 * Spring 还提供了更灵活的注入方式，那就是 Spring 表达式，实际上 Spring EL 远比以上注入方式都要强大，它拥有很多功能：
 * 1、使用 Bean 的 id 来引用 Bean
 * 2、调用指定对象的方法和访问对象的属性
 * 3、进行运算
 * 4、提供正则表达式进行匹配
 * 5、集合配置
 */
public class ElBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElDomain elDomain = context.getBean("elDomain", ElDomain.class);
        System.out.println(elDomain.getDbtype());
    }
}
