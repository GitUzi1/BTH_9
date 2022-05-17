package com.example.bth_9.model;

public class Contact {
    private String name;
    private String Phone;

    public Contact(String name, String phone) {
        this.name = name;
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Tên :" +name+"/nPhone :"+this.Phone;
    }
}
