package com.base.springbase.common.autoconfig;

import com.base.springbase.common.autoconfig.domain.Klass;
import com.base.springbase.common.autoconfig.domain.School;
import com.base.springbase.common.autoconfig.domain.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 加载bean
 */
@Configuration
@ConditionalOnClass(School.class)
public class LoadBeanConfiguration {
    @Bean
    @ConditionalOnMissingBean(School.class)
    public School school() {

        Student student1 = Student.create(1, "李1");
        Student student2 = Student.create(2, "李2");
        Student student3 = Student.create(3, "李3");
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Klass klass = new Klass();
        klass.setStudents(students);

        School school = new School();
        school.setClass1(klass);
        school.setStudent100(student1);

        return school;
    }
}
