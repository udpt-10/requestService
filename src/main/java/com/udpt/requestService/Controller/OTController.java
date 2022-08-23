package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Entity.Request.OTRequestRequest;
import com.udpt.requestService.Service.OTRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/OTRequest")
public class OTController {
    @Autowired
    private OTRequestService otRequestService;

    @GetMapping("/all")
    public List<OTRequest> getAllOTRequest() {
        return otRequestService.getAllOTRequest();
    }

    @GetMapping("/{employeeId}")
    public List<OTRequest> getAllOTRequestByEmployeeId(@PathVariable int employeeId) {
        otRequestService.setEmployeeId(employeeId);
        return otRequestService.getAllOTRequestByEmployeeId();
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
