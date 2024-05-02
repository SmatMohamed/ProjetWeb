package com.example.dell.Docs;
import com.example.dell.filliere.filliere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping
    public Document saveDocument(@RequestBody Document d)
                                 {
        return documentService.saveDocument(d);
    }
    @GetMapping("/{idfilliere}/documents")
    public ResponseEntity<List<Document>> getDocumentsByFaculty(@PathVariable Long idfilliere) {
        List<Document> documents = documentService.getDocumentsByfilliere(idfilliere);
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/{idfilliere}/documents")
    public ResponseEntity<Document> uploadDocument(@PathVariable Long idfilliere, @RequestBody Document document) {
        filliere fil = new filliere();
        fil.setIdfiliere(idfilliere);
        document.setFilliere(fil);
        Document savedDocument = documentService.saveDocument(document);
        return ResponseEntity.ok(savedDocument);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
}
