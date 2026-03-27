package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class FileUploadController {
    public FileUploadController(){
        System.out.println("FileUploadController is called");
    }

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("login")
    public String UploadFiles(@ModelAttribute FileUploadDTO fileUploadDTO) throws IOException {
        System.out.println("Calling this .........");
        System.out.println("Name is " + fileUploadDTO);
        MultipartFile file = fileUploadDTO.getFile();
        byte[] bytes = file.getBytes();
        Path path = Paths.get("C:\\img\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".pdf");
        System.out.println(path);
        Files.write(path,bytes);

        fileUploadDTO.setFilePath(path.toString());
        fileUploadService.uploadFiles(fileUploadDTO);
        System.out.println("Now file is added ");
        return "index";
    }
}
