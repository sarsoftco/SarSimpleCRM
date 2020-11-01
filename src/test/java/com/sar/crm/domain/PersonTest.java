package com.sar.crm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sar.crm.web.rest.TestUtil;

public class PersonTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Person.class);
        Person person1 = new Person();
        person1.setId(1L);
        Person person2 = new Person();
        person2.setId(person1.getId());
        assertThat(person1).isEqualTo(person2);
        person2.setId(2L);
        assertThat(person1).isNotEqualTo(person2);
        person1.setId(null);
        assertThat(person1).isNotEqualTo(person2);
    }
}
