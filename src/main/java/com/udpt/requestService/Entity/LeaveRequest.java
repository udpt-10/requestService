package com.udpt.requestService.Entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {
    @Id
    @Column(name = "leave_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveRequestId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "leaving_type")
    private String leavingType;
    
    @Column(name = "number_days")
    private int numberDays;

    @Column(name = "reason")
    private String reason;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name= "is_approved")
    private boolean isApproved;

    @Column(name = "approve_reason")
    private String approveReason;

    @Column(name = "approve_date")
    private LocalDate approveDate;
    
    @Column(name="note")
    private String note;

    public LeaveRequest() {

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
    
    

    public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getDate() {
        return date;
    }
    

    public int getNumberDays() {
		return numberDays;
	}

	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}

	public void setDate(LocalDate date) {
        this.date = date;
    }

  

    public String getLeavingType() {
		return leavingType;
	}

	public void setLeavingType(String leavingType) {
		this.leavingType = leavingType;
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

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getApproveReason() {
        return approveReason;
    }

    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
    }

    public LocalDate getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(LocalDate localDate) {
        this.approveDate = localDate;
    }
}
