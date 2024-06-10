package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_sale")
@SequenceGenerator(name = "seq_sale",sequenceName = "seq_sale",initialValue = 1,allocationSize = 1)
public class Sale implements Serializable { //VendaCompraLojaVirtual
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_sale")
    private Long id;
    private BigDecimal totalAmount; //valorTotal
    private BigDecimal discountAmount; //ValorDesconto
    private BigDecimal shippingCost; //valorFrete
    private Integer  deliveryDays; //diasEntrega
    @Temporal(TemporalType.DATE)
    private Date saleDate; //dataVenda
    @Temporal(TemporalType.DATE)
    private Date deliveryDate; //dataEntrega

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person; //pessoa
    @ManyToOne
    @JoinColumn(name = "delivery_address_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "delivery_address_fk"))
    private Address deliveryAddress; //enderecoEntrega
    @ManyToOne
    @JoinColumn(name = "billing_address_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "billing_address_fk"))
    private Address billingAddress; //enderecoCobranca
    @ManyToOne
    @JoinColumn(name = "payment_method_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "payment_method_fk"))
    private PaymentMethod paymentMethod; //metodoPagamento
    @OneToOne
    @JoinColumn(name = "sale_invoice_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "sale_invoice_fk"))
    private SaleInvoice saleInvoice; //notaFiscalVenda
    @ManyToOne
    @JoinColumn(name = "discount_coupon_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "discount_coupon_fk"))
    private DiscountCoupon discountCoupon; //cupDesc

    public Sale() {
    }

    public Sale(Long id, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal shippingCost, Integer deliveryDays, Date saleDate, Date deliveryDate, Person person, Address deliveryAddress, Address billingAddress, PaymentMethod paymentMethod, SaleInvoice saleInvoice, DiscountCoupon discountCoupon) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.shippingCost = shippingCost;
        this.deliveryDays = deliveryDays;
        this.saleDate = saleDate;
        this.deliveryDate = deliveryDate;
        this.person = person;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
        this.saleInvoice = saleInvoice;
        this.discountCoupon = discountCoupon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaleInvoice getSaleInvoice() {
        return saleInvoice;
    }

    public void setSaleInvoice(SaleInvoice saleInvoice) {
        this.saleInvoice = saleInvoice;
    }

    public DiscountCoupon getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(DiscountCoupon discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
