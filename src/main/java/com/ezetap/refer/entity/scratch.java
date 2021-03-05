package com.ezetap.refer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="scratch")
public class scratch {

    @Id
    @Column(name="id")
    Integer Id;

    @Column(name="status")
    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public scratch(Integer id) {
        Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof scratch)) return false;
        scratch scratch = (scratch) o;
        return Objects.equals(getId(), scratch.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
