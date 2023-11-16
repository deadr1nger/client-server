package com.example.finalapp.controller;

import com.example.finalapp.dto.DocumentDTO;
import com.example.finalapp.dto.MessageDTO;
import com.example.finalapp.dto.idsDTO;
import com.example.finalapp.entity.DocumentEntity;
import com.example.finalapp.service.DocumentService;
import com.example.finalapp.service.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/documents")
@CrossOrigin(origins = "http//:localhost:3006")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody DocumentDTO document){
        documentService.createMessage(document);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DocumentEntity> getDocuments() {
        return documentService.getAll();
    }

    @PostMapping("/kafka")
    public void send (@RequestBody MessageDTO message) throws ExecutionException, InterruptedException {
        documentService.sendDocument(message.getId());
    }

    @DeleteMapping
    public void deleteDocumentAll(@RequestBody idsDTO ids){
        documentService.deleteAll(ids.getIds());
    }


    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable UUID id) {
        documentService.delete(id);
    }


}
