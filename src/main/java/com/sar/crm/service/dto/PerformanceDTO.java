package com.sar.crm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sar.crm.domain.Performance} entity.
 */
public class PerformanceDTO implements Serializable {
    
    private Long id;

    private String comment;


    private Long personId;

    private Long performanceTypeId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getPerformanceTypeId() {
        return performanceTypeId;
    }

    public void setPerformanceTypeId(Long performanceTypeId) {
        this.performanceTypeId = performanceTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PerformanceDTO)) {
            return false;
        }

        return id != null && id.equals(((PerformanceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PerformanceDTO{" +
            "id=" + getId() +
            ", comment='" + getComment() + "'" +
            ", personId=" + getPersonId() +
            ", performanceTypeId=" + getPerformanceTypeId() +
            "}";
    }
}
