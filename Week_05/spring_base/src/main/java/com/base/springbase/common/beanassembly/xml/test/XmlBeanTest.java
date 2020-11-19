package com.base.springbase.common.beanassembly.xml.test;


import com.base.springbase.common.beanassembly.xml.domain.XmlDomain;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
/**
 * xml方式装配实现类
 */
public class XmlBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");
        XmlDomain xmlDomain = (XmlDomain) context.getBean("xmlDoamin", XmlDomain.class);
        System.out.println(xmlDomain.getId());
        System.out.println(xmlDomain.getList());
        System.out.println(xmlDomain.getMap());
        System.out.println(xmlDomain.getProperties());
        System.out.println(xmlDomain.getSet());
        System.out.println(Arrays.toString(xmlDomain.getArray()));
    }
}
