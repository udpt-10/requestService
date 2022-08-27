package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.LeaveRequest;
import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.LeaveRequestRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Service.LeaveRequestService;
import com.udpt.requestService.Service.OTRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/LeaveRequest")
//@CrossOrigin(origins = "http://localhost:3000")
public class LeaveController {
    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaveRequest() {
        return leaveRequestService.getAllLeaveRequest();
    }

    @GetMapping("/{employeeId}")
    public List<LeaveRequest> getAllLeaveRequestByEmployeeId(@PathVariable int employeeId) {
        leaveRequestService.setEmployeeId(employeeId);
        return leaveRequestService.getAllLeaveRequestByEmployeeId();
    }

    @PostMapping("/add")
    public String addNewLeaveRequest (@RequestBody LeaveRequestRequest leaveRequestRequest) {
        leaveRequestService.setLeaveRequestRequest(leaveRequestRequest);
        return leaveRequestService.addNewLeaveRequest();
    }

    @PostMapping("/edit")
    public String editLeaveRequest (@RequestBody LeaveRequest leaveRequest) {
        leaveRequestService.setLeaveRequest(leaveRequest);
        return leaveRequestService.editLeaveRequest();
    }

    @PostMapping("/delete")
    public String deleteLeaveRequest(@RequestBody int leaveRequestId) {
        leaveRequestService.setLeaveRequestId(leaveRequestId);
        return leaveRequestService.deleteLeaveRequest();
    }
}
