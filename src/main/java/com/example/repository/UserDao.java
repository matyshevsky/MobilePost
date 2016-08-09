package com.example.repository;

import com.example.model.mUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SeBB on 24.07.2016.
 */
public interface UserDao extends JpaRepository<mUser, Long> {

    mUser getUserByUsername(String username);


}
