package com.xworkz.netflix.dao;

import com.xworkz.netflix.entity.NetflixEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class NetflixDAOImpl implements NetflixDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveData(NetflixEntity entity) {
        System.out.println("Registered Data is saved : " + entity);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();

        }
    }

    @Override
    public List<NetflixEntity> getNetflixData() {
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
        } finally {
            entityManager.close();

        }
    }

    @Override
    public NetflixEntity getDetailsBasedOnEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readEmail");
            query.setParameter("userEmail", email);
            NetflixEntity facebook = (NetflixEntity) query.getSingleResult();
            return facebook;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public NetflixEntity getDetailsBasedOnMobile(Long mobile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readMobileNumber");
            query.setParameter("cellNumber", mobile);
            NetflixEntity facebook = (NetflixEntity) query.getSingleResult();
            return facebook;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }
}