package com.xworkz.facebook.dao;

import com.xworkz.facebook.entity.FacebookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<FacebookEntity> getFacebookData() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("register");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("data");
            List<FacebookEntity> list = (List<FacebookEntity>) query.getResultList();
            System.out.println(list);
            return list;
        } catch (Exception e) {
            return Collections.emptyList();
    }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        }
}
