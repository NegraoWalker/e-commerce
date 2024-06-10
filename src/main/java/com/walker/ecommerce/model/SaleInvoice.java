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
    private String invoiceNumber; //numero
    private String invoiceSeries; //serie
    private String type; //tipo
    @Column(columnDefinition = "text")
    private String xml;
    @Column(columnDefinition = "text")
    private String pdf;

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
