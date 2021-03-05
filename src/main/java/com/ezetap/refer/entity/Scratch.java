package com.ezetap.refer.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="scratch")
public class Scratch {

    @Id
    @Column(name="id")
    Integer Id;
    Boolean isScratched;
    Integer amount;
    String createdTS;
    String transaction_ID;

    @ManyToOne
    @JoinColumn(name = "user")
    User user;

    public Scratch() {
    }

    public Scratch( Boolean isScratched, Integer amount, String createdTS, String transaction_ID, User user) {
        this.isScratched = isScratched;
        this.amount = amount;
        this.createdTS = createdTS;
        this.transaction_ID = transaction_ID;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scratch)) return false;
        Scratch scratch = (Scratch) o;
        return getId().equals(scratch.getId()) && Objects.equals(isScratched, scratch.isScratched) && Objects.equals(getAmount(), scratch.getAmount()) && Objects.equals(getCreatedTS(), scratch.getCreatedTS()) && Objects.equals(getTransaction_ID(), scratch.getTransaction_ID()) && Objects.equals(getUser(), scratch.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isScratched, getAmount(), getCreatedTS(), getTransaction_ID(), getUser());
    }

    @Override
    public String toString() {
        return "Scratch{" +
                "Id=" + Id +
                ", isScratched=" + isScratched +
                ", amount=" + amount +
                ", createdTS='" + createdTS + '\'' +
                ", transaction_ID='" + transaction_ID + '\'' +
                ", user=" + user +
                '}';
    }
}
