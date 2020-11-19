package com.base.springbase.common.beanassembly.autowire.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//表示 Spring IoC 会把这个类扫描成一个 bean 实例
//而其中的 value 属性代表这个类在 Spring 中的 id
//这就相当于在 XML 中定义的 Bean 的 id
//<bean id="Student" class="com.chenhj.annotationbean.Student">
//也可以简写成 @Component("student")，甚至直接写成 @Component对于不写的，Spring IoC 容器就默认以类名来命名作为 id，只不过首字母小写，配置到容器中。
@Component(value = "autowireDomain")
public class AutowireDomain {
    @Value("2")
    int id;
    @Value("student_name_02")
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
