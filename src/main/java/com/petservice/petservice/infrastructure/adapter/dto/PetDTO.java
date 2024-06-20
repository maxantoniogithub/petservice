package com.petservice.petservice.infrastructure.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private UUID id;
    private PetOwnerDTO owner;
    private Long weight;
    private String breed;
    private Boolean vaccinationStatus;
    private Integer trainingLevel;
}
