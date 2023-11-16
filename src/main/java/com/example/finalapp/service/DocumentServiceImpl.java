package com.example.finalapp.service;

import com.example.finalapp.dto.DocumentDTO;
import com.example.finalapp.dto.MessageDTO;
import com.example.finalapp.entity.DocumentEntity;
import com.example.finalapp.entity.MessageEntity;
import com.example.finalapp.enumerate.StatusEnumerate;
import com.example.finalapp.repository.DocumentRepository;
import com.example.finalapp.repository.MessageRepository;
import com.example.finalapp.service.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class DocumentServiceImpl {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    KafkaProducerService producerService;

    /**
     * Get all documents from Database
     * @return - List of documents
     */
    public List<DocumentEntity> getAll(){
        log.info("List of Documents sent");
        return documentRepository.findAll();
    }

    /**
     * Method for sending messages in kafka service
     * @param id - UUID of Document
     * @throws ListenerExecutionFailedException - wrong type of kafka message exeption
     */
    public void sendDocument(UUID id){
        log.info("message sent to kafka");
        producerService.sendDocument(documentRepository.findById(id).get());
    }

    /**
     * Delete document from database
     * @param messageDTO - contain UUID of Document
     */
    @Transactional
    public void deleteDocument(MessageDTO messageDTO){
        log.info("Document deleted");
        documentRepository.deleteById(messageDTO.getId());

    }
    @Transactional
    public void delete(UUID id){
        log.info("Document deleted");
        documentRepository.deleteById(id);

    }
    @Transactional
    public void delete(MessageDTO dto){
        documentRepository.deleteById(dto.getId());
        log.info("Document deleted");

    }
    @Transactional
    public void deleteAll(Set<UUID> setId){

        documentRepository.deleteAllById(setId);

        log.info("List of documents deleted");
    }

    public DocumentEntity findDocument(UUID id){
        return documentRepository.findById(id).orElseThrow();
    }

    /**
     * Create new Document Entity in database
     * @param doc - Raw information of new Document Entity
     * @return - check new entity creation
     */
    @Transactional
    public boolean createMessage(DocumentDTO doc) {
        MessageEntity message = new MessageEntity();
        DocumentEntity model = new DocumentEntity();
        model.setPatient(doc.getPatient());
        model.setType(doc.getType());
        model.setStatus(StatusEnumerate.NEW);
        model.setOrganization(doc.getOrganization());
        model.setDescription(doc.getDescription());
        message.setDocument(model);
        documentRepository.save(model);
        messageRepository.save(message);
        log.info("Document was created");
        return documentRepository.existsById(model.getId());
    }


}
