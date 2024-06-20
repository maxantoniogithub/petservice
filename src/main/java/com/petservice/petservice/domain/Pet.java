package com.petservice.petservice.domain;

import com.petservice.petservice.domain.constant.EligiblePetConditions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Pet {
    private UUID id;
    private PetOwner owner;
    private Long weight;
    private String breed;
    private Boolean vaccinationStatus;
    private Integer trainingLevel;

    public Pet(UUID id, PetOwner owner,
               Long weight, String breed,
               Boolean vaccinationStatus, Integer trainingLevel) {
        this.id = id;
        this.owner = owner;
        this.weight = weight;
        this.breed = breed;
        this.vaccinationStatus = vaccinationStatus;
        this.trainingLevel = trainingLevel;
    }

    public static Pet getEligiblePet() {
        Pet pet = new Pet();
        pet.setWeight(EligiblePetConditions.WEIGHT_UNDER);
        pet.setBreed(EligiblePetConditions.NOT_BREED);
        pet.setVaccinationStatus(EligiblePetConditions.VACCINATION_STATUS);
        pet.setTrainingLevel(EligiblePetConditions.TRAINING_LEVEL_ABOVE);
        return pet;
    }
}
