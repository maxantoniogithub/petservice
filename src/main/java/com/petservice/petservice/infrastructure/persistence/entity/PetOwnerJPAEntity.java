package com.petservice.petservice.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PET_OWNER")
public class PetOwnerJPAEntity implements Serializable{
    @Id
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PetJPAEntity> pets;
}
