package com.petservice.petservice.application.adapter.in;

import com.petservice.petservice.application.port.in.AddPetUseCase;
import com.petservice.petservice.application.port.in.FindPetUseCase;
import com.petservice.petservice.application.port.out.PetRepository;
import com.petservice.petservice.domain.Pet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService implements FindPetUseCase, AddPetUseCase {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> findEligiblePets() {
        Pet eligiblePet = Pet.getEligiblePet();
        EligiblePetsSearchCriteriaCommand eligiblePetsSearchCriteriaCommand =
                new EligiblePetsSearchCriteriaCommand(eligiblePet.getWeight(), eligiblePet.getBreed(),
                        eligiblePet.getVaccinationStatus(), eligiblePet.getTrainingLevel());

        return petRepository.findPetsByEligibleCriteria(eligiblePetsSearchCriteriaCommand);
    }

    @Transactional
    @Override
    public Pet addPet(AddPetCommand addPetCommand) {
        return petRepository.savePet(addPetCommand);
    }
}
