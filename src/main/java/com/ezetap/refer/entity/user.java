package com.ezetap.refer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="user")
public class user {

    @Id
    @Column(name="id")
    Integer Id;

    @Column(name="Merchant_name")
    String Merchant_name;

    public boolean isReferral_status() {
        return referral_status;
    }

    public void setReferral_status(boolean referral_status) {
        this.referral_status = referral_status;
    }

    @Column(name="Referral_status")
    boolean referral_status;


    public String getMerchant_name() {
        return Merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        Merchant_name = merchant_name;
    }

    public user(Integer id) {
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
        if (!(o instanceof user)) return false;
        user user = (user) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
