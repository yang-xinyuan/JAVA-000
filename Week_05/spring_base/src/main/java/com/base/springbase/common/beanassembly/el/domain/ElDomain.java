package com.base.springbase.common.beanassembly.el.domain;

import org.springframework.stereotype.Component;

@Component(value="elDomain")
public class ElDomain {

    private String dbtype= "dbtype";

    public String getDbtype() {
        return dbtype;
    }

    public void setDbtype(String dbtype) {
        this.dbtype = dbtype;
    }
}
