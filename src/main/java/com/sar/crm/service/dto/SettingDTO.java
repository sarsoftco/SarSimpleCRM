package com.sar.crm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import com.sar.crm.domain.enumeration.SettingEnum;

/**
 * A DTO for the {@link com.sar.crm.domain.Setting} entity.
 */
public class SettingDTO implements Serializable {

    private Long id;

    @NotNull
    private SettingEnum title;

    @NotNull
    private String value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SettingEnum getTitle() {
        return title;
    }

    public void setTitle(SettingEnum title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SettingDTO)) {
            return false;
        }

        return id != null && id.equals(((SettingDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SETTINGDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
}
