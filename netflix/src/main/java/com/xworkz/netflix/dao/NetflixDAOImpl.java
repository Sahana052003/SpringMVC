package com.xworkz.netflix.dao;

import com.xworkz.netflix.entity.NetflixEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class NetflixDAOImpl implements NetflixDAO {
    @Override
    public void saveData(NetflixEntity entity) {
        System.out.println("Registered Data is saved : " + entity);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("login");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}