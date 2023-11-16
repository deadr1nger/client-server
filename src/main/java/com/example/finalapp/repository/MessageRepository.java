package com.example.finalapp.repository;

import com.example.finalapp.entity.DocumentEntity;
import com.example.finalapp.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
    Optional<MessageEntity> findById(UUID id);
}
