package com.upgrad.userdetails.repository;

import com.upgrad.userdetails.model.Detail;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class DetailRepository {

    DetailRepository() {
        System.out.println("*** Detail Repository ***");
    }

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public List<Detail> getAllPosts(Integer userId) {
        // WORKING ON JPA
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Detail> query = entityManager.createQuery("SELECT p from Detail p JOIN FETCH p.user puser WHERE puser.id = :userId", Detail.class);
        query.setParameter("userId", userId);
        List<Detail> result = query.getResultList();
        return result;
    }

    public void createPost(Detail newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Detail post = entityManager.find(Detail.class, postId);
            entityManager.remove(post);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}