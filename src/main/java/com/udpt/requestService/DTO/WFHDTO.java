package com.udpt.requestService.DTO;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Response.OTResponse;
import com.udpt.requestService.Entity.Response.WFHResponse;
import com.udpt.requestService.Entity.WorkFromHomeRequest;

import java.util.Date;

public class WFHDTO {
    public static WFHResponse response(WorkFromHomeRequest workFromHomeRequest, Employee employee) {
        WFHResponse wfhResponse = new WFHResponse();
        wfhResponse.setWorkFromHomeRequestId(workFromHomeRequest.getWorkFromHomeRequestId());
        wfhResponse.setEmployeeId(workFromHomeRequest.getEmployeeId());
        wfhResponse.setEmployeeName(employee.getEmployeeName());
        wfhResponse.setDate(workFromHomeRequest.getDate());
        return wfhResponse;
    }
}
