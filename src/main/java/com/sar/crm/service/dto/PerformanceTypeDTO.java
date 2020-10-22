package com.sar.crm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sar.crm.domain.PerformanceType} entity.
 */
public class PerformanceTypeDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String title;

    private String comment;

    
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PerformanceTypeDTO)) {
            return false;
        }

        return id != null && id.equals(((PerformanceTypeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PerformanceTypeDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
