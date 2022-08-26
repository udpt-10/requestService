package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportRequestRepository extends JpaRepository<SupportRequest, Integer> {
    List<SupportRequest> findAllByEmployeeId (int employeeId);
    List<SupportRequest> findAllByDepartment (String department);
    List<SupportRequest> findAllByApprover (int managerId);
}
