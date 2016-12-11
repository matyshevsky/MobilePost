package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.mPost;

/**
 * Created by Karol on 11.08.2016.
 */
public interface PostDao extends JpaRepository<mPost, Long> {

    mPost getPostByCode(String code);
    mPost getPostByZipcode(String zipcode);

	mPost getPostById(Long id);

}
