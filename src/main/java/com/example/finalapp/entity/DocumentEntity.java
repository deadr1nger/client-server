package com.example.finalapp.entity;

import com.example.finalapp.enumerate.StatusEnumerate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "document")
public class DocumentEntity extends AbstractJPAPersistable<UUID>{

    @Column(name = "document_type")
    private String type;
    @Column(name = "organization")
    private String organization;
    @Column(name = "document_created")
    private LocalDate createDate = LocalDate.now();
    @Column(name = "description")
    private String description;
    @Column(name = "patient_name")
    private String patient;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnumerate status;


}
