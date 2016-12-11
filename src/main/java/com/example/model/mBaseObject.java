package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CreateAt == null) ? 0 : CreateAt.hashCode());
		result = prime * result + ((ModifiedAt == null) ? 0 : ModifiedAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		mBaseObject other = (mBaseObject) obj;
		if (CreateAt == null) {
			if (other.CreateAt != null) {
				return false;
			}
		} else if (!CreateAt.equals(other.CreateAt)) {
			return false;
		}
		if (ModifiedAt == null) {
			if (other.ModifiedAt != null) {
				return false;
			}
		} else if (!ModifiedAt.equals(other.ModifiedAt)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
