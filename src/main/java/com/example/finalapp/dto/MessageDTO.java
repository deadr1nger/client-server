package com.example.finalapp.dto;

import com.example.finalapp.entity.AbstractJPAPersistable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDTO extends AbstractJPAPersistable<UUID> {}
