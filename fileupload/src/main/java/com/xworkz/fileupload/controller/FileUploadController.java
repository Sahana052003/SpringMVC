package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileUploadDTO;
import com.xworkz.fileupload.entity.FileUploadEntity;
import com.xworkz.fileupload.service.FileUploadService;
import com.xworkz.fileupload.utility.OtpSender;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public FileUploadController() {
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

        otpSender.sendSimpleMessage("sahananreddy52003@gmail.com", "OTP", "text");
        String otp = otpSender.getGeneratedOtp();

        fileUploadService.uploadFiles(fileUploadDTO, otp);
        model.addAttribute("filePath", path.toString());

        System.out.println("filePath set in model: " + path.toString()); // debug

        return "otp";
    }

    @GetMapping("image")
    public void getImage(
            HttpServletResponse httpServletResponse,
            @RequestParam("filePath") String filePath) throws IOException {

        httpServletResponse.setContentType("image/jpeg");
        File file = new File(filePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);
        httpServletResponse.flushBuffer();
    }


    @PostMapping("verifyOtp")
    public String verifyOtp(
            @RequestParam("otp") String otp,
            @RequestParam("filePath") String filePath) {

        FileUploadEntity entity = fileUploadService.findByFilePath(filePath);

        if (entity.getOtp().trim().equals(otp.trim())) {
            return "redirect:image?filePath=" + filePath;
        }
        return "otp";
    }
}