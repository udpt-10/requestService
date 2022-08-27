package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class WorkFromHomeRequestRequest {
    private int employeeId;
    private Date date;
    private int numberDays;
    private String reason;

    public WorkFromHomeRequestRequest(int employeeId, Date date) {
        this.employeeId = employeeId;
        this.date = date;
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

   
    
    
}
