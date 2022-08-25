package com.udpt.requestService.Entity.Request;

import javax.persistence.Column;
import javax.xml.crypto.Data;
import java.util.Date;

public class GeneralInfoRequest {

    private String title;
    private String describe;
    private int author;
    private Date date;

    public GeneralInfoRequest(String title, String describe, int author, Date date) {
        this.title = title;
        this.describe = describe;
        this.author = author;
        this.date = date;
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
