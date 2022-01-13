package com.ouz.springpetclinic.services;

import com.ouz.springpetclinic.model.Pet;
import com.ouz.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
