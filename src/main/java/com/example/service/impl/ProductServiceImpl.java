package com.example.service.impl;

import com.example.model.mProduct;
import com.example.repository.ProductDao;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karol on 23.12.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Collection<mProduct> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public mProduct getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public mProduct getProductByWeight(Double weight) {
        return productDao.getProductByWeight(weight);
    }

    @Override
    public Collection<mProduct> getProductByType(Long id) {
        return productDao.getProductsByType(id);
    }

    @Override
    public mProduct addProduct(mProduct product) {
        return productDao.save(product);
    }

    @Override
    public void update(mProduct product) {
        productDao.save(product);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }
}
