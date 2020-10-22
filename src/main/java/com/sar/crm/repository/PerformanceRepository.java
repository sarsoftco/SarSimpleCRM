package com.sar.crm.repository;

import com.sar.crm.domain.Performance;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Performance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
