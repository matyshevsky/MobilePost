package com.example.service;

import com.example.model.mTypes;

import java.util.Collection;

/**
 * Created by Karol on 10.08.2016.
 */
public interface TypesService {
    Collection<mTypes> getAllTypes();
    mTypes getTypesByCode(String code);
    mTypes addType(mTypes type);
}
