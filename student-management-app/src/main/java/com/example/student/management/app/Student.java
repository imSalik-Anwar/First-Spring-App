package com.example.student.management.app;

public class Student {
    private int regNo;
    private String name;
    private String course;
    private int age;

    public Student() {
    }
    public Student(int regNo, String name, String course, int age) {
        this.regNo = regNo;
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
