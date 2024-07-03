package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product_category")
@SequenceGenerator(name = "seq_product_category",sequenceName = "seq_product_category",allocationSize = 1,initialValue = 1)
public class ProductCategory implements Serializable { //CategoriaProduto
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_product_category")
    private Long id;
    @Column(nullable = false)
    private String descriptionName; //nomeDesc

    public ProductCategory() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
