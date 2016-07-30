package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Karol on 24.07.2016.
 */
@Entity(name = "users")
@Table(name = "users")
public class mUser extends mBaseObject implements UserDetails {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<mRole> userRoleEntity = new HashSet<>();

    public mUser(String username, String password, Set<mRole> userRoleEntity) {
        super();
        this.username = username;
        this.password = password;
        this.userRoleEntity = userRoleEntity;
    }

    public Set<mRole> getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(Set<mRole> userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public mUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<mRole> userRoleEntities = this.getUserRoleEntity();

        if (userRoleEntities != null) {
            for (mRole roleEntity : userRoleEntities) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleEntity.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}