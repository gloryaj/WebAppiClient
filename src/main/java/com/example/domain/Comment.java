package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int report_number;
    private String description;
	private String comment_timestamp;

    public Comment() {
    }

    public Comment(int id, int report_number, String description, String comment_timestamp) {
        this.id = id;
        this.report_number = report_number;
        this.description = description;
        this.comment_timestamp = comment_timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReport_number() {
        return report_number;
    }

    public void setReport_number(int report_number) {
        this.report_number = report_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment_timestamp() {
        return comment_timestamp;
    }

    public void setComment_timestamp(String comment_timestamp) {
        this.comment_timestamp = comment_timestamp;
    }


}
