package com.udpt.requestService.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ot_request")
public class OTRequest {
    @Id
    @Column(name = "ot_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int otRequestId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "date")
    private Date date;

    @Column(name = "hour")
    private float hour;

    @Column(name = "reason")
    private String reason;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name= "is_approved")
    private int isApproved;

    @Column(name = "approve_reason")
    private String approveReason;

    @Column(name = "approve_date")
    private Date approveDate;

    public OTRequest () {

    }

    public int getOtRequestId() {
        return otRequestId;
    }

    public void setOtRequestId(int otRequestId) {
        this.otRequestId = otRequestId;
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

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
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

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public String getApproveReason() {
        return approveReason;
    }

    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }
}
