package com.walker.ecommerce.model;

import com.walker.ecommerce.enums.AccountStatusReceivable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_account_receivable")
@SequenceGenerator(name = "seq_account_receivable",sequenceName = "seq_account_receivable",initialValue = 1,allocationSize = 1)
public class AccountReceivable implements Serializable { //ContaReceber
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_account_receivable")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private String description; //descrição
    @Column(nullable = false) //valores obrigatórios
    @Enumerated(EnumType.STRING)
    private AccountStatusReceivable accountStatusReceivable; //statusContaReceber
    @Temporal(TemporalType.DATE)
    private Date paymentDate; //dtPagamento
    @Column(nullable = false) //valores obrigatórios
    @Temporal(TemporalType.DATE)
    private Date dueDate; //dtVencimento
    @Column(nullable = false) //valores obrigatórios
    private BigDecimal totalAmount; //valorTotal
    private BigDecimal discountAmount; //valorDesconto

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person; //pessoa

    public AccountReceivable() {
    }

    public AccountReceivable(Long id, String description, AccountStatusReceivable accountStatusReceivable, Date paymentDate, Date dueDate, BigDecimal totalAmount, BigDecimal discountAmount, Person person) {
        this.id = id;
        this.description = description;
        this.accountStatusReceivable = accountStatusReceivable;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.person = person;
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

    public AccountStatusReceivable getAccountStatusReceivable() {
        return accountStatusReceivable;
    }

    public void setAccountStatusReceivable(AccountStatusReceivable accountStatusReceivable) {
        this.accountStatusReceivable = accountStatusReceivable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountReceivable that = (AccountReceivable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
