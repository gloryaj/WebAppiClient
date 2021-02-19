package com.example.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Issue{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private	int ReportNumber;

    @Column(name = "Description")
    @NotNull
    private String Description;

    @Column(name = "usersId")
    @NotNull
    private int usersId;

    @Column(name = "RegisterTimestamp")
    @NotNull
    private Date RegisterTimestamp;

    @Column(name = "Address")
    @NotNull
    private	String Address;

    @Column(name = "ContactPhone")
    @NotNull
    private	String ContactPhone;

    @Column(name = "ContactEmail")
    @Email
    @NotNull
    private	String ContactEmail;

    @Column(name = "Status")
    @NotNull
    private	String Status;

    @Column(name = "SupportUserAssigned")
    @NotNull
    private	String SupportUserAssigned;

    public Issue() {
    }

    public Issue(int reportNumber, String description, int usersId, Date registerTimestamp, String address, String contactPhone, String contactEmail, String status, String supportUserAssigned) {
        ReportNumber = reportNumber;
        Description = description;
        this.usersId = usersId;
        RegisterTimestamp = registerTimestamp;
        Address = address;
        ContactPhone = contactPhone;
        ContactEmail = contactEmail;
        Status = status;
        SupportUserAssigned = supportUserAssigned;
    }

    public int getReportNumber() {
        return ReportNumber;
    }

    public void setReportNumber(int reportNumber) {
        ReportNumber = reportNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public Date getRegisterTimestamp() {
        return RegisterTimestamp;
    }

    public void setRegisterTimestamp(Date registerTimestamp) {
        RegisterTimestamp = registerTimestamp;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSupportUserAssigned() {
        return SupportUserAssigned;
    }

    public void setSupportUserAssigned(String supportUserAssigned) {
        SupportUserAssigned = supportUserAssigned;
    }
}
