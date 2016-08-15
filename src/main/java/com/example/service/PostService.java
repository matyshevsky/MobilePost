package com.example.service;

import com.example.model.mPost;
import java.util.Collection;

/**
 * Created by Karol on 11.08.2016.
 */
public interface PostService {

    Collection<mPost> getAllPosts();
    mPost getPostByCode(String code);
    mPost getPostByZipcode(String zipcode);
    mPost addPost(mPost type);

}
