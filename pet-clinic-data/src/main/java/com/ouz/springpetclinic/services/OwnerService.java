package com.ouz.springpetclinic.services;

import com.ouz.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
