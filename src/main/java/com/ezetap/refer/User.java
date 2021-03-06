package com.ezetap.refer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;

    @Column(name="referralCode")
    String referralCode;

    @Column(name="applied")
    Boolean applied;

    @Column(name="mobile_number")
    String mobileNumber;

    @OneToMany
    @JoinColumn(name = "user")
    List<Scratch> scratchCards;

    public User() {
    }

    public User(Integer id, String referralCode, Boolean applied, String mobileNumber, List<Scratch> scratchCards) {
        this.id = id;
        this.referralCode = referralCode;
        this.applied = applied;
        this.mobileNumber = mobileNumber;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
        return getId().equals(user.getId()) && Objects.equals(getReferralCode(), user.getReferralCode()) && Objects.equals(getApplied(), user.getApplied()) && getMobileNumber().equals(user.getMobileNumber()) && Objects.equals(getScratchCards(), user.getScratchCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReferralCode(), getApplied(), getMobileNumber(), getScratchCards());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", referralCode='" + referralCode + '\'' +
                ", applied=" + applied +
                ", mobile_number='" + mobileNumber + '\'' +
                ", scratchCards=" + scratchCards +
                '}';
    }
}
