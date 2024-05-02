package com.example.dell.File;
import com.example.dell.Docs.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
@Table(name = "files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "document")
    @JsonBackReference
    private Document document;
    @Lob
    @Column(nullable = false, length = 1000000)
    private byte[] fileContent;


    public com.example.dell.Docs.Document getDocument() {
        return document;
    }

    public void setDocument(com.example.dell.Docs.Document document) {
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public FileEntity() {
    }

    public FileEntity(Long id, String fileName, String fileType, byte[] fileContent, Document d) {
        this.document= d;
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    // Add more attributes as needed (e.g., fileContent, fileSize, filePath)

    // Getters and setters
}
