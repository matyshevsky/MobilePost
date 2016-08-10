package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Karol on 24.07.2016.
 */
@Entity(name = "roles")
@SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "roleId")
@Table(name = "roles")
public class mRole extends mBaseObject {

    @NotNull
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<mUser> users = new HashSet<>();

    public Set<mUser> getUsers() {
        return users;
    }

}