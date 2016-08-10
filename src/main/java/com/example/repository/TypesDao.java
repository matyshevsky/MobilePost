package com.example.repository;

import com.example.model.mTypes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karol on 10.08.2016.
 */
public interface TypesDao extends JpaRepository<mTypes, Long> {

    mTypes getTypesByCode(String code);
    mTypes getTypesById(Long id);

}
