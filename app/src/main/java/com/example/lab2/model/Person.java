package com.example.lab2.model;

public class Person {
    private String name;
    private String onlineStatus;

    public Person(String name, String onlineStatus) {
        this.name = name;
        this.onlineStatus = onlineStatus;
    }

    public String getName() {
        return name;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
