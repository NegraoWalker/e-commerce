package com.walker.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_legal_person")
@PrimaryKeyJoinColumn(name = "id")
public class LegalPerson extends Person{ //Pessoa Jurídica
    @Column(nullable = false) //valores obrigatórios
    private String cnpj;
    @Column(nullable = false) //valores obrigatórios
    private String tradeName; //nomeFantasia
    @Column(nullable = false) //valores obrigatórios
    private String businessName; //razaoSocial
    private String category; //categoria
    @Column(nullable = false) //valores obrigatórios
    private String stateRegistration; //inscEstadual
    private String municipalRegistration; //inscMunicipal

    public LegalPerson() {
    }

    public LegalPerson(Long id, String name, String email, String phone, String typePerson, List<Address> addresses, String cnpj, String tradeName, String businessName, String category, String stateRegistration, String municipalRegistration) {
        super(id, name, email, phone, typePerson, addresses);
        this.cnpj = cnpj;
        this.tradeName = tradeName;
        this.businessName = businessName;
        this.category = category;
        this.stateRegistration = stateRegistration;
        this.municipalRegistration = municipalRegistration;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getMunicipalRegistration() {
        return municipalRegistration;
    }

    public void setMunicipalRegistration(String municipalRegistration) {
        this.municipalRegistration = municipalRegistration;
    }
}
