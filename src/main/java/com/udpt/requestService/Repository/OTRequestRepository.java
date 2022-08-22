package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.OTRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTRequestRepository extends JpaRepository<OTRequest, Integer> {
}
