package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.ProvinceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Province} and its DTO {@link ProvinceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProvinceMapper extends EntityMapper<ProvinceDTO, Province> {



    default Province fromId(Long id) {
        if (id == null) {
            return null;
        }
        Province province = new Province();
        province.setId(id);
        return province;
    }
}
