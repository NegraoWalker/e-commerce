package com.walker.ecommerce.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
@SequenceGenerator(name = "seq_user",sequenceName = "seq_user",allocationSize = 1,initialValue = 1)
public class User implements UserDetails { //Usuario

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_user")
    private Long id;

    private String login;
    private String password; //senha
    @Temporal(TemporalType.DATE)
    private Date passwordUpdateDate; //dataAtualSenha


//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "usuarios_acesso", uniqueConstraints = @UniqueConstraint (columnNames = {"usuario_id", "acesso_id"} ,
//            name = "unique_acesso_user"),
//            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
//                    unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
//            inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
//                    foreignKey = @ForeignKey(name = "aesso_fk", value = ConstraintMode.CONSTRAINT)))

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_user_access", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","access_id"},name = "unique_access_user"),
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id",table = "tb_user",unique = false, foreignKey = @ForeignKey(
                    name = "user_fk",value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "access_id",unique = false,referencedColumnName = "id",table = "tb_access",foreignKey = @ForeignKey(
                    name = "access_fk",value = ConstraintMode.CONSTRAINT))
    )
    private List<Access> accesses;







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
