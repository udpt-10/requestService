package com.udpt.requestService.Service;

import com.udpt.requestService.DTO.SupportRequestDTO;
import com.udpt.requestService.DTO.WFHDTO;
import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.Request.SupportRequestRequest;
import com.udpt.requestService.Entity.Response.SupportRequestResponse;
import com.udpt.requestService.Entity.Response.WFHResponse;
import com.udpt.requestService.Entity.SupportRequest;
import com.udpt.requestService.Entity.WorkFromHomeRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import com.udpt.requestService.Repository.SupportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupportRequestService {
    @Autowired
    private SupportRequestRepository supportRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private int employeeId;

    private String department;

    private SupportRequestRequest supportRequestRequest;

    private SupportRequest supportRequest;

    private int supportRequestId;

    private int managerId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSupportRequestRequest(SupportRequestRequest supportRequestRequest) {
        this.supportRequestRequest = supportRequestRequest;
    }

    public void setSupportRequest(SupportRequest supportRequest) {
        this.supportRequest = supportRequest;
    }

    public void setSupportRequestId(int supportRequestId) {
        this.supportRequestId = supportRequestId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public List<SupportRequestResponse> getAllSupportRequest() {

        List<SupportRequest> supportRequestList = supportRequestRepository.findAll();
        List<SupportRequestResponse> supportRequestResponseList = new ArrayList<SupportRequestResponse>();
        for (SupportRequest supportRequest : supportRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(supportRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(supportRequest.getApprover());
            Optional<Employee> optionalDirector = employeeRepository.findById(supportRequest.getDirectorId());

            SupportRequestResponse supportRequestResponse = new SupportRequestResponse();
            supportRequestResponse = SupportRequestDTO.response(supportRequest,optionalEmployee.get(),optionalManager.get(),optionalDirector.get());
            supportRequestResponseList.add(supportRequestResponse);
        }
        return supportRequestResponseList;
    }

    public List<SupportRequestResponse> getAllSupportRequestByEmployeeId() {
        List<SupportRequest> supportRequestList = supportRequestRepository.findAllByEmployeeId(employeeId);
        List<SupportRequestResponse> supportRequestResponseList = new ArrayList<SupportRequestResponse>();
        for (SupportRequest supportRequest : supportRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(supportRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(supportRequest.getApprover());
            Optional<Employee> optionalDirector = employeeRepository.findById(supportRequest.getDirectorId());

            SupportRequestResponse supportRequestResponse = new SupportRequestResponse();
            supportRequestResponse = SupportRequestDTO.response(supportRequest,optionalEmployee.get(),optionalManager.get(),optionalDirector.get());
            supportRequestResponseList.add(supportRequestResponse);
        }
        return supportRequestResponseList;
    }

    public List<SupportRequestResponse> getAllSupportRequestByManagerId() {
        List<SupportRequest> supportRequestList = supportRequestRepository.findAllByApprover(managerId);
        List<SupportRequestResponse> supportRequestResponseList = new ArrayList<SupportRequestResponse>();
        for (SupportRequest supportRequest : supportRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(supportRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(supportRequest.getApprover());
            Optional<Employee> optionalDirector = employeeRepository.findById(supportRequest.getDirectorId());

            SupportRequestResponse supportRequestResponse = new SupportRequestResponse();
            supportRequestResponse = SupportRequestDTO.response(supportRequest,optionalEmployee.get(),optionalManager.get(),optionalDirector.get());
            supportRequestResponseList.add(supportRequestResponse);
        }
        return supportRequestResponseList;
    }

    public List<SupportRequestResponse> getAllSupportRequestByDepartment() {
        List<SupportRequest> supportRequestList = supportRequestRepository.findAllByDepartment(department);
        List<SupportRequestResponse> supportRequestResponseList = new ArrayList<SupportRequestResponse>();
        for (SupportRequest supportRequest : supportRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(supportRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(supportRequest.getApprover());
            Optional<Employee> optionalDirector = employeeRepository.findById(supportRequest.getDirectorId());

            SupportRequestResponse supportRequestResponse = new SupportRequestResponse();
            supportRequestResponse = SupportRequestDTO.response(supportRequest,optionalEmployee.get(),optionalManager.get(),optionalDirector.get());
            supportRequestResponseList.add(supportRequestResponse);
        }
        return supportRequestResponseList;
    }

    public String addNewSupportRequest() {
        SupportRequest supportRequest = new SupportRequest();
        supportRequest.setEmployeeId(supportRequestRequest.getEmployeeId());
        supportRequest.setDate(supportRequestRequest.getDate());
        supportRequest.setDepartment(supportRequestRequest.getDepartment());
        supportRequest.setReason(supportRequestRequest.getReason());
        supportRequest.setDescribe(supportRequestRequest.getDescribe());
        supportRequestRepository.save(supportRequest);

        return "Added new support request";
    }

    public String editSupportRequest() {
        Optional<SupportRequest> optionalSupportRequest = supportRequestRepository.findById(supportRequest.getSupportRequestId());
        if (!optionalSupportRequest.isPresent()) {
            throw new NotFoundException("support request has id " + supportRequest.getSupportRequestId());
        }

        SupportRequest supportRequestDB = optionalSupportRequest.get();
        supportRequestDB.setEmployeeId(supportRequest.getEmployeeId());
        supportRequestDB.setDate(supportRequest.getDate());
        supportRequestDB.setDepartment(supportRequest.getDepartment());
        supportRequestDB.setApprover(supportRequest.getApprover());
        supportRequestDB.setApproveDate(supportRequest.getApproveDate());
        supportRequestDB.setApproved(supportRequest.isApproved());
        supportRequestDB.setReason(supportRequest.getReason());
        supportRequestDB.setDirectorId(supportRequest.getDirectorId());
        supportRequestDB.setMoney(supportRequest.getMoney());
        supportRequestDB.setStatus(supportRequest.getStatus());
        supportRequestDB.setDescribe(supportRequest.getDescribe());

        supportRequestRepository.save(supportRequestDB);
        return "Support has id " + supportRequest.getSupportRequestId() + " was edited";
    }

    public String deleteSupportRequest() {
        Optional<SupportRequest> optionalSupportRequest = supportRequestRepository.findById(supportRequestId);
        if (!optionalSupportRequest.isPresent()) {
            throw new NotFoundException("support request has id "+ supportRequestId);
        }

        supportRequestRepository.delete(optionalSupportRequest.get());
        return "Support has id " + supportRequestId + " was deleted";
    }
}
