package com.xworkz.netflix.dao;

import com.xworkz.netflix.entity.NetflixEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<NetflixEntity> getNetflixData() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("login");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readData");
            List<NetflixEntity> list = query.getResultList();
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