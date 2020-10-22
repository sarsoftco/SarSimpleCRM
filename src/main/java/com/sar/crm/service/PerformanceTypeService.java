package com.sar.crm.service;

import com.sar.crm.domain.PerformanceType;
import com.sar.crm.repository.PerformanceTypeRepository;
import com.sar.crm.service.dto.PerformanceTypeDTO;
import com.sar.crm.service.mapper.PerformanceTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PerformanceType}.
 */
@Service
@Transactional
public class PerformanceTypeService {

    private final Logger log = LoggerFactory.getLogger(PerformanceTypeService.class);

    private final PerformanceTypeRepository performanceTypeRepository;

    private final PerformanceTypeMapper performanceTypeMapper;

    public PerformanceTypeService(PerformanceTypeRepository performanceTypeRepository, PerformanceTypeMapper performanceTypeMapper) {
        this.performanceTypeRepository = performanceTypeRepository;
        this.performanceTypeMapper = performanceTypeMapper;
    }

    /**
     * Save a performanceType.
     *
     * @param performanceTypeDTO the entity to save.
     * @return the persisted entity.
     */
    public PerformanceTypeDTO save(PerformanceTypeDTO performanceTypeDTO) {
        log.debug("Request to save PerformanceType : {}", performanceTypeDTO);
        PerformanceType performanceType = performanceTypeMapper.toEntity(performanceTypeDTO);
        performanceType = performanceTypeRepository.save(performanceType);
        return performanceTypeMapper.toDto(performanceType);
    }

    /**
     * Get all the performanceTypes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PerformanceTypeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PerformanceTypes");
        return performanceTypeRepository.findAll(pageable)
            .map(performanceTypeMapper::toDto);
    }


    /**
     * Get one performanceType by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PerformanceTypeDTO> findOne(Long id) {
        log.debug("Request to get PerformanceType : {}", id);
        return performanceTypeRepository.findById(id)
            .map(performanceTypeMapper::toDto);
    }

    /**
     * Delete the performanceType by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PerformanceType : {}", id);
        performanceTypeRepository.deleteById(id);
    }
}
