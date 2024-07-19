package com.walker.ecommerce.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
@SequenceGenerator(name = "seq_user",sequenceName = "seq_user",allocationSize = 1,initialValue = 1)
public class User implements UserDetails { //Usuario

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_user")
    private Long id;
    @Column(nullable = false) //valores obrigatórios
    private String login;
    @Column(nullable = false) //valores obrigatórios
    private String password; //senha
    @Column(nullable = false) //valores obrigatórios
    @Temporal(TemporalType.DATE)
    private Date passwordUpdateDate; //dataAtualSenha



    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_user_access", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","access_id"},name = "unique_access_user"),
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id",table = "tb_user",unique = false, foreignKey = @ForeignKey(
                    name = "user_fk",value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "access_id",unique = false,referencedColumnName = "id",table = "tb_access",foreignKey = @ForeignKey(
                    name = "access_fk",value = ConstraintMode.CONSTRAINT))
    )
    private List<Access> accesses;

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "person_fk"))
    private Person person; //pessoa


    public User() {
    }

    public User(Long id, String login, String password, Date passwordUpdateDate, List<Access> accesses, Person person) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.passwordUpdateDate = passwordUpdateDate;
        this.accesses = accesses;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPasswordUpdateDate() {
        return passwordUpdateDate;
    }

    public void setPasswordUpdateDate(Date passwordUpdateDate) {
        this.passwordUpdateDate = passwordUpdateDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }







    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.accesses;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
