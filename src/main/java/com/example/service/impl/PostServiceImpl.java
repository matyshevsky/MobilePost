package com.example.service.impl;

import com.example.model.mPost;
import com.example.repository.PostDao;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karol on 11.08.2016.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public Collection<mPost> getAllPosts() {
        return postDao.findAll();
    }

    @Override
    public mPost getPostByCode(String code) {
        return postDao.getPostByCode(code);
    }

    @Override
    public mPost getPostByZipcode(String zipcode) {
        return postDao.getPostByZipcode(zipcode);
    }

    @Override
    public mPost addPost(mPost type) {
        return postDao.save(type);
    }
}
