package main.java.com.example.smart.controller;

import com.example.smart.model.FileDocument;
import com.example.smart.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping
    public List<FileDocument> getAllFiles() {
        return fileRepository.findAll();
    }

    @PostMapping("/upload")
    public FileDocument uploadFile(@RequestParam("file") MultipartFile file,
                                   @RequestParam("user") String user) {
        FileDocument doc = new FileDocument();
        doc.setFilename(file.getOriginalFilename());
        doc.setUploadedBy(user);
        doc.setUploadedAt(LocalDateTime.now());
        return fileRepository.save(doc);
    }
}
