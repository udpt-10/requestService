package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.OTRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTRequestRepository extends JpaRepository<OTRequest, Integer> {
    List<OTRequest> findAllByEmployeeId(int employeeId);
    List<OTRequest> findAllByManagerId(int managerId);
}
