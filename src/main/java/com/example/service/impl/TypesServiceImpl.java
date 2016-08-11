package com.example.service.impl;

import com.example.model.mTypes;
import com.example.repository.TypesDao;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karol on 10.08.2016.
 */
@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesDao typesDao;


    @Override
    public Collection<mTypes> getAllTypes() {
        return typesDao.findAll();
    }

    @Override
    public mTypes getTypesByCode(String code) {
        return typesDao.getTypesByCode(code);
    }

    @Override
    public mTypes addType(mTypes type) {
        return typesDao.save(type);
    }
}
