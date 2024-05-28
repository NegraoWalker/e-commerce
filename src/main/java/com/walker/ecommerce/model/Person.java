package com.walker.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_person",sequenceName = "seq_person",initialValue = 1,allocationSize = 1)
public abstract class Person implements Serializable { //Pessoa
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_person")
    private Long Id;
    private String name;
    private String email;
    private String phone;
}
