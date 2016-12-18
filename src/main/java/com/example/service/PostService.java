package com.example.service;

import java.util.Collection;

import com.example.model.mPost;

/**
 * Created by Karol on 11.08.2016.
 */
public interface PostService {

    Collection<mPost> getAllPosts();
    mPost getPostByCode(String code);
    mPost getPostByZipcode(String zipcode);
    mPost addPost(mPost type);

	mPost getPostById(Long id);

	void update(mPost post);
    void delete(mPost post);

}
