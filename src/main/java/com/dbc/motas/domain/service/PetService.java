package com.dbc.motas.domain.service;

import com.dbc.motas.domain.dto.Pet.PetDTO;
import com.dbc.motas.domain.dto.Pet.UpdatePetDTO;
import com.dbc.motas.domain.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetDTO> getAll() {
        return this.petRepository.getAll();
    }

    public PetDTO getById(Integer id) {
        return this.petRepository.getById(id);
    }

    public PetDTO create(PetDTO petDTO) {
        return this.petRepository.create(petDTO);
    }

    public PetDTO update(Integer id, UpdatePetDTO updatePetDTO) {
        return this.petRepository.update(id, updatePetDTO);
    }

    public void delete(Integer id){
        this.petRepository.delete(id);
    }

}
