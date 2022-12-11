package com.example.myapp;

public class PeopleItem {
    int _id;
    String name;
    String phone_num;
    //이미지 도 추가?

    public PeopleItem(int _id, String name, String phone_num) {
        this._id = _id;
        this.name = name;
        this.phone_num = phone_num;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
