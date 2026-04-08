
package com.xworkz.fileupload.dao;

import com.xworkz.fileupload.entity.FileUploadEntity;

public interface FileUploadDAo {

    void uploadData(FileUploadEntity fileUploadEntity);


    FileUploadEntity findByFilePath(String filePath);
}
