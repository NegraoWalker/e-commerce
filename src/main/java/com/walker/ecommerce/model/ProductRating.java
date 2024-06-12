package com.walker.ecommerce.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product_rating")
@SequenceGenerator(name = "seq_product_rating",sequenceName = "seq_product_rating",initialValue = 1,allocationSize = 1)
public class ProductRating implements Serializable { //AvalicaoProduto
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_product_rating")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private Integer score; //nota
    @Column(nullable = false) //valores obrigatórios
    private String justification; //justificativa



    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person; //pessoa
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "product_fk"))
    private Product product; //produto

    public ProductRating() {
    }

    public ProductRating(Long id, Integer score, String justification, Person person, Product product) {
        this.id = id;
        this.score = score;
        this.justification = justification;
        this.person = person;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRating that = (ProductRating) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
