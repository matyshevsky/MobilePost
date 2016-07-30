package com.example.service.impl;

import com.example.model.mUser;
import com.example.repository.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Karol on 27.07.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    public mUser getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }


    public mUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object response = authentication.getPrincipal();

        return response instanceof mUser ? (mUser) response : null;
    }


}