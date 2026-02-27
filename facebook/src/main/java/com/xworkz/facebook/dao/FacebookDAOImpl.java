package com.xworkz.facebook.dao;

import com.xworkz.facebook.entity.FacebookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class FacebookDAOImpl implements FacebookDAO{

    @Autowired
    EntityManagerFactory entityManagerFactory;




    @Override
    public boolean accessData(FacebookEntity facebookEntity) {


        System.out.println("Registered Data is saved : " + facebookEntity);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(facebookEntity);
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
    public List<FacebookEntity> getFacebookData() {
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
        }
        }

    @Override
    public FacebookEntity getDetailsBasedOnEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readEmail");
            query.setParameter("emailId",email);
            FacebookEntity facebook =(FacebookEntity) query.getSingleResult();
            return facebook;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public FacebookEntity getDetailsBasedOnPhoneNumber(Long phoneNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readmobile");
            query.setParameter("mobileNumber",phoneNumber);
            FacebookEntity facebook =(FacebookEntity) query.getSingleResult();
            return facebook;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }
}
