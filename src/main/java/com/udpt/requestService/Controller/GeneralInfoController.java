package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.GeneralInfo;
import com.udpt.requestService.Entity.Request.GeneralInfoRequest;
import com.udpt.requestService.Entity.Response.GeneralInfoResponse;
import com.udpt.requestService.Service.GeneralInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/GeneralInfo")
public class GeneralInfoController {
    @Autowired
    private GeneralInfoService generalInfoService;

    @GetMapping("/all")
    public List<GeneralInfoResponse> getAllGeneralInfo() {
        return generalInfoService.getAllGeneralInfo();
    }

    @GetMapping("/{generalInfoId}")
    public GeneralInfoResponse getGeneralInfoByGeneralInfoId(@PathVariable int generalInfoId) {
        generalInfoService.setGeneralInfoId(generalInfoId);
        return generalInfoService.getGeneralInfoByGeneralInfoId();
    }

    @PostMapping("/add")
    public String addNewGeneralInfo(@RequestBody GeneralInfoRequest generalInfoRequest) {
        generalInfoService.setGeneralInfoRequest(generalInfoRequest);
        return generalInfoService.addNewGeneralInfo();
    }

    @PostMapping("/edit")
    public String editGeneralInf(@RequestBody GeneralInfo generalInfo) {
        generalInfoService.setGeneralInfo(generalInfo);
        return generalInfoService.editGeneralInfo();
    }

    @PostMapping("/delete")
    public String deleteGeneralInfo(@RequestBody int generalInfoId) {
        generalInfoService.setGeneralInfoId(generalInfoId);
        return generalInfoService.deleteGeneralInfo();
    }
}
