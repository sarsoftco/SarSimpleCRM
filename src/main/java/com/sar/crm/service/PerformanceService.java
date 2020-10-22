package com.sar.crm.service;

import com.sar.crm.domain.Performance;
import com.sar.crm.repository.PerformanceRepository;
import com.sar.crm.service.dto.PerformanceDTO;
import com.sar.crm.service.mapper.PerformanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link Performance}.
 */
@Service
@Transactional
public class PerformanceService {

    private final Logger log = LoggerFactory.getLogger(PerformanceService.class);

    private final PerformanceRepository performanceRepository;

    private final PerformanceMapper performanceMapper;

    public PerformanceService(PerformanceRepository performanceRepository, PerformanceMapper performanceMapper) {
        this.performanceRepository = performanceRepository;
        this.performanceMapper = performanceMapper;
    }

    /**
     * Save a performance.
     *
     * @param performanceDTO the entity to save.
     * @return the persisted entity.
     */
    public PerformanceDTO save(PerformanceDTO performanceDTO) {
        log.debug("Request to save Performance : {}", performanceDTO);
        Performance performance = performanceMapper.toEntity(performanceDTO);
        performance = performanceRepository.save(performance);
        return performanceMapper.toDto(performance);
    }

    /**
     * Get all the performances.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PerformanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Performances");
        return performanceRepository.findAll(pageable)
            .map(performanceMapper::toDto);
    }



    /**
     *  Get all the performances where Job is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<PerformanceDTO> findAllWhereJobIsNull() {
        log.debug("Request to get all performances where Job is null");
        return StreamSupport
            .stream(performanceRepository.findAll().spliterator(), false)
            .filter(performance -> performance.getJob() == null)
            .map(performanceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one performance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PerformanceDTO> findOne(Long id) {
        log.debug("Request to get Performance : {}", id);
        return performanceRepository.findById(id)
            .map(performanceMapper::toDto);
    }

    /**
     * Delete the performance by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Performance : {}", id);
        performanceRepository.deleteById(id);
    }
}
