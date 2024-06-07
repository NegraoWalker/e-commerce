package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_purchase_invoice")
@SequenceGenerator(name = "seq_purchase_invoice", sequenceName = "seq_purchase_invoice", initialValue = 1, allocationSize = 1)
public class PurchaseInvoice implements Serializable { //NotaFiscalCompra
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_purchase_invoice")
    private Long id;
    private String invoiceNumber; //numeroNota
    private String invoiceSeries; //serieNota
    private String description; //descricaoObs
    private BigDecimal totalAmount; //valorTotal
    private BigDecimal discountAmount; //valorDesconto
    private BigDecimal ICMSAmount; //valorICMS
    @Temporal(TemporalType.DATE)
    private Date purchaseDate; //dataCompra

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person; //pessoa

    @ManyToOne(targetEntity = AccountPayable.class)
    @JoinColumn(name = "account_payable_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "account_payable_fk"))
    private AccountPayable accountPayable; //contaPagar

    public PurchaseInvoice() {
    }

    public PurchaseInvoice(Long id, String invoiceNumber, String invoiceSeries, String description, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal ICMSAmount, Date purchaseDate, Person person, AccountPayable accountPayable) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceSeries = invoiceSeries;
        this.description = description;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.ICMSAmount = ICMSAmount;
        this.purchaseDate = purchaseDate;
        this.person = person;
        this.accountPayable = accountPayable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(String invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getICMSAmount() {
        return ICMSAmount;
    }

    public void setICMSAmount(BigDecimal ICMSAmount) {
        this.ICMSAmount = ICMSAmount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AccountPayable getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(AccountPayable accountPayable) {
        this.accountPayable = accountPayable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInvoice that = (PurchaseInvoice) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
