package com.xworkz.fileupload.service;

import com.xworkz.fileupload.dao.FileUploadDAo;
import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.entity.FileUploadEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FileUploadServiceImpl implements FileUploadService{


    @Autowired
    FileUploadDAo fileUploadDAo;



    @Override
    public void uploadFiles(FileUploadDTO fileUploadDTO,String otp) {
        FileUploadEntity fileUploadEntity = new FileUploadEntity();
        BeanUtils.copyProperties(fileUploadDTO, fileUploadEntity);
        fileUploadEntity.setOtp(otp);
        fileUploadDAo.uploadData(fileUploadEntity);
        System.out.println("Data is Saved ");
    }

    @Override
    public FileUploadEntity findByFilePath(String filePath) {
        return fileUploadDAo.findByFilePath(filePath);
    }
}
