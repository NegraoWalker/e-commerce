package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_person",sequenceName = "seq_person",initialValue = 1,allocationSize = 1)
public abstract class Person implements Serializable { //Pessoa
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_person")
    private Long Id;
    @Column(nullable = false) //valores obrigatórios
    private String name; //nome
    @Column(nullable = false) //valores obrigatórios
    private String email;
    @Column(nullable = false) //valores obrigatórios
    private String phone; //telefone
    @Column(nullable = false) //valores obrigatórios
    private String typePerson; //tipoPessoa

    @OneToMany(mappedBy = "person",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY) //mapeado para o atributo da classe Address person
    private List<Address> addresses = new ArrayList<>();

    public Person() {
    }

    public Person(Long id, String name, String email, String phone, String typePerson, List<Address> addresses) {
        Id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.typePerson = typePerson;
        this.addresses = addresses;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(Id, person.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
