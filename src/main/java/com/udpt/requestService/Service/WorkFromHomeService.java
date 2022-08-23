package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.Request.WorkFromHomeRequestRequest;
import com.udpt.requestService.Entity.WorkFromHomeRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.WorkFromHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkFromHomeService {
    @Autowired
    private WorkFromHomeRepository workFromHomeRepository;

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

    public List<WorkFromHomeRequest> getAllWorkFromHome() {
        return workFromHomeRepository.findAll();
    }

    public List<WorkFromHomeRequest> getAllWorkFromHomeByEmployeeId() {
        return workFromHomeRepository.findAllByEmployeeId(employeeId);
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
