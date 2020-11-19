package com.base.springbase.common.beanassembly.autowire.test;

import com.base.springbase.common.beanassembly.autowire.config.AutowireConfig;
import com.base.springbase.common.beanassembly.autowire.domain.AutowireService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * autowired方式注入
 */
public class AutowireTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowireConfig.class);
        AutowireService service = context.getBean("autowireService", AutowireService.class);
        service.print();
    }
}
