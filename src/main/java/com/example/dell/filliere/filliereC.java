package com.example.dell.filliere;

import com.example.dell.Docs.Document;
import com.example.dell.Docs.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/filliere")
public class filliereC {
    @Autowired
    private filliereS filliereS;

    @GetMapping
    public List<filliere> getAllfilliere() {
        return filliereS.getAllfilliere();
    }

    @GetMapping("/{id}")
    public filliere getfilliereById(@PathVariable Long id) {
        return filliereS.getfilliereById(id);
    }

    @PostMapping
    public filliere savefilliere(@RequestBody filliere newFilliere) {
        return filliereS.savefilliere(newFilliere);
    }

}