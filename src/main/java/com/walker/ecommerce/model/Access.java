package com.walker.ecommerce.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_access")
@SequenceGenerator(name = "seq_access",sequenceName = "seq_access",initialValue = 1,allocationSize = 1)
public class Access implements GrantedAuthority { //Acesso
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_access")
    private Long id;

    @Column(nullable = false)
    private String description; //descrição

    public Access() {
    }

    public Access(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access access = (Access) o;
        return Objects.equals(id, access.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    @Override
    public String getAuthority() {
        return this.description;
    }


}
