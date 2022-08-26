package com.udpt.requestService.Service;

import com.udpt.requestService.DTO.LeaveRequestDTO;
import com.udpt.requestService.DTO.WFHDTO;
import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.Request.WorkFromHomeRequestRequest;
import com.udpt.requestService.Entity.Response.LeaveResponse;
import com.udpt.requestService.Entity.Response.WFHResponse;
import com.udpt.requestService.Entity.WorkFromHomeRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import com.udpt.requestService.Repository.WorkFromHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkFromHomeService {
    @Autowired
    private WorkFromHomeRepository workFromHomeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private int employeeId;

    private WorkFromHomeRequestRequest workFromHomeRequestRequest;

    private WorkFromHomeRequest workFromHomeRequest;

    private int workFromHomeId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setWorkFromHomeRequestRequest(WorkFromHomeRequestRequest workFromHomeRequestRequest) {
        this.workFromHomeRequestRequest = workFromHomeRequestRequest;
    }

    public void setWorkFromHomeRequest(WorkFromHomeRequest workFromHomeRequest) {
        this.workFromHomeRequest = workFromHomeRequest;
    }

    public void setWorkFromHomeId(int workFromHomeId) {
        this.workFromHomeId = workFromHomeId;
    }

    public List<WFHResponse> getAllWorkFromHome() {
        List <WorkFromHomeRequest> workFromHomeRequestList = workFromHomeRepository.findAll();
        List<WFHResponse> wfhResponseList = new ArrayList<WFHResponse>();
        for (WorkFromHomeRequest workFromHomeRequest : workFromHomeRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(workFromHomeRequest.getEmployeeId());

            WFHResponse wfhResponse = new WFHResponse();
            wfhResponse = WFHDTO.response(workFromHomeRequest,optionalEmployee.get());
            wfhResponseList.add(wfhResponse);
        }
        return wfhResponseList;
    }

    public List<WFHResponse> getAllWorkFromHomeByEmployeeId() {
        List<WorkFromHomeRequest> workFromHomeRequestList = workFromHomeRepository.findAllByEmployeeId(employeeId);
        List<WFHResponse> wfhResponseList = new ArrayList<WFHResponse>();
        for (WorkFromHomeRequest workFromHomeRequest : workFromHomeRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(workFromHomeRequest.getEmployeeId());

            WFHResponse wfhResponse = new WFHResponse();
            wfhResponse = WFHDTO.response(workFromHomeRequest,optionalEmployee.get());
            wfhResponseList.add(wfhResponse);
        }
        return wfhResponseList;
    }

    public String addNewWorkFromHome() {
        WorkFromHomeRequest workFromHomeRequest = new WorkFromHomeRequest();
        workFromHomeRequest.setEmployeeId(workFromHomeRequestRequest.getEmployeeId());
        workFromHomeRequest.setDate(workFromHomeRequestRequest.getDate());
        workFromHomeRepository.save(workFromHomeRequest);
        return "Work from home was added";
    }

    public String editWorkFromHome() {
        Optional<WorkFromHomeRequest> optionalWorkFromHomeRequest
                = workFromHomeRepository.findById(workFromHomeRequest.getWorkFromHomeRequestId());
        if (!optionalWorkFromHomeRequest.isPresent()) {
            throw new NotFoundException("work from home has id " + workFromHomeRequest.getWorkFromHomeRequestId());
        }
        WorkFromHomeRequest workFromHomeRequestDB = optionalWorkFromHomeRequest.get();
        workFromHomeRequestDB.setDate(workFromHomeRequest.getDate());
        workFromHomeRepository.save(workFromHomeRequest);
        return "Work from home has id " + workFromHomeRequest.getWorkFromHomeRequestId() + " was edited";
    }

    public String deleteWorkFromHome() {
        Optional<WorkFromHomeRequest> optionalWorkFromHomeRequest = workFromHomeRepository.findById(workFromHomeId);
        if (!optionalWorkFromHomeRequest.isPresent()) {
            throw new NotFoundException("work from home has id "+ workFromHomeId);
        }
        workFromHomeRepository.deleteById(workFromHomeId);
        return "Work from home has id "+ workFromHomeId + " was deleted";
    }
}
