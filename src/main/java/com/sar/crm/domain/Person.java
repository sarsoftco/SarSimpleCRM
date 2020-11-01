package com.sar.crm.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import com.sar.crm.domain.enumeration.SexEnum;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date")
    private ZonedDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @OneToMany(mappedBy = "creator")
    private Set<Job> jobs = new HashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<Performance> performances = new HashSet<>();

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private City city;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBirthDate() {
        return birthDate;
    }

    public Person birthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public SexEnum getSex() {
        return sex;
    }

    public Person sex(SexEnum sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public Person address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public Person comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public Person phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public Person mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public Person jobs(Set<Job> jobs) {
        this.jobs = jobs;
        return this;
    }

    public Person addJob(Job job) {
        this.jobs.add(job);
        job.setCreator(this);
        return this;
    }

    public Person removeJob(Job job) {
        this.jobs.remove(job);
        job.setCreator(null);
        return this;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public Person performances(Set<Performance> performances) {
        this.performances = performances;
        return this;
    }

    public Person addPerformance(Performance performance) {
        this.performances.add(performance);
        performance.setPerson(this);
        return this;
    }

    public Person removePerformance(Performance performance) {
        this.performances.remove(performance);
        performance.setPerson(null);
        return this;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }

    public City getCity() {
        return city;
    }

    public Person city(City city) {
        this.city = city;
        return this;
    }

    public void setCity(City city) {
        this.city = city;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", sex='" + getSex() + "'" +
            ", address='" + getAddress() + "'" +
            ", comment='" + getComment() + "'" +
            ", phone='" + getPhone() + "'" +
            ", mobile='" + getMobile() + "'" +
            "}";
    }
}
