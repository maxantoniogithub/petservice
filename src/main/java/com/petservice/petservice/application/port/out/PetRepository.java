package com.petservice.petservice.application.port.out;

import com.petservice.petservice.application.port.in.AddPetUseCase;
import com.petservice.petservice.application.port.in.FindPetUseCase;
import com.petservice.petservice.domain.Pet;

import java.util.List;

public interface PetRepository {

    List<Pet> findPetsByEligibleCriteria(FindPetUseCase.EligiblePetsSearchCriteriaCommand eligiblePets);
    Pet savePet(AddPetUseCase.AddPetCommand addPetCommand);
}
