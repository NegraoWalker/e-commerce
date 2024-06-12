package com.walker.ecommerce.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_invoice_product_item")
@SequenceGenerator(name = "seq_invoice_product_item", sequenceName = "seq_invoice_product_item", initialValue = 1, allocationSize = 1)
public class InvoiceProductItem implements Serializable { //NotaItemProduto
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_invoice_product_item")
    private Long id;
    @Column(nullable = false)
    private Double quantity; //quantidade

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_fk"))
    private Product product; //produto

    @ManyToOne(targetEntity = PurchaseInvoice.class)
    @JoinColumn(name = "purchase_invoice_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "purchase_invoice_fk"))
    private PurchaseInvoice purchaseInvoice; //notaFiscalCompra

    public InvoiceProductItem() {
    }

    public InvoiceProductItem(Long id, Double quantity, Product product, PurchaseInvoice purchaseInvoice) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.purchaseInvoice = purchaseInvoice;
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

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceProductItem that = (InvoiceProductItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
