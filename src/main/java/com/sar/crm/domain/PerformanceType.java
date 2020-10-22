package com.sar.crm.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A PerformanceType.
 */
@Entity
@Table(name = "performance_type")
public class PerformanceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "performanceType")
    private Set<Performance> performances = new HashSet<>();

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

    public PerformanceType title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public PerformanceType comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public PerformanceType performances(Set<Performance> performances) {
        this.performances = performances;
        return this;
    }

    public PerformanceType addPerformance(Performance performance) {
        this.performances.add(performance);
        performance.setPerformanceType(this);
        return this;
    }

    public PerformanceType removePerformance(Performance performance) {
        this.performances.remove(performance);
        performance.setPerformanceType(null);
        return this;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PerformanceType)) {
            return false;
        }
        return id != null && id.equals(((PerformanceType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PerformanceType{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
