package com.udpt.requestService.Entity.Response;

import java.util.Date;

public class LeaveResponse {
    private int leaveRequestId;
    private int employeeId;
    private String employeeName;
    private Date date;
    private float hour;
    private String reason;
    private int managerId;
    private String managerName;
    private int isApproved;
    private String approveReason;
    private Date approveDate;

    public LeaveResponse(int leaveRequestId, int employeeId, String employeeName, Date date, float hour, String reason, int managerId, String managerName, int isApproved, String approveReason, Date approveDate) {
        this.leaveRequestId = leaveRequestId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.date = date;
        this.hour = hour;
        this.reason = reason;
        this.managerId = managerId;
        this.managerName = managerName;
        this.isApproved = isApproved;
        this.approveReason = approveReason;
        this.approveDate = approveDate;
    }

    public int getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public LeaveResponse() {

    }



}
