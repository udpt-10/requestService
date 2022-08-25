package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.Request.SupportRequestRequest;
import com.udpt.requestService.Entity.SupportRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.SupportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportRequestService {
    @Autowired
    private SupportRequestRepository supportRequestRepository;

    private int employeeId;

    private String department;

    private SupportRequestRequest supportRequestRequest;

    private SupportRequest supportRequest;

    private int supportRequestId;

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

    public List<SupportRequest> getAllSupportRequest() {
        return supportRequestRepository.findAll();
    }

    public List<SupportRequest> getAllSupportRequestByEmployeeId() {
        return supportRequestRepository.findAllByEmployeeId(employeeId);
    }

    public List<SupportRequest> getAllSupportRequestByDepartment() {
        return supportRequestRepository.findAllByDepartment(department);
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
