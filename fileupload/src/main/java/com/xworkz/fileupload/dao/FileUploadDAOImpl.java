
package com.xworkz.fileupload.dao;

import com.xworkz.fileupload.entity.FileUploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class FileUploadDAOImpl implements FileUploadDAo{


    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void uploadData(FileUploadEntity fileUploadEntity) {
        System.out.println("The DAO method is Called");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(fileUploadEntity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error while saving a employee data : " + e.getMessage());
        }finally {
            entityManager.close();
        }
    }


    @Override
    public FileUploadEntity findByFilePath(String filePath) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager
                    .createNamedQuery("FileUploadEntity.findByFilePath", FileUploadEntity.class)
                    .setParameter("path", filePath)
                    .getSingleResult();

        } catch (Exception e) {
            System.out.println("Data not found: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }
}
