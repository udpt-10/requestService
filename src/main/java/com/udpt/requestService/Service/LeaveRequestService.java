package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.LeaveRequestRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.LeaveRequestRepository;
import com.udpt.requestService.Repository.OTRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

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

    public List<LeaveRequest> getAllLeaveRequest() {
        return leaveRequestRepository.findAll();
    }

    public List<LeaveRequest> getAllLeaveRequestByEmployeeId()  {
        return leaveRequestRepository.findAllByEmployeeId(employeeId);
    }

    public String addNewLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(leaveRequestRequest.getEmployeeId());
        leaveRequest.setDate(leaveRequestRequest.getDate());
        leaveRequest.setHour(leaveRequestRequest.getHour());
        leaveRequest.setReason(leaveRequestRequest.getReason());

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
