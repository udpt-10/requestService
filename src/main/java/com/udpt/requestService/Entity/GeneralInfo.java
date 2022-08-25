package com.udpt.requestService.Entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "general_info")
public class GeneralInfo {
    @Id
    @Column(name = "general_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generalInfoId;

    @Column(name = "title")
    private String title;

    @Column(name = "describe")
    private String describe;

    @Column(name = "author")
    private int author;

    @Column(name = "date")
    private Date date;

    public GeneralInfo () {

    }

    public int getGeneralInfoId() {
        return generalInfoId;
    }

    public void setGeneralInfoId(int generalInfoId) {
        this.generalInfoId = generalInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
