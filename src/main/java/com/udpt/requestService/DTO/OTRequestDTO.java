package com.udpt.requestService.DTO;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Response.OTResponse;

import java.util.Date;

public class OTRequestDTO {
    public static OTResponse response(OTRequest otRequest, Employee employee, Employee manager) {
        OTResponse otResponse = new OTResponse();
        otResponse.setOtRequestId(otRequest.getOtRequestId());
        otResponse.setEmployeeId(otRequest.getEmployeeId());
        otResponse.setEmployeeName(employee.getEmployeeName());
        otResponse.setDate(otRequest.getDate());
        otResponse.setHour(otRequest.getHour());
        otResponse.setReason(otRequest.getReason());
        otResponse.setManagerId(otRequest.getManagerId());
        otResponse.setManagerName(manager.getEmployeeName());
        otResponse.setIsApproved(otRequest.getIsApproved());
        otResponse.setApproveReason(otRequest.getApproveReason());
        otResponse.setApproveDate(otRequest.getApproveDate());
        return otResponse;
    }
}
