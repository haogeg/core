package cn.net.rainier.global.entity;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private int age;
    private String code;
    private String sex;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
