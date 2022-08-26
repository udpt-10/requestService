package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class LeaveRequestRequest {
    private int employeeId;
    private Date date;
    private int hour;
    private String reason;
    private int managerId;

    public LeaveRequestRequest(int employeeId, Date date, int hour, String reason, int managerId) {
        this.employeeId = employeeId;
        this.date = date;
        this.hour = hour;
        this.reason = reason;
        this.managerId = managerId;
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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
