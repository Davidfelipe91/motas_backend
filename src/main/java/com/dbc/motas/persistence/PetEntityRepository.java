package com.dbc.motas.persistence;

import com.dbc.motas.domain.dto.Pet.PetDTO;
import com.dbc.motas.domain.dto.Pet.UpdatePetDTO;
import com.dbc.motas.domain.exception.SpeciesValueUnacceptedException;
import com.dbc.motas.domain.repository.PetRepository;
import com.dbc.motas.persistence.crud.CrudPetEntity;
import com.dbc.motas.persistence.entity.PetEntity;
import com.dbc.motas.persistence.mapper.PetMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetEntityRepository implements PetRepository {
    private final CrudPetEntity crudPetEntity;
    private final PetMapper petMapper;

    public PetEntityRepository(CrudPetEntity crudPetEntity, PetMapper petMapper) {
        this.crudPetEntity = crudPetEntity;
        this.petMapper = petMapper;
    }

    @Override
    public List<PetDTO> getAll() {
        return this.petMapper.toDto(this.crudPetEntity.findAll());
    }

    @Override
    public PetDTO getById(Integer id) {
        PetEntity petEntity = this.crudPetEntity.findById(id).orElse(null);
        return this.petMapper.toDto(petEntity);
    }

    @Override
    public PetDTO create(PetDTO petDTO) {
        PetEntity petEntity = this.petMapper.toEntity(petDTO);
        return this.petMapper.toDto(this.crudPetEntity.save(petEntity));
    }

    @Override
    public PetDTO update(Integer id, UpdatePetDTO updatePetDTO) {
        PetEntity petEntity = this.crudPetEntity.findById(id).orElse(null);
        if (petEntity == null) return null;

//        if (petEntity.getSpecies().equals("FELINEx")) {
//            throw new SpeciesValueUnacceptedException(petEntity.getSpecies());
//        }

        this.petMapper.updateEntityFromDto(updatePetDTO, petEntity);
        return this.petMapper.toDto(this.crudPetEntity.save(petEntity));
    }

    @Override
    public void delete(Integer id) {
        this.crudPetEntity.deleteById(id);
    }
}
