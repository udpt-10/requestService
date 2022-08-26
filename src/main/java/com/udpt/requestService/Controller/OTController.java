package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Entity.Response.LeaveResponse;
import com.udpt.requestService.Entity.Response.OTResponse;
import com.udpt.requestService.Service.OTRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "*", maxAge = 4800, allowCredentials = "false" )
@Controller
@RestController

@RequestMapping("/OTRequest")

public class OTController {
    @Autowired
    private OTRequestService otRequestService;

    @GetMapping("/all")
    public List<OTResponse> getAllOTRequest() {
        return otRequestService.getAllOTRequest();
    }

    @GetMapping("/{employeeId}")
    public List<OTResponse> getAllOTRequestByEmployeeId(@PathVariable int employeeId) {
        otRequestService.setEmployeeId(employeeId);
        return otRequestService.getAllOTRequestByEmployeeId();
    }

    @GetMapping("/managerId/{managerId}")
    public List<OTResponse> getAllLeaveRequestByManagerId(@PathVariable int managerId) {
        otRequestService.setManagerId(managerId);
        return otRequestService.getAllOTRequestByManagerId();
    }

    @PostMapping("/add")
    public String addNewOTRequest (@RequestBody OTRequestRequest otRequestRequest) {
        otRequestService.setOtRequestRequest(otRequestRequest);
        return otRequestService.addNewOtRequest();
    }

    @PostMapping("/edit")
    public String editOTRequest (@RequestBody OTRequest otRequest) {
        otRequestService.setOtRequest(otRequest);
        return otRequestService.editOTRequest();
    }

    @PostMapping("/delete")
    public String deleteOTRequest(@RequestBody int otRequestId) {
        otRequestService.setOtRequestId(otRequestId);
        return otRequestService.deleteOTRequest();
    }
}
