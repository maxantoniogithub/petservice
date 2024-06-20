package com.petservice.petservice.application.port.in;

import com.petservice.petservice.domain.Pet;
import lombok.Getter;

import java.util.List;

public interface FindPetUseCase {
    List<Pet> findEligiblePets();

    @Getter
    class EligiblePetsSearchCriteriaCommand {
        private Long weightUnder;
        private String notBreed;
        private Boolean vaccinationStatus;
        private Integer trainingLevelAbove;

        public EligiblePetsSearchCriteriaCommand(Long weightUnder, String notBreed,
                                                 Boolean vaccinationStatus, Integer trainingLevelAbove) {
            this.weightUnder = weightUnder;
            this.notBreed = notBreed;
            this.vaccinationStatus = vaccinationStatus;
            this.trainingLevelAbove = trainingLevelAbove;
        }
    }
}
