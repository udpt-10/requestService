package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.Request.SupportRequestRequest;
import com.udpt.requestService.Entity.Response.SupportRequestResponse;
import com.udpt.requestService.Entity.SupportRequest;
import com.udpt.requestService.Service.SupportRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/SupportRequest")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportRequestController {
    @Autowired
    private SupportRequestService supportRequestService;

    @GetMapping("/all")
    public List<SupportRequestResponse> getAllSupportRequest() {
        return supportRequestService.getAllSupportRequest();
    }

    @GetMapping("/allByEmployeeId/{employeeId}")
    public List<SupportRequestResponse> getAllSupportRequestByEmployeeId(@PathVariable int employeeId) {
        supportRequestService.setEmployeeId(employeeId);
        return supportRequestService.getAllSupportRequestByEmployeeId();
    }

    @PostMapping("/allByDepartment")
    public List<SupportRequestResponse> getAllSupportRequestByDepartment(@RequestBody String department) {
        supportRequestService.setDepartment(department);
        return supportRequestService.getAllSupportRequestByDepartment();
    }

    @PostMapping("/add")
    public String addNewSupportRequest(@RequestBody SupportRequestRequest supportRequestRequest) {
        supportRequestService.setSupportRequestRequest(supportRequestRequest);
        return supportRequestService.addNewSupportRequest();
    }

    @PostMapping("/edit")
    public String editSupportRequest(@RequestBody SupportRequest supportRequest) {
        supportRequestService.setSupportRequest(supportRequest);
        return supportRequestService.editSupportRequest();
    }

    @PostMapping("/delete")
    public String deleteSupportRequest(@RequestBody int supportRequestId) {
        supportRequestService.setSupportRequestId(supportRequestId);
        return supportRequestService.deleteSupportRequest();
    }
}
