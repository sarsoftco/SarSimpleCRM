package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.CityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link City} and its DTO {@link CityDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProvinceMapper.class})
public interface CityMapper extends EntityMapper<CityDTO, City> {

    @Mapping(source = "province.id", target = "provinceId")
    CityDTO toDto(City city);

    @Mapping(source = "provinceId", target = "province")
    City toEntity(CityDTO cityDTO);

    default City fromId(Long id) {
        if (id == null) {
            return null;
        }
        City city = new City();
        city.setId(id);
        return city;
    }
}
