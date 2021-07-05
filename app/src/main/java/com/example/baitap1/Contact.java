package com.example.baitap1;

public class Contact {
    int id;
    String name;
    String phoneNum;
    int status;

    public int getId() {
        return id;
    }

    public Contact(String name, String phoneNum, int status) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Contact(int id, String name, String phoneNum, int status) {

        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.status = status;
    }
}
