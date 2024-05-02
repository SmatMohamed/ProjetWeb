package com.example.dell.File;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // Add custom query methods if needed
    List<FileEntity> findByDocument_Idmatiere(Long id);
}