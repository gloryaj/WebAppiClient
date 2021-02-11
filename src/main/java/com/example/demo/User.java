package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    private int id_user;
    private String name;
    private String first_name;
    private String address;
    private String phone;
    private	String second_contact;
    private	String email;
    private	String password;

    public User(){

    }

    public User(int id_user, String name, String first_name, String address, String phone, String second_contact, String email, String password) {
        this.id_user = id_user;
        this.name = name;
        this.first_name = first_name;
        this.address = address;
        this.phone = phone;
        this.second_contact = second_contact;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id_user;
    }

    public void setId(int id) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecond_contact() {
        return second_contact;
    }

    public void setSecond_contact(String second_contact) {
        this.second_contact = second_contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
