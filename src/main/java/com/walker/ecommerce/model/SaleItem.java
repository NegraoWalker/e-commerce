package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_sale_item")
@SequenceGenerator(name = "seq_sale_item",sequenceName = "seq_sale_item",initialValue = 1,allocationSize = 1)
public class SaleItem implements Serializable { //ItemVendaLoja
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_sale_item")
    private Long id;
    private Double quantity;


    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "product_fk"))
    private Product product;
    @ManyToOne
    @JoinColumn(name = "sale_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "sale_fk"))
    private Sale sale;
}
