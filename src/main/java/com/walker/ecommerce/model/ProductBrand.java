package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_product_brand")
@SequenceGenerator(name = "seq_product_brand",sequenceName = "seq_product_brand",allocationSize = 1,initialValue = 1)
public class ProductBrand implements Serializable { //MarcaProduto

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_product_brand")
    private Long id;
    private String DescriptionName; //nomeDesc

    public ProductBrand() {
    }

    public ProductBrand(Long id, String descriptionName) {
        this.id = id;
        DescriptionName = descriptionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionName() {
        return DescriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        DescriptionName = descriptionName;
    }
}
