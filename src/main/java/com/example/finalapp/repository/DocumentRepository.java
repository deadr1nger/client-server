package com.example.finalapp.repository;

import com.example.finalapp.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {

    Optional<DocumentEntity> findById(UUID id);
    boolean existsById(UUID Id);
    @Query(value = "SELECT * FROM document", nativeQuery = true)
    List<DocumentEntity> getAllDocuments();

}
