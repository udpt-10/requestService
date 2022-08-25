package com.udpt.requestService.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "support_request")
public class SupportRequest {
    @Id
    @Column(name = "support_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supportRequestId;

    @Column(name = "employee_id")
    private String employee_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "department")
    private String department;

    @Column(name = "approver")
    private int approver;

    @Column(name = "approve_date")
    private Date approveDate;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Column(name = "reason")
    private String reason;

    @Column(name = "director_id")
    private int directorId;

    @Column(name = "money")
    private double money;

    @Column(name = "status")
    private String status;

    @Column(name = "describe")
    private String describe;

    public SupportRequest() {

    }

    public int getSupportRequestId() {
        return supportRequestId;
    }

    public void setSupportRequestId(int supportRequestId) {
        this.supportRequestId = supportRequestId;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getApprover() {
        return approver;
    }

    public void setApprover(int approver) {
        this.approver = approver;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
