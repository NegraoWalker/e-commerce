package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product_brand")
@SequenceGenerator(name = "seq_product_brand",sequenceName = "seq_product_brand",allocationSize = 1,initialValue = 1)
public class ProductBrand implements Serializable { //MarcaProduto

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_brand")
    private Long id;
    @Column(nullable = false)
    private String descriptionName; //nomeDesc

    public ProductBrand() {
    }

    public ProductBrand(Long id, String descriptionName) {
        this.id = id;
        this.descriptionName = descriptionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBrand that = (ProductBrand) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
