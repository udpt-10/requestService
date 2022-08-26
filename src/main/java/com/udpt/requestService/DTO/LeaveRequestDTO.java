package com.udpt.requestService.DTO;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Response.LeaveResponse;
import com.udpt.requestService.Entity.Response.OTResponse;

public class LeaveRequestDTO {
    public static LeaveResponse response(LeaveRequest leaveRequest, Employee employee, Employee manager) {
        LeaveResponse leaveResponse = new LeaveResponse();
        leaveResponse.setLeaveRequestId(leaveRequest.getLeaveRequestId());
        leaveResponse.setEmployeeId(leaveRequest.getEmployeeId());
        leaveResponse.setEmployeeName(employee.getEmployeeName());
        leaveResponse.setDate(leaveRequest.getDate());
        leaveResponse.setHour(leaveRequest.getHour());
        leaveResponse.setReason(leaveRequest.getReason());
        leaveResponse.setManagerId(leaveRequest.getManagerId());
        leaveResponse.setManagerName(manager.getEmployeeName());
        leaveResponse.setIsApproved(leaveRequest.getIsApproved());
        leaveResponse.setApproveReason(leaveRequest.getApproveReason());
        leaveResponse.setApproveDate(leaveRequest.getApproveDate());
        return leaveResponse;
    }
}
