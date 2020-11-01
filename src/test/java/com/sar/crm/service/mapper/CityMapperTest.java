package com.sar.crm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CityMapperTest {

    private CityMapper cityMapper;

    @BeforeEach
    public void setUp() {
        cityMapper = new CityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(cityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(cityMapper.fromId(null)).isNull();
    }
}
