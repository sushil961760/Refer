package com.ezetap.refer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    Integer Id;

    String referalCode;
    Boolean applied;

    @OneToMany
    @JoinColumn(name = "user")
    List<Scratch> scratchCards;

    public User() {
    }

    public User(Integer id, String referalCode, Boolean applied, List<Scratch> scratchCards) {
        Id = id;
        this.referalCode = referalCode;
        this.applied = applied;
        this.scratchCards = scratchCards;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }

    public Boolean getApplied() {
        return applied;
    }

    public void setApplied(Boolean applied) {
        this.applied = applied;
    }

    public List<Scratch> getScratchCards() {
        return scratchCards;
    }

    public void setScratchCards(List<Scratch> scratchCards) {
        this.scratchCards = scratchCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getReferalCode(), user.getReferalCode()) && Objects.equals(getApplied(), user.getApplied()) && Objects.equals(getScratchCards(), user.getScratchCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReferalCode(), getApplied(), getScratchCards());
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", referalCode='" + referalCode + '\'' +
                ", applied=" + applied +
                ", scratchCards=" + scratchCards +
                '}';
    }
}
