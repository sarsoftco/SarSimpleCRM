package com.sar.crm.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sar.crm.domain.Product} entity.
 */
public class ProductDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String title;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            "}";
    }
}
