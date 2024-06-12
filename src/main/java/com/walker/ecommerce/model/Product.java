package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", initialValue = 1, allocationSize = 1)
public class Product implements Serializable { //Produto
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private String name; //nome
    @Column(nullable = false) //valores obrigatórios
    private String unitType; //tipoUnidade
    @Column(columnDefinition = "text", length = 2000, nullable = false) //Essa coluna na tabela deve armazenar uma quantidade de caracteres bem grande. No PostgreSQL é definido como text.
    private String description; //descricao
    @Column(nullable = false) //valores obrigatórios
    private Double weight; //peso
    @Column(nullable = false) //valores obrigatórios
    private Double width; //largura
    @Column(nullable = false) //valores obrigatórios
    private Double heigth; //altura
    @Column(nullable = false) //valores obrigatórios
    private Double depth; //profundidade
    @Column(nullable = false) //valores obrigatórios
    private BigDecimal saleValue = BigDecimal.ZERO; //valorVenda //Definido um valor padrão para o Spring Boot não colocar null
    @Column(nullable = false) //valores obrigatórios
    private Integer quantityStock = 0; //quantidadeEstoque //Definido um valor padrão para o Spring Boot não colocar null
    private Integer stockQuantityAlert = 0; //quantidadeAlertaEstoque //Definido um valor padrão para o Spring Boot não colocar null
    private String linkYouTube;
    private Boolean alertStock = Boolean.FALSE; //alertaQuantidadeEstoque //Definido um valor padrão para o Spring Boot não colocar null
    @Column(nullable = false) //valores obrigatórios
    private Boolean isActive = Boolean.TRUE; //ativo //Definido um valor padrão para o Spring Boot não colocar null
    private Integer clickCount = 0; //qtdeCliques //Definido um valor padrão para o Spring Boot não colocar null

    //invoiceProductItem : InvoiceProductItem - FK


    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
