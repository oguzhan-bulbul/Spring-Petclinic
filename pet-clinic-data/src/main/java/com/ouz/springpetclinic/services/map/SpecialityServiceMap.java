package com.ouz.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ouz.springpetclinic.model.Speciality;
import com.ouz.springpetclinic.services.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService{
	
	@Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }	
	
	@Override
	public Speciality findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		
		return super.save(object);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
		
	}
	
	@Override
	public void deleteById(Long id) {
	     super.deleteById(id);
	}



}
