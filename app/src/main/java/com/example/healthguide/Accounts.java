package com.example.healthguide;

import java.io.Serializable;

public class Accounts implements Serializable {
    private int id;
    private String name;
    private String pass;
    private int height;
    private int weight;
    private int age;

    public Accounts(int id, String name, String pass, int height, int weight, int age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
