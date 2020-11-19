package com.base.springbase.common.beanassembly.autowire.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("autowireService")
public class AutowireService {
    @Autowired
    private AutowireDomain domain;
    public void print(){
        System.out.println(domain.getId());
        System.out.println(domain.getName());
    }
}
