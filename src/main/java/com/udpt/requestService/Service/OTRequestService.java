package com.udpt.requestService.Service;

import com.udpt.requestService.DTO.OTRequestDTO;
import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Entity.Response.OTResponse;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import com.udpt.requestService.Repository.OTRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OTRequestService {
    @Autowired
    private OTRequestRepository otRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private OTRequestRequest otRequestRequest;

    private OTRequest otRequest;

    private int otRequestId;

    private int employeeId;

    public void setOtRequestRequest(OTRequestRequest otRequestRequest) {
        this.otRequestRequest = otRequestRequest;
    }

    public void setOtRequest(OTRequest otRequest) {
        this.otRequest = otRequest;
    }

    public void setOtRequestId(int otRequestId) {
        this.otRequestId = otRequestId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<OTResponse> getAllOTRequest() {
        List<OTRequest> otRequestList = otRequestRepository.findAll();
        List<OTResponse> otResponseList = new ArrayList<OTResponse>();
        for (OTRequest otRequest : otRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(otRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(otRequest.getManagerId());

            OTResponse otResponse = new OTResponse();
            otResponse = OTRequestDTO.response(otRequest,optionalEmployee.get(),optionalManager.get());
            otResponseList.add(otResponse);
        }
        return otResponseList;
    }
    public List<OTResponse> getAllOTRequestByEmployeeId()  {
        List<OTRequest> otRequestList = otRequestRepository.findAllByEmployeeId(employeeId);
        List<OTResponse> otResponseList = new ArrayList<OTResponse>();
        for (OTRequest otRequest : otRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(otRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(otRequest.getManagerId());

            OTResponse otResponse = new OTResponse();
            otResponse = OTRequestDTO.response(otRequest,optionalEmployee.get(),optionalManager.get());
            otResponseList.add(otResponse);
        }
        return otResponseList;
    }

    public String addNewOtRequest() {
        OTRequest otRequest = new OTRequest();
        otRequest.setEmployeeId(otRequestRequest.getEmployeeId());
        otRequest.setManagerId(otRequestRequest.getManagerId());
        otRequest.setDate(otRequestRequest.getDate());
        otRequest.setHour(otRequestRequest.getHour());
        otRequest.setReason(otRequestRequest.getReason());

        otRequestRepository.save(otRequest);
        return "The OT request was added";
    }

    public String editOTRequest() {
        Optional<OTRequest> optionalOTRequest = otRequestRepository.findById(otRequest.getOtRequestId());
        if (!optionalOTRequest.isPresent()) {
            throw new NotFoundException("Not found OT has Id "+ otRequest.getOtRequestId());
        }

        OTRequest otRequestDB = optionalOTRequest.get();
        otRequestDB.setDate(otRequest.getDate());
        otRequestDB.setHour(otRequest.getHour());
        otRequestDB.setReason(otRequest.getReason());
        otRequestDB.setManagerId(otRequest.getManagerId());
        otRequestDB.setIsApproved(otRequest.getIsApproved());
        otRequestDB.setApproveReason(otRequest.getApproveReason());
        otRequestDB.setApproveDate(otRequest.getApproveDate());

        otRequestRepository.save(otRequestDB);
        return "The OT request was updated successful";
    }

    public String deleteOTRequest() {
        Optional<OTRequest> optionalOTRequest = otRequestRepository.findById(otRequestId);
        if (!optionalOTRequest.isPresent()) {
            throw new NotFoundException("Not found OT has Id "+ otRequestId);
        }

        otRequestRepository.delete(optionalOTRequest.get());
        return "The OT has id " + otRequestId + "was deleted";
    }
}
