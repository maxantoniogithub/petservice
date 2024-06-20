package com.petservice.petservice.domain.mapper;

import com.petservice.petservice.domain.Pet;
import com.petservice.petservice.domain.PetOwner;
import com.petservice.petservice.infrastructure.persistence.entity.PetJPAEntity;
import com.petservice.petservice.infrastructure.persistence.entity.PetOwnerJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class PetMapper implements Mapper<Pet, PetJPAEntity> {
    @Override
    public Pet toDomain(PetJPAEntity entity) {
        if (entity == null) {
            return null;
        }
        PetOwner owner = new PetOwner(entity.getOwner().getOwnerId(),entity.getOwner().getOwnerName());
        return new Pet(entity.getId(), owner,
                entity.getWeight(), entity.getBreed(),
                entity.getVaccinationStatus(), entity.getTrainingLevel());
    }

    @Override
    public PetJPAEntity toEntity(Pet domain) {
        if (domain == null) {
            return null;
        }
        PetOwnerJPAEntity owner = PetOwnerJPAEntity.builder()
                .ownerId(domain.getOwner().getOwnerId())
                .ownerName(domain.getOwner().getOwnerName())
                .build();

        return PetJPAEntity.builder()
                .id(domain.getId())
                .weight(domain.getWeight())
                .breed(domain.getBreed())
                .vaccinationStatus(domain.getVaccinationStatus())
                .trainingLevel(domain.getTrainingLevel())
                .owner(owner)
                .build();
    }
}
