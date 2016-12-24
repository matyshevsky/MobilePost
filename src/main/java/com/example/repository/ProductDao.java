package com.example.repository;

import com.example.model.mProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Karol on 23.12.2016.
 */
public interface ProductDao extends JpaRepository<mProduct, Long> {

    mProduct getProductById(Long id);
    mProduct getProductByWeight(Double weight);
    Collection<mProduct> getProductsByType(Long id);

}
