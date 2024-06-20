package com.petservice.petservice.infrastructure.persistence.dao;

import com.petservice.petservice.infrastructure.persistence.entity.PetJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetEntityDAO extends JpaRepository<PetJPAEntity, UUID> {

    @Query("SELECT pet " +
            "FROM PetJPAEntity pet " +
            "WHERE pet.weight < :weight " +
            "AND pet.vaccinationStatus = :vaccinationStatus " +
            "AND pet.breed <> :breed " +
            "AND pet.trainingLevel >= :trainingLevel")
    List<PetJPAEntity> findPetsByEligibleCriteria(Long weight, String breed,
                                                  Boolean vaccinationStatus, Integer trainingLevel);
}
