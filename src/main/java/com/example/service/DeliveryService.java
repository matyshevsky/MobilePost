package com.example.service;

import com.example.model.mDelivery;

import java.util.Collection;

/**
 * Created by Karol on 24.12.2016.
 */
public interface DeliveryService {

    Collection<mDelivery> getAllDelivers();
    mDelivery getDeliveryByCode(String code);
    mDelivery getDeliveryByFromOffice(Long fromOffice);
    mDelivery getDeliveryByRecipientZipCode(String recipientZipCode);
    mDelivery getDeliveryById(Long id);
    mDelivery addDelivery(mDelivery delivery);
    void update(mDelivery delivery);
    void delete(Long id);
    mDelivery makeDeliver(mDelivery delivery);
    void advise(Long id);

}
