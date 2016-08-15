package com.example.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Karol on 10.08.2016.
 */
@Entity(name = "types")
@SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "typesId")
@Table(name = "types")
public class mTypes extends mBaseObject {

    @NotNull
    private String code;

    @NotNull
    private String name;

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
}
