package com.example.repository;

import com.example.model.mDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Karol on 24.12.2016.
 */
public interface DeliveryDao extends JpaRepository<mDelivery, Long> {

    mDelivery getDeliveryByCode(String code);
    Collection<mDelivery> getDeliveryByFromOffice(Long fromOffice);
    Collection<mDelivery> getDeliveryByRecipientZipCode(String recipientZipCode);
    mDelivery getDeliveryById(Long id);
    Collection<mDelivery> getDeliveryByFromOfficeAndRecipientZipCode(Long fromOffice, String recipientZipCode);

}
