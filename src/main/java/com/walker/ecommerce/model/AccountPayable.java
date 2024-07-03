package com.walker.ecommerce.model;

import com.walker.ecommerce.enums.AccountStatusPayable;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "tb_account_payable")
@SequenceGenerator(name = "seq_account_payable",sequenceName = "seq_account_payable",initialValue = 1,allocationSize = 1)
public class AccountPayable implements Serializable { //ContaPagar
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_account_payable")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private String description; //descrição
    @Column(nullable = false) //valores obrigatórios
    @Enumerated(EnumType.STRING)
    private AccountStatusPayable accountStatusPayable; //statusContaPagar
    @Temporal(TemporalType.DATE)
    private Date paymentDate; //dtPagamento
    @Column(nullable = false) //valores obrigatórios
    @Temporal(TemporalType.DATE)
    private Date dueDate; //dtVencimento
    @Column(nullable = false) //valores obrigatórios
    private BigDecimal totalAmount; //valorTotal
    private BigDecimal discountAmount; //valorDesconto

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person; //pessoa

    @ManyToOne
    @JoinColumn(name = "supplier_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "supplier_fk"))
    private Person supplier; //pessoa_fornecedor

    public AccountPayable() {
    }

    public AccountPayable(Long id, String description, AccountStatusPayable accountStatusPayable, Date paymentDate, Date dueDate, BigDecimal totalAmount, BigDecimal discountAmount, Person person, Person supplier) {
        this.id = id;
        this.description = description;
        this.accountStatusPayable = accountStatusPayable;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.person = person;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountStatusPayable getAccountStatusPayable() {
        return accountStatusPayable;
    }

    public void setAccountStatusPayable(AccountStatusPayable accountStatusPayable) {
        this.accountStatusPayable = accountStatusPayable;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getSupplier() {
        return supplier;
    }

    public void setSupplier(Person supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountPayable that = (AccountPayable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
