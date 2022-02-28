package com.ouz.springpetclinic.services.map;
import com.ouz.springpetclinic.model.Speciality;
import com.ouz.springpetclinic.model.Vet;
import com.ouz.springpetclinic.services.CrudService;
import com.ouz.springpetclinic.services.SpecialityService;
import com.ouz.springpetclinic.services.VetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

	private final SpecialityService specialityService;
	
	@Autowired	
    public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
    	
    	if(object.getSpecialties().size()>0) {
    		object.getSpecialties().forEach(speciality -> {
    			if(speciality.getId() == null) {
    				Speciality savedSpeciality = specialityService.save(speciality);
    				speciality.setId(savedSpeciality.getId());
    			}
    		});
    	}
    	   	
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
