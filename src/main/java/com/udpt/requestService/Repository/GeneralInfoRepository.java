package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.GeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralInfoRepository extends JpaRepository<GeneralInfo, Integer> {
}
