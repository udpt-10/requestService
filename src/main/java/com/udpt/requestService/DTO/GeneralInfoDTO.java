package com.udpt.requestService.DTO;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.GeneralInfo;
import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.Response.GeneralInfoResponse;
import com.udpt.requestService.Entity.Response.LeaveResponse;

import java.util.Date;

public class GeneralInfoDTO {
    public static GeneralInfoResponse response(GeneralInfo generalInfo, Employee employee) {
        GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();
        generalInfoResponse.setGeneralInfoId(generalInfo.getGeneralInfoId());
        generalInfoResponse.setTitle(generalInfo.getTitle());
        generalInfoResponse.setDescribe(generalInfo.getDescribe());
        generalInfoResponse.setAuthor(generalInfo.getAuthor());
        generalInfoResponse.setAuthorName(employee.getEmployeeName());
        generalInfoResponse.setDate(generalInfo.getDate());
        return generalInfoResponse;
    }
}
