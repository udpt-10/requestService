package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.Request.WorkFromHomeRequestRequest;
import com.udpt.requestService.Entity.Response.WFHResponse;
import com.udpt.requestService.Entity.WorkFromHomeRequest;
import com.udpt.requestService.Service.WorkFromHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/WorkFromHome")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkFromHomeController {
    @Autowired
    private WorkFromHomeService workFromHomeService;

    @GetMapping("/all")
    public List<WFHResponse> getAllWorkFromHome() {
        return workFromHomeService.getAllWorkFromHome();
    }

    @GetMapping("/{employeeId}")
    public List<WFHResponse> getAllWorkFromHomeByEmployeeId(@PathVariable int employeeId) {
        workFromHomeService.setEmployeeId(employeeId);
        return workFromHomeService.getAllWorkFromHomeByEmployeeId();
    }

    @PostMapping("/add")
    public String addNewWorkFromHome(@RequestBody WorkFromHomeRequestRequest workFromHomeRequestRequest) {
        workFromHomeService.setWorkFromHomeRequestRequest(workFromHomeRequestRequest);
        return workFromHomeService.addNewWorkFromHome();
    }

    @PostMapping("/edit")
    public String editWorkFromHome(@RequestBody WorkFromHomeRequest workFromHomeRequest) {
        workFromHomeService.setWorkFromHomeRequest(workFromHomeRequest);
        return workFromHomeService.editWorkFromHome();
    }

    @PostMapping("/delete")
    public String deleteWorkFromHome(@RequestBody int workFromHomeRequestId) {
        workFromHomeService.setWorkFromHomeId(workFromHomeRequestId);
        return workFromHomeService.deleteWorkFromHome();
    }
}
