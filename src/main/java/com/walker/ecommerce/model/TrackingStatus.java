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

    public TrackingStatus() {
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
