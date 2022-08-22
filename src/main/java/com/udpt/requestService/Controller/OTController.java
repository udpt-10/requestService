package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.OTRequest;
import com.udpt.requestService.Service.OTRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/add")
//    public String
}
