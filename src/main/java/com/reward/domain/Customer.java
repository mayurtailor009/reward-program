package com.reward.domain;

public class Customer {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer withId(String valueId) {
        this.setId(valueId);
        return this;
    }

    public Customer withName(String valueName) {
        this.setName(valueName);
        return this;
    }
}
