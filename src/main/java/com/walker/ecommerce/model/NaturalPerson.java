package com.walker.ecommerce.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tb_natural_person")
@PrimaryKeyJoinColumn(name = "id")
public class NaturalPerson extends Person{ //Pessoa Física
    @Column(nullable = false)
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth; //dataNascimento

    public NaturalPerson() {
    }

    public NaturalPerson(Long id, String name, String email, String phone, String typePerson, List<Address> addresses, String cpf, Date dateOfBirth) {
        super(id, name, email, phone, typePerson, addresses);
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
