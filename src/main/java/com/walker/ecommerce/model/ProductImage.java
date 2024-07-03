package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product_image")
@SequenceGenerator(name = "seq_product_image", sequenceName = "seq_product_image", initialValue = 1, allocationSize = 1)
public class ProductImage implements Serializable { //ImagemProduto
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_image")
    private Long id;
    @Column(columnDefinition = "text", nullable = false)
    private String originalImage; //imagemOriginal
    @Column(columnDefinition = "text", nullable = false)
    private String thumbnailImage; //imagemMiniatura

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_fk"))
    private Product product; //produto


    public ProductImage() {
    }

    public ProductImage(Long id, String originalImage, String thumbnailImage, Product product) {
        this.id = id;
        this.originalImage = originalImage;
        this.thumbnailImage = thumbnailImage;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(String originalImage) {
        this.originalImage = originalImage;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
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
        ProductImage that = (ProductImage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
