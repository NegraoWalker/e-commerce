package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_sale_invoice")
@SequenceGenerator(name = "seq_sale_invoice",sequenceName = "seq_sale_invoice",initialValue = 1,allocationSize = 1)
public class SaleInvoice implements Serializable { //NotaFiscalVenda
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_sale_invoice")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private String invoiceNumber; //numero
    @Column(nullable = false) //valores obrigatórios
    private String invoiceSeries; //serie
    @Column(nullable = false) //valores obrigatórios
    private String type; //tipo
    @Column(columnDefinition = "text", nullable = false)
    private String xml;
    @Column(columnDefinition = "text", nullable = false)
    private String pdf;


    @OneToOne
    @JoinColumn(name = "sale_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "sale_fk"))
    private Sale sale;





    public SaleInvoice() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleInvoice that = (SaleInvoice) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
