package zone.god.blogprojectbe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zone.god.blogprojectbe.JsonPayload.JPayload;

import java.io.File;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UploadController {
    @Autowired
    Environment env;

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JPayload> doUpload(@RequestParam("upload") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileUpload = env.getProperty("uploadPath").toString();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPayload jPayload = new JPayload(1, fileName, "http://localhost:8080/image/" + fileName);
        return new ResponseEntity<>(jPayload, HttpStatus.OK);
    }
}
