package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class OTRequestRequest {
    private int employeeId;
    private Date date;
    private int hour;
    private String reason;

    public OTRequestRequest(int employeeId, Date date, int hour, String reason) {
        this.employeeId = employeeId;
        this.date = date;
        this.hour = hour;
        this.reason = reason;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
