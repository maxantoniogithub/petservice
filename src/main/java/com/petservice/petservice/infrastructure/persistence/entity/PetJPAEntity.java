package com.petservice.petservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PET")
public class PetJPAEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PetOwnerJPAEntity owner;

    @Column(name = "weight", nullable = false)
    private Long weight;

    @Column(name = "breed", nullable = false, length = 100)
    private String breed;

    @Column(name = "vaccination_status", nullable = false)
    private Boolean vaccinationStatus;

    @Column(name = "training_level", nullable = false)
    private Integer trainingLevel;
}
