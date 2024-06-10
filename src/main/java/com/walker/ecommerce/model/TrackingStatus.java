package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_tracking_status")
@SequenceGenerator(name = "seq_tracking_status",sequenceName = "seq_tracking_status",initialValue = 1,allocationSize = 1)
public class TrackingStatus implements Serializable { //StatusRastreio
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_tracking_status")
    private Long id;
    private String distributionCenter; //centroDistribuição
    private String city; //cidade
    private String state; //estado
    private String status;

    @ManyToOne
    @JoinColumn(name = "sale_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "sale_fk"))
    private Sale sale;

    public TrackingStatus() {
    }

    public TrackingStatus(Long id, String distributionCenter, String city, String state, String status, Sale sale) {
        this.id = id;
        this.distributionCenter = distributionCenter;
        this.city = city;
        this.state = state;
        this.status = status;
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(String distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingStatus that = (TrackingStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
