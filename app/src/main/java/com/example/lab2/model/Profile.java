package com.example.lab2.model;

public class Profile {
    private String name;
    private int age;
    private String location;
    private String matchStatistic;
    private String description;

    public Profile(String name, int age, String location, String matchStatistic, String description) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.matchStatistic = matchStatistic;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMatchStatistic() {
        return matchStatistic;
    }

    public void setMatchStatistic(String matchStatistic) {
        this.matchStatistic = matchStatistic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
