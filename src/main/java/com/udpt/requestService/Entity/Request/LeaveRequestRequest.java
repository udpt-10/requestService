package com.udpt.requestService.Entity.Request;

import java.util.Date;

public class LeaveRequestRequest {
    private int employeeId;
    private Date date;
    private String leavingType;
    private String reason;
    private int numberDays;

    public LeaveRequestRequest(int employeeId, Date date, String leavingType, String reason) {
        this.employeeId = employeeId;
        this.date = date;
        this.leavingType = leavingType;
        this.reason = reason;
    }

    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    
    public int getNumberDays() {
		return numberDays;
	}


	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}


	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
