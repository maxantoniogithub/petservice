package com.petservice.petservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetOwner {
    private Long ownerId;
    private String ownerName;
}
