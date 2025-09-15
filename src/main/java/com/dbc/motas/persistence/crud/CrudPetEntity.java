package com.dbc.motas.persistence.crud;

import com.dbc.motas.persistence.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

    public interface CrudPetEntity extends CrudRepository<PetEntity, Integer> {
}
