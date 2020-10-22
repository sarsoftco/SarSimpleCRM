package com.sar.crm.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.sar.crm.domain.enumeration.PriorityEnum;

/**
 * A DTO for the {@link com.sar.crm.domain.Job} entity.
 */
public class JobDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private ZonedDateTime createDate;

    @NotNull
    private ZonedDateTime doneDate;

    private String comment;

    private PriorityEnum periority;


    private Long performanceId;

    private Long creatorId;
    
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

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(ZonedDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PriorityEnum getPeriority() {
        return periority;
    }

    public void setPeriority(PriorityEnum periority) {
        this.periority = periority;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long personId) {
        this.creatorId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobDTO)) {
            return false;
        }

        return id != null && id.equals(((JobDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", doneDate='" + getDoneDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", periority='" + getPeriority() + "'" +
            ", performanceId=" + getPerformanceId() +
            ", creatorId=" + getCreatorId() +
            "}";
    }
}
