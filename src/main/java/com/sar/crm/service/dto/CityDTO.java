package com.sar.crm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sar.crm.domain.City} entity.
 */
public class CityDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String title;


    private Long provinceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CityDTO)) {
            return false;
        }

        return id != null && id.equals(((CityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CityDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", provinceId=" + getProvinceId() +
            "}";
    }
}
