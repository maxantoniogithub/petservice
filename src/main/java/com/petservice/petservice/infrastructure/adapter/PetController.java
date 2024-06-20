package com.petservice.petservice.infrastructure.adapter;

import com.petservice.petservice.application.port.in.AddPetUseCase;
import com.petservice.petservice.application.port.in.FindPetUseCase;
import com.petservice.petservice.domain.Pet;
import com.petservice.petservice.infrastructure.adapter.dto.PetDTO;
import com.petservice.petservice.infrastructure.adapter.dto.PetOwnerDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PetController {

    private final FindPetUseCase findPetUseCase;
    private final AddPetUseCase addPetUseCase;

    public PetController(FindPetUseCase findPetUseCase,
                         AddPetUseCase addPetUseCase) {
        this.findPetUseCase = findPetUseCase;
        this.addPetUseCase = addPetUseCase;
    }

    @QueryMapping
    public List<PetDTO> eligiblePets() {
        return findPetUseCase.findEligiblePets()
                .stream()
                .map(this::getPetDTO)
                .collect(Collectors.toList());
    }

    @MutationMapping
    public PetDTO createPet(@Argument AddPetUseCase.AddPetCommand addPetCommand){
        return Optional.of(addPetUseCase.addPet(addPetCommand))
                .stream()
                .map(this::getPetDTO)
                .findFirst()
                .get();
    }

    private PetDTO getPetDTO(Pet pet) {
        PetOwnerDTO owner = new PetOwnerDTO();
        owner.setOwnerId(pet.getOwner().getOwnerId());
        owner.setOwnerName(pet.getOwner().getOwnerName());

        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setOwner(owner);
        petDTO.setWeight(pet.getWeight());
        petDTO.setBreed(pet.getBreed());
        petDTO.setVaccinationStatus(pet.getVaccinationStatus());
        petDTO.setTrainingLevel(pet.getTrainingLevel());
        return petDTO;
    }
}
