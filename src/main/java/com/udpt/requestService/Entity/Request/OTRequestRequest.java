package com.udpt.requestService.Entity.Request;

import java.time.LocalDate;
import java.util.Date;

public class OTRequestRequest {
    private int employeeId;
    private LocalDate date;
    private int hour;
    private String reason;

    public OTRequestRequest(int employeeId, LocalDate date, int hour, String reason) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
