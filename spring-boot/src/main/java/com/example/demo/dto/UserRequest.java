package com.example.demo.dto;

public class UserRequest {
    private String name;
    private String email;
    private int age;


    public UserRequest(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int setAge(int age) {
        return age;
    }

    public String setEmail(String email) {
        return email;
    }

    public String setName(String name) {
        return name;
    }


    public String toString() {
        return this.getName() + " | " + this.getName() + " | " + this.getEmail();
    }
}
