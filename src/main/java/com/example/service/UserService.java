package com.example.service;

import com.example.model.mUser;

import java.util.Collection;

/**
 * Created by Karol on 27.07.2016.
 */
public interface UserService {
    mUser getUserByUsername(String username);
    Collection<mUser> getAllUser();
    mUser getCurrentUser();
}