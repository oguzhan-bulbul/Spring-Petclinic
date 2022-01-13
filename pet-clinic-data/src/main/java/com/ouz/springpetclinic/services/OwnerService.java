package com.ouz.springpetclinic.services;

import com.ouz.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(long id);
    Owner save(Owner owner);
    Set<Owner> findAll();


}
