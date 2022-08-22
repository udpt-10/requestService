package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Repository.OTRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OTRequestService {
    @Autowired
    private OTRequestRepository otRequestRepository;

    private OTRequestRequest otRequestRequest;

    public void setOtRequestRequest(OTRequestRequest otRequestRequest) {
        this.otRequestRequest = otRequestRequest;
    }

    public List<OTRequest> getAllOTRequest() {
        return otRequestRepository.findAll();
    }

    public String addNewOtRequest() {
        OTRequest otRequest = new OTRequest();
        otRequest.setEmployeeId(otRequestRequest.getEmployeeId());
        otRequest.setDate(otRequestRequest.getDate());
        otRequest.setHour(otRequestRequest.getHour());
        otRequest.setReason(otRequestRequest.getReason());

        otRequestRepository.save(otRequest);
        return "The OT request was added";
    }
}
