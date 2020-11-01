package com.sar.crm.service;

import com.sar.crm.service.dto.ProvinceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.sar.crm.domain.Province}.
 */
public interface ProvinceService {

    /**
     * Save a province.
     *
     * @param provinceDTO the entity to save.
     * @return the persisted entity.
     */
    ProvinceDTO save(ProvinceDTO provinceDTO);

    /**
     * Get all the provinces.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProvinceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" province.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProvinceDTO> findOne(Long id);

    /**
     * Delete the "id" province.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
