package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.PerformanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Performance} and its DTO {@link PerformanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, PerformanceTypeMapper.class})
public interface PerformanceMapper extends EntityMapper<PerformanceDTO, Performance> {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "performanceType.id", target = "performanceTypeId")
    PerformanceDTO toDto(Performance performance);

    @Mapping(target = "job", ignore = true)
    @Mapping(source = "personId", target = "person")
    @Mapping(source = "performanceTypeId", target = "performanceType")
    Performance toEntity(PerformanceDTO performanceDTO);

    default Performance fromId(Long id) {
        if (id == null) {
            return null;
        }
        Performance performance = new Performance();
        performance.setId(id);
        return performance;
    }
}
