package com.example.repository;

import com.example.model.mDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karol on 24.12.2016.
 */
public interface DeliveryDao extends JpaRepository<mDelivery, Long> {

    mDelivery getDeliveryByCode(String code);
    mDelivery getDeliveryByFromOffice(Long fromOffice);
    mDelivery getDeliveryByRecipientZipCode(String recipientZipCode);
    mDelivery getDeliveryById(Long id);

}
