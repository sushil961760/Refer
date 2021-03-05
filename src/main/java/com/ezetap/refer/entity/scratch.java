package com.ezetap.refer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class scratch {

    @Id
    Integer Id;

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
