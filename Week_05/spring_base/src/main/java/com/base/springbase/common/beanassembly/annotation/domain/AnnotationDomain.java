package com.base.springbase.common.beanassembly.annotation.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("annotationDomain")
public class AnnotationDomain {

    @Value("1")
    int id;
    @Value("student_name_01")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
