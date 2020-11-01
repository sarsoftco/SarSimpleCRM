package com.sar.crm.service.impl;

import com.sar.crm.service.ProvinceService;
import com.sar.crm.domain.Province;
import com.sar.crm.repository.ProvinceRepository;
import com.sar.crm.service.dto.ProvinceDTO;
import com.sar.crm.service.mapper.ProvinceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Province}.
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    private final Logger log = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    private final ProvinceRepository provinceRepository;

    private final ProvinceMapper provinceMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ProvinceMapper provinceMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
    }

    @Override
    public ProvinceDTO save(ProvinceDTO provinceDTO) {
        log.debug("Request to save Province : {}", provinceDTO);
        Province province = provinceMapper.toEntity(provinceDTO);
        province = provinceRepository.save(province);
        return provinceMapper.toDto(province);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProvinceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Provinces");
        return provinceRepository.findAll(pageable)
            .map(provinceMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinceDTO> findOne(Long id) {
        log.debug("Request to get Province : {}", id);
        return provinceRepository.findById(id)
            .map(provinceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Province : {}", id);
        provinceRepository.deleteById(id);
    }
}
