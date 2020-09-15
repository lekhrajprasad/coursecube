package com.coursecube.springboot;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
public class UploadPDFController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("===================================================================");
        String destFile = "./uploads/"+multipartFile.getOriginalFilename()+ UUID.randomUUID();
        Files.copy(multipartFile.getInputStream(), Path.of(destFile), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("===================================================================");
        return destFile+ " has been uploaded successfully !!";
    }
}
