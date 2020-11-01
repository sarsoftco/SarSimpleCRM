package com.sar.crm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sar.crm.web.rest.TestUtil;

public class ProvinceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Province.class);
        Province province1 = new Province();
        province1.setId(1L);
        Province province2 = new Province();
        province2.setId(province1.getId());
        assertThat(province1).isEqualTo(province2);
        province2.setId(2L);
        assertThat(province1).isNotEqualTo(province2);
        province1.setId(null);
        assertThat(province1).isNotEqualTo(province2);
    }
}
