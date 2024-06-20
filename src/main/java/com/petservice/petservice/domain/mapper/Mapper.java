package com.petservice.petservice.domain.mapper;

public interface Mapper<D, E> {
    D toDomain(E entity);

    E toEntity(D domain);
}
