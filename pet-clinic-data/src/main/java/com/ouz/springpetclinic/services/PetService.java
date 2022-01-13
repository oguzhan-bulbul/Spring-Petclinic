package com.ouz.springpetclinic.services;

import com.ouz.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
