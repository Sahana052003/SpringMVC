package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.entity.FileUploadEntity;
import com.xworkz.fileupload.service.FileUploadService;
import com.xworkz.fileupload.utility.OtpSender;
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


    @Autowired
    OtpSender otpSender;



    @PostMapping("login")
    public String UploadFiles(@ModelAttribute FileUploadDTO fileUploadDTO, Model model) throws IOException {

        MultipartFile file = fileUploadDTO.getFile();
        byte[] bytes = file.getBytes();

        Path path = Paths.get("C:\\img\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);

        fileUploadDTO.setFilePath(path.toString());

        // ✅ send OTP
        otpSender.sendSimpleMessage("sahananreddy52003@gmail.com", "OTP", "text");

        // ✅ get SAME OTP (DO NOT generate again)
        String otp = otpSender.getGeneratedOtp();

        // ✅ save same OTP
        fileUploadService.uploadFiles(fileUploadDTO, otp);

        // pass filepath to OTP page
        model.addAttribute("filePath", path.toString());

        return "otp"; // go to OTP page
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

    @PostMapping("verifyOtp")
    public String verifyOtp(String otp, String filePath, Model model) {

        // fetch from DB (you need DAO method)
        FileUploadEntity entity = fileUploadService.findByFilePath(filePath);

        if(entity != null && entity.getOtp().equals(otp)) {
            model.addAttribute("filePath", filePath);
            return "image"; // success
        } else {
            model.addAttribute("error", "Invalid OTP");
            model.addAttribute("filePath", filePath);
            return "otp";
        }
    }
}
