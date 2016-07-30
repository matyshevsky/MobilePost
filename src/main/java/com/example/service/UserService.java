package com.example.service;

import com.example.model.mUser;

/**
 * Created by Karol on 27.07.2016.
 */
public interface UserService {
    mUser getUserByUsername(String username);
}