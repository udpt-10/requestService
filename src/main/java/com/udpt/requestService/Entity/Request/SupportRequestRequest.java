package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class SupportRequestRequest {

    private int employeeId;
    private Date date;
    private String department;
    private String reason;
    private String describe;

    public SupportRequestRequest(int employeeId, Date date, String department, String reason, String describe) {
        this.employeeId = employeeId;
        this.date = date;
        this.department = department;
        this.reason = reason;
        this.describe = describe;
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
}
