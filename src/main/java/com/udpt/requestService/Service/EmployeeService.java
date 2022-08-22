package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.HandleException.DuplicateException;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private int employeeId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String addNewEmployee() {
        Employee employee = new Employee();

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            throw new DuplicateException("the employee has id "+employeeId+" existed in the database of the request service");
        }
        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);
        return "employee has id " + employeeId + " was added to the database of the request service";
    }

    public String deleteAnEmployee() {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (!optionalEmployee.isPresent()) {
            throw new NotFoundException("Not found employee has id "+ optionalEmployee.get().getEmployeeId());
        }
        employeeRepository.delete(optionalEmployee.get());
        return "employee has id " + employeeId + " was deleted to the database of the request service";
    }
}
