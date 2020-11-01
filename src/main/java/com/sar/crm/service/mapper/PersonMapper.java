package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {

    @Mapping(source = "city.id", target = "cityId")
    PersonDTO toDto(Person person);

    @Mapping(target = "jobs", ignore = true)
    @Mapping(target = "removeJob", ignore = true)
    @Mapping(target = "performances", ignore = true)
    @Mapping(target = "removePerformance", ignore = true)
    @Mapping(source = "cityId", target = "city")
    Person toEntity(PersonDTO personDTO);

    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
