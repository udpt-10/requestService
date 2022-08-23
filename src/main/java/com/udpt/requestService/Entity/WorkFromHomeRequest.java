package com.udpt.requestService.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_from_home_request")
public class WorkFromHomeRequest {

    @Id
    @Column(name = "work_from_home_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workFromHomeRequestId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "date")
    private Date date;

    public WorkFromHomeRequest () {

    }

    public int getWorkFromHomeRequestId() {
        return workFromHomeRequestId;
    }

    public void setWorkFromHomeRequestId(int workFromHomeRequestId) {
        this.workFromHomeRequestId = workFromHomeRequestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
