package com.example.service;

import com.example.model.mProduct;

import java.util.Collection;

/**
 * Created by Karol on 23.12.2016.
 */
public interface ProductService {

    Collection<mProduct> getAllProducts();
    mProduct getProductById(Long id);
    mProduct getProductByWeight(Double weight);
    Collection<mProduct> getProductByType(Long id);
    mProduct addProduct(mProduct product);
    void update(mProduct product);
    void delete(Long id);

}
