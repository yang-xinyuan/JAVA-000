package com.base.springbase.common.autoconfig.domain;

public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("hello...........");
    }

    public Student create() {
        return new Student(101, "KK101");
    }

    public static Student create(int id, String name) {
        return new Student(id, name);
    }
}
