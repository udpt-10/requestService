package com.udpt.requestService.Entity.Response;

import javax.persistence.Column;
import java.util.Date;

public class GeneralInfoResponse {
    private int generalInfoId;
    private String title;
    private String describe;
    private int author;
    private String authorName;
    private Date date;

    public GeneralInfoResponse() {

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
