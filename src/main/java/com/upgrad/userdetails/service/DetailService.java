package com.upgrad.userdetails.service;


import com.upgrad.userdetails.model.Detail;
import com.upgrad.userdetails.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    // Using JPA -> communicate | EntityManagerFactory -> EntityManger

    @Autowired
    private DetailRepository detailRepository;

    public List<Detail> getAllPosts(Integer userId) {
        return detailRepository.getAllPosts( userId);
    }

    public void createPost(Detail newPost) {
        detailRepository.createPost(newPost);
    }

    public void deletePost(Integer postId) {
        detailRepository.deletePost(postId);
    }
}