package com.sungwook.exception.statuscode;

public class StudentEntity {
    private String name;
    private int age;

    public StudentEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
