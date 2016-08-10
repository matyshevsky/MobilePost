package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Karol on 24.07.2016.
 */
@MappedSuperclass
public abstract class mBaseObject {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE , generator="idGen")
    @Column(name="id")
    protected Long id;

    public Date CreateAt;

    public Date ModifiedAt;

    public Long getId() {
        return id;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    public Date getModifiedAt() {
        return ModifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        ModifiedAt = modifiedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public mBaseObject() {
    }

}
