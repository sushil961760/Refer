package com.ezetap.refer;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="scratch")
public class Scratch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer Id;

    @Column(name="isScratched")
    Boolean isScratched;

    @Column(name="amount")
    Integer amount;

    @Column(name="createdTS")
    String createdTS;

    @Column(name="transaction_ID")
    String transaction_ID;

    @Column(name = "user_id")
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Scratch() {
    }

    public Scratch(Integer id, Boolean isScratched, Integer amount, String createdTS, String transaction_ID,String user) {
        Id = id;
        this.isScratched = isScratched;
        this.amount = amount;
        this.createdTS = createdTS;
        this.transaction_ID = transaction_ID;
        this.userId = user;
    }

    public Scratch(boolean b, int random, String yes, String random1, User u2) {
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Boolean getScratched() {
        return isScratched;
    }

    public void setScratched(Boolean scratched) {
        isScratched = scratched;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(String createdTS) {
        this.createdTS = createdTS;
    }

    public String getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(String transaction_ID) {
        this.transaction_ID = transaction_ID;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scratch)) return false;
        Scratch scratch = (Scratch) o;
        return getId().equals(scratch.getId()) && Objects.equals(isScratched, scratch.isScratched) && Objects.equals(getAmount(), scratch.getAmount()) && Objects.equals(getCreatedTS(), scratch.getCreatedTS()) && Objects.equals(getTransaction_ID(), scratch.getTransaction_ID()) && Objects.equals(getUserId(), scratch.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isScratched, getAmount(), getCreatedTS(), getTransaction_ID(), getUserId());
    }

    @Override
    public String toString() {
        return "Scratch{" +
                "Id=" + Id +
                ", isScratched=" + isScratched +
                ", amount=" + amount +
                ", createdTS='" + createdTS + '\'' +
                ", transaction_ID='" + transaction_ID + '\'' +
                ", user=" + userId +
                '}';
    }
}
