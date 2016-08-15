package com.example.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Karol on 11.08.2016.
 */
@Entity(name = "posts")
@SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "postId")
@Table(name = "posts")
public class mPost extends mBaseObject{

    @NotNull
    private String code;

    private String name;

    @NotNull
    private String zipcode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
