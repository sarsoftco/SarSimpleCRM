package com.sar.crm.service;

import com.sar.crm.domain.Setting;
import com.sar.crm.repository.SettingRepository;
import com.sar.crm.service.dto.SettingDTO;
import com.sar.crm.service.mapper.SettingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Setting}.
 */
@Service
@Transactional
public class SettingService {

    private final Logger log = LoggerFactory.getLogger(SettingService.class);

    private final SettingRepository sETTINGRepository;

    private final SettingMapper sETTINGMapper;

    public SettingService(SettingRepository sETTINGRepository, SettingMapper sETTINGMapper) {
        this.sETTINGRepository = sETTINGRepository;
        this.sETTINGMapper = sETTINGMapper;
    }

    /**
     * Save a sETTING.
     *
     * @param sETTINGDTO the entity to save.
     * @return the persisted entity.
     */
    public SettingDTO save(SettingDTO sETTINGDTO) {
        log.debug("Request to save SETTING : {}", sETTINGDTO);
        Setting sETTING = sETTINGMapper.toEntity(sETTINGDTO);
        sETTING = sETTINGRepository.save(sETTING);
        return sETTINGMapper.toDto(sETTING);
    }

    /**
     * Get all the sETTINGS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SettingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SETTINGS");
        return sETTINGRepository.findAll(pageable)
            .map(sETTINGMapper::toDto);
    }


    /**
     * Get one sETTING by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SettingDTO> findOne(Long id) {
        log.debug("Request to get SETTING : {}", id);
        return sETTINGRepository.findById(id)
            .map(sETTINGMapper::toDto);
    }

    /**
     * Delete the sETTING by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SETTING : {}", id);
        sETTINGRepository.deleteById(id);
    }
}
