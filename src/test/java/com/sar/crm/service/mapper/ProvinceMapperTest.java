package com.sar.crm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProvinceMapperTest {

    private ProvinceMapper provinceMapper;

    @BeforeEach
    public void setUp() {
        provinceMapper = new ProvinceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(provinceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(provinceMapper.fromId(null)).isNull();
    }
}
