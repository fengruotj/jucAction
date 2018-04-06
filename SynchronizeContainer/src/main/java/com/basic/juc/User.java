package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/5.
 */
public class User {
    private String name;
    private String passowrd;

    public User(String name, String passowrd) {
        this.name = name;
        this.passowrd = passowrd;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passowrd='" + passowrd + '\'' +
                '}';
    }
}
