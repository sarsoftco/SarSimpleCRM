package com.sar.crm.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sar.crm.domain.JobHistory} entity.
 */
public class JobHistoryDTO implements Serializable {
    
    private Long id;

    @NotNull
    private ZonedDateTime doDate;

    @NotNull
    private ZonedDateTime expireDate;

    @NotNull
    private String comment;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Integer progressPercent;


    private Long performerId;

    private Long jobId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDoDate() {
        return doDate;
    }

    public void setDoDate(ZonedDateTime doDate) {
        this.doDate = doDate;
    }

    public ZonedDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(ZonedDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Long getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Long personId) {
        this.performerId = personId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobHistoryDTO)) {
            return false;
        }

        return id != null && id.equals(((JobHistoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobHistoryDTO{" +
            "id=" + getId() +
            ", doDate='" + getDoDate() + "'" +
            ", expireDate='" + getExpireDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", progressPercent=" + getProgressPercent() +
            ", performerId=" + getPerformerId() +
            ", jobId=" + getJobId() +
            "}";
    }
}
