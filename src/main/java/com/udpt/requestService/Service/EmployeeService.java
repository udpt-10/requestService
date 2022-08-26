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

    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String addNewEmployee() {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if (optionalEmployee.isPresent()) {
            throw new DuplicateException("the employee has id "+employee.getEmployeeId()+" existed in the database of the request service");
        }

        Employee employeeDB = new Employee();
        employeeDB.setEmployeeId(employee.getEmployeeId());
        employeeDB.setEmployeeName(employee.getEmployeeName());
        employeeDB.setUserName(employee.getUserName());
        employeeDB.setPosition(employee.getPosition());
        employeeDB.setSalary(employee.getSalary());
        employeeDB.setLeavingDayBalance(employee.getLeavingDayBalance());
        employeeDB.setAddress(employee.getAddress());
        employeeDB.setEmail(employee.getEmail());
        employeeDB.setDateOfBirth(employee.getDateOfBirth());
        employeeDB.setSex(employee.isSex());
        employeeDB.setInformationSummary(employee.getInformationSummary());
        employeeDB.setDirector(employee.getDirector());
        employeeDB.setManager(employee.getManager());
        employeeDB.setPhone(employee.getPhone());

        employeeRepository.save(employeeDB);
        return "employee has id " + employee.getEmployeeId() + " was added to the database of the request service";
    }

    public String deleteAnEmployee() {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if (!optionalEmployee.isPresent()) {
            throw new NotFoundException("Not found employee has id "+ optionalEmployee.get().getEmployeeId());
        }
        employeeRepository.delete(optionalEmployee.get());
        return "employee has id " + employee.getEmployeeId() + " was deleted to the database of the request service";
    }
}
