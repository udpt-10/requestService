package com.udpt.requestService.Entity.Response;

import javax.persistence.Column;
import java.util.Date;

public class WFHResponse {
    private int workFromHomeRequestId;
    private int employeeId;
    private String employeeName;
    private Date date;

    public WFHResponse() {

    }

    public int getWorkFromHomeRequestId() {
        return workFromHomeRequestId;
    }

    public void setWorkFromHomeRequestId(int workFromHomeRequestId) {
        this.workFromHomeRequestId = workFromHomeRequestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
