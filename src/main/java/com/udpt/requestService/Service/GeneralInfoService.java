package com.udpt.requestService.Service;

import com.udpt.requestService.DTO.GeneralInfoDTO;
import com.udpt.requestService.DTO.LeaveRequestDTO;
import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.GeneralInfo;
import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.Request.GeneralInfoRequest;
import com.udpt.requestService.Entity.Response.GeneralInfoResponse;
import com.udpt.requestService.Entity.Response.LeaveResponse;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import com.udpt.requestService.Repository.GeneralInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneralInfoService {
    @Autowired
    private GeneralInfoRepository generalInfoRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    private int generalInfoId;

    private GeneralInfoRequest generalInfoRequest;

    private GeneralInfo generalInfo;

    public void setGeneralInfoId(int generalInfoId) {
        this.generalInfoId = generalInfoId;
    }

    public void setGeneralInfoRequest(GeneralInfoRequest generalInfoRequest) {
        this.generalInfoRequest = generalInfoRequest;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public List<GeneralInfoResponse> getAllGeneralInfo() {

        List<GeneralInfo> generalInfoList = generalInfoRepository.findAll();
        List<GeneralInfoResponse> generalInfoResponseList = new ArrayList<GeneralInfoResponse>();
        for (GeneralInfo generalInfo : generalInfoList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(generalInfo.getAuthor());

            GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();
            generalInfoResponse = GeneralInfoDTO.response(generalInfo,optionalEmployee.get());
            generalInfoResponseList.add(generalInfoResponse);
        }
        return generalInfoResponseList;
    }

    public GeneralInfoResponse getGeneralInfoByGeneralInfoId() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfoId);
        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("general info has id "+ generalInfoId);
        }

        Optional<Employee> optionalEmployee = employeeRepository.findById(generalInfo.getAuthor());

        GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();
        generalInfoResponse = GeneralInfoDTO.response(optionalGeneralInfo.get(),optionalEmployee.get());
        return generalInfoResponse;
    }

    public String addNewGeneralInfo() {
        GeneralInfo generalInfo = new GeneralInfo();
        generalInfo.setDate(generalInfoRequest.getDate());
        generalInfo.setDescribe(generalInfoRequest.getDescribe());
        generalInfo.setAuthor(generalInfoRequest.getAuthor());
        generalInfo.setTitle(generalInfoRequest.getTitle());

        generalInfoRepository.save(generalInfo);
        return "General info was added successful";
    }

    public String editGeneralInfo() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfo.getGeneralInfoId());
        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("General info has id " + generalInfoId);
        }

        GeneralInfo generalInfoDB = optionalGeneralInfo.get();
        generalInfoDB.setTitle(generalInfo.getTitle());
        generalInfoDB.setDate(generalInfo.getDate());
        generalInfoDB.setAuthor(generalInfo.getAuthor());
        generalInfoDB.setDescribe(generalInfo.getDescribe());
        generalInfoRepository.save(generalInfoDB);
        return "General info was edited";
    }

    public String deleteGeneralInfo() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfoId);

        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("General info has id " + generalInfoId);
        }

        generalInfoRepository.delete(optionalGeneralInfo.get());
        return "General has id " + generalInfoId + " was deleted";
    }
}
