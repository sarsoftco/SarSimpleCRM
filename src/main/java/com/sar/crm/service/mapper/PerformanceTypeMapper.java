package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.PerformanceTypeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PerformanceType} and its DTO {@link PerformanceTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PerformanceTypeMapper extends EntityMapper<PerformanceTypeDTO, PerformanceType> {


    @Mapping(target = "performances", ignore = true)
    @Mapping(target = "removePerformance", ignore = true)
    PerformanceType toEntity(PerformanceTypeDTO performanceTypeDTO);

    default PerformanceType fromId(Long id) {
        if (id == null) {
            return null;
        }
        PerformanceType performanceType = new PerformanceType();
        performanceType.setId(id);
        return performanceType;
    }
}
