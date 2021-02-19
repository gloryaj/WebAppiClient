package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "Clients")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int users_id;

    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "first_name")
    @NotNull
    private String first_name;

    @Column(name = "second_name")
    @NotNull
    private String second_name;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "second_contact")
    @NotNull
    private String second_contact;

    @Column(name = "email")
    @Email
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "time_stamp")
    @NotNull
    private String time_stamp;

    public User() {
    }

    public User(int users_id, String name, String first_name, String second_name, String address, String phone, String second_contact, String email, String password, String time_stamp) {
        this.users_id = users_id;
        this.name = name;
        this.first_name = first_name;
        this.second_name = second_name;
        this.address = address;
        this.phone = phone;
        this.second_contact = second_contact;
        this.email = email;
        this.password = password;
        this.time_stamp = time_stamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(users_id, user.users_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id);
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
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

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
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

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
}
