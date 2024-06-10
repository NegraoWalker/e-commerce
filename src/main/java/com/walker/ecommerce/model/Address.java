package com.walker.ecommerce.model;

import com.walker.ecommerce.enums.AddressType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_address")
@SequenceGenerator(name = "seq_address",sequenceName = "seq_address",allocationSize = 1,initialValue = 1)
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_address")
    private Long id;
    private String cep;
    private String street; //ruaLogra
    private String number; //numero
    private String neighborhood; //bairro
    private String addressComplement; //complemento
    private String city; //cidade
    private String uf;


    @Enumerated(EnumType.STRING)
    private AddressType addressType; //tipoEndereco

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person;

    public Address() {
    }

    public Address(Long id, String cep, String street, String number, String neighborhood, String addressComplement, String city, String uf, AddressType addressType, Person person) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.addressComplement = addressComplement;
        this.city = city;
        this.uf = uf;
        this.addressType = addressType;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
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
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
