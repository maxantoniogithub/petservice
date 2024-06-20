package com.petservice.petservice.application.adapter.out;

import com.petservice.petservice.application.port.in.AddPetUseCase;
import com.petservice.petservice.application.port.in.FindPetUseCase;
import com.petservice.petservice.application.port.out.PetRepository;
import com.petservice.petservice.domain.Pet;
import com.petservice.petservice.domain.exception.DatabaseException;
import com.petservice.petservice.domain.mapper.PetMapper;
import com.petservice.petservice.infrastructure.persistence.dao.PetEntityDAO;
import com.petservice.petservice.infrastructure.persistence.dao.PetOwnerEntityDAO;
import com.petservice.petservice.infrastructure.persistence.entity.PetJPAEntity;
import com.petservice.petservice.infrastructure.persistence.entity.PetOwnerJPAEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetRepositoryImpl implements PetRepository {

    private final PetEntityDAO petEntityDAO;
    private final PetOwnerEntityDAO petOwnerEntityDAO;
    private final PetMapper petMapper;
    private final String PET_OWNER_ERROR_EXCEPTION = "Error saving PetOwner:";

    public PetRepositoryImpl(PetEntityDAO petEntityDAO,
                             PetOwnerEntityDAO petOwnerEntityDAO,
                             PetMapper petMapper) {
        this.petEntityDAO = petEntityDAO;
        this.petOwnerEntityDAO = petOwnerEntityDAO;
        this.petMapper = petMapper;
    }

    @Override
    public List<Pet> findPetsByEligibleCriteria(FindPetUseCase.EligiblePetsSearchCriteriaCommand eligiblePets) {
        return petEntityDAO.findPetsByEligibleCriteria(eligiblePets.getWeightUnder(),
                        eligiblePets.getNotBreed(),
                        eligiblePets.getVaccinationStatus(),
                        eligiblePets.getTrainingLevelAbove())
                .stream()
                .map(petInformation -> petMapper.toDomain(petInformation))
                .collect(Collectors.toList());
    }

    @Override
    public Pet savePet(AddPetUseCase.AddPetCommand addPetCommand) {
        PetOwnerJPAEntity owner = petOwnerEntityDAO.findById(addPetCommand.getOwner().getOwnerId())
                .orElse(null);

        if (Objects.isNull(owner)) {
            PetOwnerJPAEntity newOwner = new PetOwnerJPAEntity();
            newOwner.setOwnerId(addPetCommand.getOwner().getOwnerId());
            newOwner.setOwnerName(addPetCommand.getOwner().getOwnerName());

            PetOwnerJPAEntity ownerCreated = Optional.of(petOwnerEntityDAO.save(newOwner))
                    .orElseThrow(() -> new DatabaseException(PET_OWNER_ERROR_EXCEPTION + addPetCommand.getOwner().getOwnerId()));
            owner = ownerCreated;
        }

        PetJPAEntity entity = new PetJPAEntity();
        entity.setOwner(owner);
        entity.setWeight(addPetCommand.getWeight());
        entity.setBreed(addPetCommand.getBreed());
        entity.setVaccinationStatus(addPetCommand.getVaccinationStatus());
        entity.setTrainingLevel(addPetCommand.getTrainingLevel());
        PetJPAEntity newEntity = petEntityDAO.save(entity);

        return petMapper.toDomain(newEntity);
    }
}
