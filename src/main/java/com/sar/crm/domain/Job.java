package com.sar.crm.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import com.sar.crm.domain.enumeration.PriorityEnum;

/**
 * A Job.
 */
@Entity
@Table(name = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    @NotNull
    @Column(name = "done_date", nullable = false)
    private ZonedDateTime doneDate;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "periority")
    private PriorityEnum periority;

    @OneToOne
    @JoinColumn(unique = true)
    private Performance performance;

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "jobs", allowSetters = true)
    private Person creator;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Job title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Job createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getDoneDate() {
        return doneDate;
    }

    public Job doneDate(ZonedDateTime doneDate) {
        this.doneDate = doneDate;
        return this;
    }

    public void setDoneDate(ZonedDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public String getComment() {
        return comment;
    }

    public Job comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PriorityEnum getPeriority() {
        return periority;
    }

    public Job periority(PriorityEnum periority) {
        this.periority = periority;
        return this;
    }

    public void setPeriority(PriorityEnum periority) {
        this.periority = periority;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Job performance(Performance performance) {
        this.performance = performance;
        return this;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public Job jobHistories(Set<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
        return this;
    }

    public Job addJobHistory(JobHistory jobHistory) {
        this.jobHistories.add(jobHistory);
        jobHistory.setJob(this);
        return this;
    }

    public Job removeJobHistory(JobHistory jobHistory) {
        this.jobHistories.remove(jobHistory);
        jobHistory.setJob(null);
        return this;
    }

    public void setJobHistories(Set<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    public Person getCreator() {
        return creator;
    }

    public Job creator(Person person) {
        this.creator = person;
        return this;
    }

    public void setCreator(Person person) {
        this.creator = person;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        return id != null && id.equals(((Job) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Job{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", doneDate='" + getDoneDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", periority='" + getPeriority() + "'" +
            "}";
    }
}
