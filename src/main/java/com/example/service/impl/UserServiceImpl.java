package com.example.service.impl;

import com.example.model.mUser;
import com.example.repository.UserDao;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Karol on 27.07.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public mUser getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    @Override
    @Transactional
    public Collection<mUser> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public mUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object response = authentication.getPrincipal();

        return response instanceof mUser ? (mUser) response : null;
    }


}