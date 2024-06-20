package com.petservice.petservice.infrastructure.persistence.dao;

import com.petservice.petservice.infrastructure.persistence.entity.PetOwnerJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerEntityDAO extends JpaRepository<PetOwnerJPAEntity, Long> {
}
