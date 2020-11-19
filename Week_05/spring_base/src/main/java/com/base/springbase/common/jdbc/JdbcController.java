package com.base.springbase.common.jdbc;

import com.base.springbase.common.beanassembly.xml.domain.XmlDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {
    @Autowired
    JdbcDemo demo;
    @Autowired
    XmlDomain xmlDomain;
    @RequestMapping("print")
    public void print(){
        demo.jdbcRun();
        System.out.println(xmlDomain.getId());
        System.out.println(xmlDomain.getList());
        System.out.println(xmlDomain.getMap());
        System.out.println(xmlDomain.getProperties());
        System.out.println(xmlDomain.getSet());
        System.out.println(Arrays.toString(xmlDomain.getArray()));
        System.out.println("hello word");
    }
}
