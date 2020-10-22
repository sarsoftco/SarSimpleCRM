package com.sar.crm.repository;

import com.sar.crm.domain.PerformanceType;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PerformanceType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PerformanceTypeRepository extends JpaRepository<PerformanceType, Long> {
}
