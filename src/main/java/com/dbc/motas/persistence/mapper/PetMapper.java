package com.dbc.motas.persistence.mapper;

import com.dbc.motas.domain.dto.Pet.PetDTO;
import com.dbc.motas.domain.dto.Pet.UpdatePetDTO;
import com.dbc.motas.persistence.entity.PetEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "species", target = "species")
    @Mapping(source = "breed", target = "breed")
    PetDTO toDto(PetEntity entity);

    List<PetDTO> toDto(Iterable<PetEntity> entity);

    @InheritConfiguration
    PetEntity toEntity(PetDTO petDTO);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "species", target = "species")
    @Mapping(source = "breed", target = "breed")
    void updateEntityFromDto(UpdatePetDTO updatePetDTO, @MappingTarget PetEntity petEntity);
}




