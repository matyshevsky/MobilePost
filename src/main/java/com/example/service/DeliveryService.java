package com.example.service;

import com.example.model.mDelivery;

import java.util.Collection;

/**
 * Created by Karol on 24.12.2016.
 */
public interface DeliveryService {

    Collection<mDelivery> getAllDelivers();
    mDelivery getDeliveryByCode(String code);
    Collection<mDelivery> getDeliveryByFromOffice(Long fromOffice);
    Collection<mDelivery> getDeliveryByRecipientZipCode(String recipientZipCode);
    Collection<mDelivery> getDeliveryByFromOfficeOrRecipientZipCode(Long fromOffice, String recipientZipCode);
    mDelivery getDeliveryById(Long id);
    mDelivery addDelivery(mDelivery delivery);
    void update(mDelivery delivery);
    void delete(Long id);
    mDelivery makeDeliver(mDelivery delivery);
    void advise(Long id);
    void delivered(Long id);

}
