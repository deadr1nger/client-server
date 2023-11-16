package com.example.finalapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Set;
import java.util.UUID;
@Data
public class idsDTO {
    Set<UUID> ids;
}
