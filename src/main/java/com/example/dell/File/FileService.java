package com.example.dell.File;
import com.example.dell.Docs.Document;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
public class FileService {

    public final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity uploadFile(MultipartFile file, Document d) {
        try {
            // Read the file content into a byte array
            byte[] fileContent = getFileBytes(file.getInputStream());

            // Create a new FileEntity object and set its properties

            FileEntity fileEntity = new FileEntity();
            fileEntity.setDocument(d);
            fileEntity.setFileName(Objects.requireNonNull(file.getOriginalFilename()));
            fileEntity.setFileType(Objects.requireNonNull(file.getContentType()));
            fileEntity.setFileContent(fileContent);
            // Set other properties as needed (e.g., fileContent, fileSize, filePath)

            // Save the FileEntity object to the database
            return fileRepository.save(fileEntity);
        } catch (IOException e) {
            // Handle file read error
            e.printStackTrace(); // Or log the error
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    // Utility method to read file content into byte array
    private byte[] getFileBytes(InputStream inputStream) throws IOException {
        return IOUtils.toByteArray(inputStream);
    }

    public List<FileEntity> getFileByIdmatiere(Long idmat) {
        return fileRepository.findByDocument_Idmatiere(idmat);
    }

    public FileEntity getFileById(Long fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + fileId));
    }

    // Add more methods for file operations (download, update, delete) as needed
}
