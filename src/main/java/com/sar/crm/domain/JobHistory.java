package com.sar.crm.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A JobHistory.
 */
@Entity
@Table(name = "job_history")
public class JobHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "do_date", nullable = false)
    private ZonedDateTime doDate;

    @NotNull
    @Column(name = "expire_date", nullable = false)
    private ZonedDateTime expireDate;

    @NotNull
    @Column(name = "comment", nullable = false)
    private String comment;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    @Column(name = "progress_percent", nullable = false)
    private Integer progressPercent;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Person performer;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "jobHistories", allowSetters = true)
    private Job job;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDoDate() {
        return doDate;
    }

    public JobHistory doDate(ZonedDateTime doDate) {
        this.doDate = doDate;
        return this;
    }

    public void setDoDate(ZonedDateTime doDate) {
        this.doDate = doDate;
    }

    public ZonedDateTime getExpireDate() {
        return expireDate;
    }

    public JobHistory expireDate(ZonedDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public void setExpireDate(ZonedDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getComment() {
        return comment;
    }

    public JobHistory comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public JobHistory progressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
        return this;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Person getPerformer() {
        return performer;
    }

    public JobHistory performer(Person person) {
        this.performer = person;
        return this;
    }

    public void setPerformer(Person person) {
        this.performer = person;
    }

    public Job getJob() {
        return job;
    }

    public JobHistory job(Job job) {
        this.job = job;
        return this;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobHistory)) {
            return false;
        }
        return id != null && id.equals(((JobHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobHistory{" +
            "id=" + getId() +
            ", doDate='" + getDoDate() + "'" +
            ", expireDate='" + getExpireDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", progressPercent=" + getProgressPercent() +
            "}";
    }
}
