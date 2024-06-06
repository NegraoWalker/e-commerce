package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_payment_method")
@SequenceGenerator(name = "seq_payment_method",sequenceName = "seq_payment_method",initialValue = 1,allocationSize = 1)
public class PaymentMethod implements Serializable { //FormaPagamento
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_payment_method")
    private Long id;
    private String decription; //descrição

    public PaymentMethod() {
    }

    public PaymentMethod(Long id, String decription) {
        this.id = id;
        this.decription = decription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
