package com.petservice.petservice.application.port.in;

import com.petservice.petservice.domain.Pet;
import com.petservice.petservice.domain.exception.ArgumentNotValidException;
import lombok.Getter;

public interface AddPetUseCase {
    Pet addPet(AddPetCommand addPetCommand);

    @Getter
    class AddPetCommand {
        private PetOwnerCommand owner;
        private Long weight;
        private String breed;
        private Boolean vaccinationStatus;
        private Integer trainingLevel;

        private final String OWNER_PET_REQUIRED_INFORMATION_EXCEPTION = "Owner pet information must be included";
        private final String BASIC_PET_REQUIRED_INFORMATION_EXCEPTION = "Basic pet information must be included";

        public AddPetCommand(PetOwnerCommand owner, Long weight,
                             String breed, Boolean vaccinationStatus,
                             Integer trainingLevel, Boolean eligible) {

            if (owner == null || owner.getOwnerId() == null || owner.getOwnerName() == null) {
                throw new ArgumentNotValidException(OWNER_PET_REQUIRED_INFORMATION_EXCEPTION);
            }

            if (weight == null || breed == null
                    || vaccinationStatus == null || trainingLevel == null) {
                throw new ArgumentNotValidException(BASIC_PET_REQUIRED_INFORMATION_EXCEPTION);
            }

            this.owner = owner;
            this.weight = weight;
            this.breed = breed;
            this.vaccinationStatus = vaccinationStatus;
            this.trainingLevel = trainingLevel;
        }
    }

    @Getter
    class PetOwnerCommand {
        private Long ownerId;
        private String ownerName;

        public PetOwnerCommand(Long ownerId, String ownerName) {
            this.ownerId = ownerId;
            this.ownerName = ownerName;
        }
    }
}
