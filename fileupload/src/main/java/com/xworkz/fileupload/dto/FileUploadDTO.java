package com.xworkz.fileupload.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadDTO {
    private String name;
    private MultipartFile file;
    private String filePath;

}
