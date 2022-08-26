package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class SupportRequestRequest {

    private int employeeId;
    private Date date;
    private String department;
    private String reason;
    private String describe;
    private int managerId;
    private int directorId;

    public SupportRequestRequest(int employeeId, Date date, String department, String reason, String describe, int managerId, int directorId) {
        this.employeeId = employeeId;
        this.date = date;
        this.department = department;
        this.reason = reason;
        this.describe = describe;
        this.managerId = managerId;
        this.directorId = directorId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDate() {
        return date;
    }

    public String getDepartment() {
        return department;
    }

    public String getReason() {
        return reason;
    }

    public String getDescribe() {
        return describe;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getDirectorId() {
        return directorId;
    }
}
