package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.service.FileUploadService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        Path path = Paths.get("C:\\img\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".jpg");
        System.out.println(path);
        Files.write(path,bytes);

        fileUploadDTO.setFilePath(path.toString());
        fileUploadService.uploadFiles(fileUploadDTO);
        System.out.println("Now file is added ");
        return "index";
    }


    @GetMapping("image")
    public void getImage(HttpServletResponse httpServletResponse, String filePath, Model model) throws IOException {
        httpServletResponse.setContentType("image/jpg");
        File file = new File(filePath);
        InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        IOUtils.copy(inputStream,servletOutputStream);
        httpServletResponse.flushBuffer();
    }
}
