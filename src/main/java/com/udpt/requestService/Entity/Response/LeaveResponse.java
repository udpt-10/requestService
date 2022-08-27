package com.udpt.requestService.Entity.Response;

import java.time.LocalDate;
import java.util.Date;

public class LeaveResponse {
    private int leaveRequestId;
    private int employeeId;
    private String employeeName;
    private LocalDate date;
    private String reason;
    private int numberDays;
    private String leavingType;
    private int managerId;
    private String managerName;
    private boolean isApproved;
    private String approveReason;
    private LocalDate approveDate;
    private String note;

    
    
    
    
    

    public String getNote() {
		return note;
	}





	public void setNote(String note) {
		this.note = note;
	}





	





	public LeaveResponse(int leaveRequestId, int employeeId, String employeeName, LocalDate date, String reason,
			int numberDays, String leavingType, int managerId, String managerName, boolean isApproved,
			String approveReason, LocalDate approveDate, String note) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.date = date;
		this.reason = reason;
		this.numberDays = numberDays;
		this.leavingType = leavingType;
		this.managerId = managerId;
		this.managerName = managerName;
		this.isApproved = isApproved;
		this.approveReason = approveReason;
		this.approveDate = approveDate;
		this.note = note;
	}





	public String getLeavingType() {
		return leavingType;
	}





	public void setLeavingType(String leavingType) {
		this.leavingType = leavingType;
	}





	public int getNumberDays() {
		return numberDays;
	}



	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public void setApproveDate(LocalDate approveDate) {
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
