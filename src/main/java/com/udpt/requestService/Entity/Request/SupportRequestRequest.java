package com.udpt.requestService.Entity.Request;

import javax.persistence.Column;
import java.util.Date;

public class SupportRequestRequest {

    private String employee_id;
    private Date date;
    private String department;
    private int approver;
    private Date approveDate;
    private boolean isApproved;
    private String reason;
    private int directorId;
    private double money;
    private String status;
    private String describe;

    public SupportRequestRequest(String employee_id, Date date, String department, int approver, Date approveDate, boolean isApproved, String reason, int directorId, double money, String status, String describe) {
        this.employee_id = employee_id;
        this.date = date;
        this.department = department;
        this.approver = approver;
        this.approveDate = approveDate;
        this.isApproved = isApproved;
        this.reason = reason;
        this.directorId = directorId;
        this.money = money;
        this.status = status;
        this.describe = describe;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setApprover(int approver) {
        this.approver = approver;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
