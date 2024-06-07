package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_discount_coupon")
@SequenceGenerator(name = "seq_discount_coupon",sequenceName = "seq_discount_coupon",initialValue = 1,allocationSize = 1)
public class DiscountCoupon implements Serializable { //CupDesc
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_discount_coupon")
    private Long id;
    private String couponCode; //codDesc
    @Temporal(TemporalType.DATE)
    private Date couponExpirationDate; //dataValidadeCupom
    private BigDecimal discountAmount; //valorRealDesc
    private BigDecimal discountPercentage; //valorPorcentDesc

    public DiscountCoupon() {
    }

    public DiscountCoupon(Long id, String couponCode, Date couponExpirationDate, BigDecimal discountAmount, BigDecimal discountPercentage) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponExpirationDate = couponExpirationDate;
        this.discountAmount = discountAmount;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getCouponExpirationDate() {
        return couponExpirationDate;
    }

    public void setCouponExpirationDate(Date couponExpirationDate) {
        this.couponExpirationDate = couponExpirationDate;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCoupon that = (DiscountCoupon) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
