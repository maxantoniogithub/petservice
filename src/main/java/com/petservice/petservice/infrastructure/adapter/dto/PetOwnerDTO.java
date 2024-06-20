package com.petservice.petservice.infrastructure.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDTO {
    private Long ownerId;
    private String ownerName;
}
