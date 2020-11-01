package com.sar.crm.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.sar.crm.domain.enumeration.SexEnum;

/**
 * A DTO for the {@link com.sar.crm.domain.Person} entity.
 */
public class PersonDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String name;

    private ZonedDateTime birthDate;

    private SexEnum sex;

    private String address;

    private String comment;

    private String phone;

    private String mobile;


    private Long cityId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonDTO)) {
            return false;
        }

        return id != null && id.equals(((PersonDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PersonDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", sex='" + getSex() + "'" +
            ", address='" + getAddress() + "'" +
            ", comment='" + getComment() + "'" +
            ", phone='" + getPhone() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", cityId=" + getCityId() +
            "}";
    }
}
