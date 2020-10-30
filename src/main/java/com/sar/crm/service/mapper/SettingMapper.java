package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.SettingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Setting} and its DTO {@link SettingDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SettingMapper extends EntityMapper<SettingDTO, Setting> {



    default Setting fromId(Long id) {
        if (id == null) {
            return null;
        }
        Setting sETTING = new Setting();
        sETTING.setId(id);
        return sETTING;
    }
}
