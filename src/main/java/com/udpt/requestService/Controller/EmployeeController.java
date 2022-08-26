package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public String addNewEmployee(@RequestBody Employee employee) {
        employeeService.setEmployee(employee);
        return employeeService.addNewEmployee();
    }

    @PostMapping("/delete")
    public String deleteAnEmployee(@RequestBody Employee employee) {
        employeeService.setEmployee(employee);
        return employeeService.deleteAnEmployee();
    }
}
