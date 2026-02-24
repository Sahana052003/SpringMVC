package com.xworkz.facebook.dao;

import com.xworkz.facebook.entity.FacebookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class FacebookDAOImpl implements FacebookDAO{
    @Override
    public void accessData(FacebookEntity facebookEntity) {
        System.out.println("Registered Data is saved : " + facebookEntity);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("register");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(facebookEntity);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    }
