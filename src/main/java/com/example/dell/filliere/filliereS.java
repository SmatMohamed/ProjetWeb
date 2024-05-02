package com.example.dell.filliere;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class filliereS {
    @Autowired
    private filliereR filliereR;
    public List<filliere> getAllfilliere() {
        return filliereR.findAll();
    }

    public filliere getfilliereById(long id) {
        return filliereR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + id));
    }

    public filliere savefilliere(filliere newFilliere) {
        return filliereR.save(newFilliere);
    }

}
