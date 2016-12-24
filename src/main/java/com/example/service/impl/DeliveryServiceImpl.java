package com.example.service.impl;

import com.example.model.mDelivery;
import com.example.repository.DeliveryDao;
import com.example.repository.PostDao;
import com.example.repository.ProductDao;
import com.example.repository.TypesDao;
import com.example.service.DeliveryService;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karol on 24.12.2016.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDao deliveryDao;
    @Autowired
    ProductDao productDao;

    @Override
    public Collection<mDelivery> getAllDelivers() {
        return deliveryDao.findAll();
    }

    @Override
    public mDelivery getDeliveryByCode(String code) {
        return deliveryDao.getDeliveryByCode(code);
    }

    @Override
    public mDelivery getDeliveryByFromOffice(Long fromOffice) {
        return deliveryDao.getDeliveryByFromOffice(fromOffice);
    }

    @Override
    public mDelivery getDeliveryByRecipientZipCode(String recipientZipCode) {
        return deliveryDao.getDeliveryByRecipientZipCode(recipientZipCode);
    }

    @Override
    public mDelivery getDeliveryById(Long id) {
        return deliveryDao.getDeliveryById(id);
    }

    @Override
    public mDelivery addDelivery(mDelivery delivery) {
        return deliveryDao.save(delivery);
    }

    @Override
    public void update(mDelivery delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public void delete(Long id) {
        deliveryDao.delete(id);
    }

    @Override
    public mDelivery makeDeliver(mDelivery delivery) {
        double price = productDao.getProductById(delivery.getType()).getPrice();
        delivery.setPrice(price);
        return delivery;
    }
}
