package com.ezetap.refer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String referralCode;
    Boolean applied;

    @OneToMany
    @JoinColumn(name = "user")
    List<Scratch> scratchCards;

    public User() {
    }

    public User(Integer id, String referralCode, Boolean applied, List<Scratch> scratchCards) {
        this.id = id;
        this.referralCode = referralCode;
        this.applied = applied;
        this.scratchCards = scratchCards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
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
        return Objects.equals(getId(), user.getId()) && Objects.equals(getReferralCode(), user.getReferralCode()) && Objects.equals(getApplied(), user.getApplied()) && Objects.equals(getScratchCards(), user.getScratchCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReferralCode(), getApplied(), getScratchCards());
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", referalCode='" + referralCode + '\'' +
                ", applied=" + applied +
                ", scratchCards=" + scratchCards +
                '}';
    }
}
