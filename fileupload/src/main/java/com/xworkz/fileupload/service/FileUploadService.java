package com.xworkz.fileupload.service;

import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.entity.FileUploadEntity;

public interface FileUploadService {
//    void uploadFiles(FileUploadDTO fileUploadDTO,String otp);
void uploadFiles(FileUploadDTO fileUploadDTO);
    FileUploadEntity findByFilePath(String filePath);
}