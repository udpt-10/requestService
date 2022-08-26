package com.udpt.requestService.Service;

import com.udpt.requestService.DTO.LeaveRequestDTO;
import com.udpt.requestService.DTO.OTRequestDTO;
import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.LeaveRequestRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Entity.Response.LeaveResponse;
import com.udpt.requestService.Entity.Response.OTResponse;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import com.udpt.requestService.Repository.LeaveRequestRepository;
import com.udpt.requestService.Repository.OTRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private LeaveRequestRequest leaveRequestRequest;

    private LeaveRequest leaveRequest;

    private int leaveRequestId;

    private int employeeId;

    public void setLeaveRequestRequest(LeaveRequestRequest leaveRequestRequest) {
        this.leaveRequestRequest = leaveRequestRequest;
    }

    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }

    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<LeaveResponse> getAllLeaveRequest() {
        List<LeaveRequest> leaveRequestList = leaveRequestRepository.findAll();
        List<LeaveResponse> leaveResponseList = new ArrayList<LeaveResponse>();
        for (LeaveRequest leaveRequest : leaveRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(leaveRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(leaveRequest.getManagerId());

            LeaveResponse leaveResponse = new LeaveResponse();
            leaveResponse = LeaveRequestDTO.response(leaveRequest,optionalEmployee.get(),optionalManager.get());
            leaveResponseList.add(leaveResponse);
        }
        return leaveResponseList;
    }

    public List<LeaveResponse> getAllLeaveRequestByEmployeeId()  {
        List<LeaveRequest> leaveRequestList = leaveRequestRepository.findAllByEmployeeId(employeeId);
        List<LeaveResponse> leaveResponseList = new ArrayList<LeaveResponse>();
        for (LeaveRequest leaveRequest : leaveRequestList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(leaveRequest.getEmployeeId());
            Optional<Employee> optionalManager = employeeRepository.findById(leaveRequest.getManagerId());

            LeaveResponse leaveResponse = new LeaveResponse();
            leaveResponse = LeaveRequestDTO.response(leaveRequest,optionalEmployee.get(),optionalManager.get());
            leaveResponseList.add(leaveResponse);
        }
        return leaveResponseList;
    }

    public String addNewLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(leaveRequestRequest.getEmployeeId());
        leaveRequest.setDate(leaveRequestRequest.getDate());
        leaveRequest.setHour(leaveRequestRequest.getHour());
        leaveRequest.setReason(leaveRequestRequest.getReason());
        leaveRequest.setManagerId(leaveRequestRequest.getManagerId());

        leaveRequestRepository.save(leaveRequest);
        return "The leave request was added";
    }

    public String editLeaveRequest() {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(leaveRequest.getLeaveRequestId());
        if (!optionalLeaveRequest.isPresent()) {
            throw new NotFoundException("Not found leave has Id "+ leaveRequest.getLeaveRequestId());
        }

        LeaveRequest leaveRequestDB = optionalLeaveRequest.get();
        leaveRequestDB.setDate(leaveRequest.getDate());
        leaveRequestDB.setHour(leaveRequest.getHour());
        leaveRequestDB.setReason(leaveRequest.getReason());
        leaveRequestDB.setManagerId(leaveRequest.getManagerId());
        leaveRequestDB.setIsApproved(leaveRequest.getIsApproved());
        leaveRequestDB.setApproveReason(leaveRequest.getApproveReason());
        leaveRequestDB.setApproveDate(leaveRequest.getApproveDate());

        leaveRequestRepository.save(leaveRequestDB);
        return "The leave request was updated successful";
    }

    public String deleteLeaveRequest() {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(leaveRequestId);
        if (!optionalLeaveRequest.isPresent()) {
            throw new NotFoundException("Not found OT has Id "+ leaveRequestId);
        }

        leaveRequestRepository.delete(optionalLeaveRequest.get());
        return "The leave has id " + leaveRequestId + "was deleted";
    }
}
