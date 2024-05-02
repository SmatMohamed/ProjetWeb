package com.example.dell.Docs;
import com.example.dell.filliere.filliere;
import com.example.dell.File.FileEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.File;
import java.util.Date;
import java.util.List;


@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmatiere;

    private boolean semestre ; //0-->sem1,1-->sem2
    private String course_name;
    private String note;
    private String comment;
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FileEntity> fileEntity;



    @ManyToOne
    @JoinColumn(name = "idfilliere")
    @JsonBackReference
    private filliere filliere;


    public boolean isSemestre() {
        return semestre;
    }

    public void setSemestre(boolean semestre) {
        this.semestre = semestre;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public List<FileEntity> getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(List<FileEntity> fileEntity) {
        this.fileEntity = fileEntity;
    }

    // Getters and setters
    public Document(){

    }

    public com.example.dell.filliere.filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(com.example.dell.filliere.filliere filliere) {
        this.filliere = filliere;
    }

    public Long getId() {
        return idmatiere;
    }

    public void setId(Long id) {
        this.idmatiere = id;
    }

    public Document(boolean semestre, String course_name, String note, String comment) {
        this.semestre = semestre;
        this.course_name = course_name;
        this.note = note;
        this.comment = comment;
    }

    public Document(Long id, boolean semestre, String course_name, String note, String comment, List<FileEntity> F) {
        this.fileEntity= F;
        this.idmatiere = id;
        this.semestre = semestre;
        this.course_name = course_name;
        this.note = note;
        this.comment = comment;
    }
}
