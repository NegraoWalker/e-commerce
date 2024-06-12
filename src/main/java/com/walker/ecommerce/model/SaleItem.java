package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_sale_item")
@SequenceGenerator(name = "seq_sale_item",sequenceName = "seq_sale_item",initialValue = 1,allocationSize = 1)
public class SaleItem implements Serializable { //ItemVendaLoja
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_sale_item")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private Double quantity; //quantidade


    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "product_fk"))
    private Product product; //produto
    @ManyToOne
    @JoinColumn(name = "sale_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "sale_fk"))
    private Sale sale; //venda

    public SaleItem() {
    }

    public SaleItem(Long id, Double quantity, Product product, Sale sale) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        SaleItem saleItem = (SaleItem) o;
        return Objects.equals(id, saleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
