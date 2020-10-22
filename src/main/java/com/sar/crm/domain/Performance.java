package com.sar.crm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Performance.
 */
@Entity
@Table(name = "performance")
public class Performance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "performance")
    @JsonIgnore
    private Job job;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "performances", allowSetters = true)
    private Person person;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "performances", allowSetters = true)
    private PerformanceType performanceType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public Performance comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Job getJob() {
        return job;
    }

    public Performance job(Job job) {
        this.job = job;
        return this;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Person getPerson() {
        return person;
    }

    public Performance person(Person person) {
        this.person = person;
        return this;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PerformanceType getPerformanceType() {
        return performanceType;
    }

    public Performance performanceType(PerformanceType performanceType) {
        this.performanceType = performanceType;
        return this;
    }

    public void setPerformanceType(PerformanceType performanceType) {
        this.performanceType = performanceType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Performance)) {
            return false;
        }
        return id != null && id.equals(((Performance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Performance{" +
            "id=" + getId() +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
