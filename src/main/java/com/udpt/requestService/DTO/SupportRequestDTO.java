package com.udpt.requestService.DTO;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.Response.SupportRequestResponse;
import com.udpt.requestService.Entity.Response.WFHResponse;
import com.udpt.requestService.Entity.SupportRequest;
import com.udpt.requestService.Entity.WorkFromHomeRequest;

import java.util.Date;

public class SupportRequestDTO {
    public static SupportRequestResponse response(SupportRequest supportRequest, Employee employee, Employee manager, Employee director) {
        SupportRequestResponse supportRequestResponse = new SupportRequestResponse();
        supportRequestResponse.setSupportRequestId(supportRequest.getSupportRequestId());
        supportRequestResponse.setEmployeeId(supportRequest.getEmployeeId());
        supportRequestResponse.setEmployeeName(employee.getEmployeeName());
        supportRequestResponse.setDate(supportRequest.getDate());
        supportRequestResponse.setDepartment(supportRequest.getDepartment());
        supportRequestResponse.setApprover(supportRequest.getApprover());
        supportRequestResponse.setManagerName(manager.getEmployeeName());
        supportRequestResponse.setApproveDate(supportRequest.getApproveDate());
        supportRequestResponse.setApproved(supportRequest.isApproved());
        supportRequestResponse.setReason(supportRequest.getReason());
        supportRequestResponse.setDirectorId(supportRequest.getDirectorId());
        supportRequestResponse.setDirectorName(director.getEmployeeName());
        supportRequestResponse.setMoney(supportRequest.getMoney());
        supportRequestResponse.setStatus(supportRequest.getStatus());
        supportRequestResponse.setDescribe(supportRequest.getDescribe());
        return supportRequestResponse;
    }
}
