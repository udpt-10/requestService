package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.WorkFromHomeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkFromHomeRepository extends JpaRepository<WorkFromHomeRequest, Integer> {
    List<WorkFromHomeRequest> findAllByEmployeeId(int employeeId);
}
