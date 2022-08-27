package com.udpt.requestService.Entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "work_from_home_request")
public class WorkFromHomeRequest {

    @Id
    @Column(name = "work_from_home_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workFromHomeRequestId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "date")
    private Date date;
    
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

    public WorkFromHomeRequest () {

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumberDays() {
		return numberDays;
	}

	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
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

	public void setApproveDate(LocalDate approveDate) {
		this.approveDate = approveDate;
	}
    
    

    
}
