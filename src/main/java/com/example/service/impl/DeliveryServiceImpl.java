package com.example.service.impl;

import com.example.model.mDelivery;
import com.example.model.mPost;
import com.example.model.mProduct;
import com.example.model.mUser;
import com.example.repository.DeliveryDao;
import com.example.repository.PostDao;
import com.example.repository.ProductDao;
import com.example.repository.TypesDao;
import com.example.service.DeliveryService;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Karol on 24.12.2016.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDao deliveryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    PostDao postdao;


    @Override
    public Collection<mDelivery> getAllDelivers() {
        return deliveryDao.findAll();
    }

    @Override
    public Collection<mDelivery> getDeliveryByCode(String code) {
        return deliveryDao.getDeliveryByCode(code);
    }

    @Override
    public Collection<mDelivery> getDeliveryByFromOffice(Long fromOffice) {
        return deliveryDao.getDeliveryByFromOffice(fromOffice);
    }

    @Override
    public Collection<mDelivery> getDeliveryByRecipientZipCode(String recipientZipCode) {
        return deliveryDao.getDeliveryByRecipientZipCode(recipientZipCode);
    }

    @Override
    public Collection<mDelivery> getDeliveryByFromOfficeOrRecipientZipCode(Long fromOffice, String recipientZipCode) {
        return deliveryDao.getDeliveryByFromOfficeOrRecipientZipCode(fromOffice, recipientZipCode);
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
        try{
            mProduct prod = productDao.getProductById(delivery.getType());

            double price = prod.getPrice();
            int days = prod.getDayToDelivery();
            delivery.setPrice(price);

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, days);
            delivery.setEstimatedDate(c.getTime());

            delivery.setAdvicePackage(false);
            delivery.setDelivered(false);

            mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            mPost post = postdao.getPostById(user.getPostOffice());
            if(post != null)
                delivery.setFromOffice(post.getId());

            return delivery;
        }
        catch(Exception e){
            System.out.println("WYJATEK: " + e.getMessage());
            return new mDelivery();
    }

    }

    @Override
    public void advise(Long id) {
        mDelivery delivery = deliveryDao.getDeliveryById(id);
        delivery.setAdvicePackage(true);
        deliveryDao.save(delivery);
    }

    @Override
    public void delivered(Long id) {
        mDelivery delivery = deliveryDao.getDeliveryById(id);
        delivery.setDelivered(true);
        delivery.setAdvicePackage(false);
        Date dt = new Date();
        delivery.setDeliveredDate(dt);
        deliveryDao.save(delivery);
    }
}
