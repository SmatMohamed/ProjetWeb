package com.example.dell.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Retrieve the FileEntity from the database using the fileId
        FileEntity fileEntity = fileService.getFileById(fileId);

        // Create a ByteArrayResource from the file content
        ByteArrayResource resource = new ByteArrayResource(fileEntity.getFileContent());

        // Return the file content in the response body with appropriate headers
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(resource);
    }

    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        FileEntity uploadedFile = fileService.uploadFile(file);
        return new ResponseEntity<>(uploadedFile, HttpStatus.CREATED);
    }

    // Add more controller methods for file operations (download, update, delete) as needed
}
