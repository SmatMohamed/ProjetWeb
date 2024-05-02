package com.example.dell.filliere;


import com.example.dell.Docs.Document;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "filliere")
public class filliere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfiliere;

    private int niveau;
    private String specialite;
    @OneToMany(mappedBy = "filliere", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Document> documents;


    // Constructors, getters, setters...

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }



    public Long getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Long idfiliere) {
        this.idfiliere = idfiliere;
    }



    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public filliere() {
    }

    public filliere(Long id_filiere, int niveau, String specialite) {
        this.idfiliere = id_filiere;
        this.niveau = niveau;
        this.specialite = specialite;
    }

    // Constructors, getters, setters...
}