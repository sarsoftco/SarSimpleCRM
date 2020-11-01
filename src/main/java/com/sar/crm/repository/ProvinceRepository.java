package com.sar.crm.repository;

import com.sar.crm.domain.Province;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Province entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
