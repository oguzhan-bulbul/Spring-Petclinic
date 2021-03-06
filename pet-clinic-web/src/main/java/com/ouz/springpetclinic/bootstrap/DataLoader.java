package com.ouz.springpetclinic.bootstrap;

import com.ouz.springpetclinic.model.Owner;
import com.ouz.springpetclinic.model.Pet;
import com.ouz.springpetclinic.model.PetType;
import com.ouz.springpetclinic.model.Speciality;
import com.ouz.springpetclinic.model.Vet;
import com.ouz.springpetclinic.services.OwnerService;
import com.ouz.springpetclinic.services.PetTypeService;
import com.ouz.springpetclinic.services.SpecialityService;
import com.ouz.springpetclinic.services.VetService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	int count = petTypeService.findAll().size();
    	
    	if(count == 0 ) {
    		loadData();
    	}
    	
    	

    }

	private void loadData() {
		PetType dog = new PetType();
    	dog.setName("Dog John");
    	PetType savedDogPetType = petTypeService.save(dog);
    	
    	PetType cat = new PetType();
    	cat.setName("Cat John");
    	PetType savedCatPetType = petTypeService.save(cat);
    	
    	Speciality radiology = new Speciality();
    	radiology.setDescription("Radiology");
    	Speciality savedRadiology = specialityService.save(radiology);
    	
    	Speciality surgery = new Speciality();
    	radiology.setDescription("Surgery");
    	Speciality savedSurgery = specialityService.save(surgery);
    	
    	Speciality dentistry = new Speciality();
    	radiology.setDescription("Dentistry");
    	Speciality savedDentistry = specialityService.save(dentistry);
    	
        Owner owner1 =  new Owner();
        owner1.setFirstName("Oguzhan");
        owner1.setLastName("BULBUL");
        owner1.setAddress("Ayisigi1");
        owner1.setCity("Trabzon");
        owner1.setTelephone("05346004262");
        ownerService.save(owner1);
        
        Pet ouzpet = new Pet();
        ouzpet.setPetType(savedDogPetType);
        ouzpet.setOwner(owner1);
        ouzpet.setBirthDate(LocalDate.of(2012, 2, 12));
        ouzpet.setName("Rosco");
        
        owner1.getPets().add(ouzpet);
        


        Owner owner2 =  new Owner();
        owner2.setFirstName("Hakan");
        owner2.setLastName("BULBUL");
        owner2.setAddress("Ayisigi3");
        owner2.setCity("Trabzon");
        owner2.setTelephone("05331252152");
        ownerService.save(owner2);
        
        Pet hknpet = new Pet();
        ouzpet.setPetType(savedCatPetType);
        ouzpet.setOwner(owner2);
        ouzpet.setBirthDate(LocalDate.of(2020, 6, 30));
        ouzpet.setName("Gimli");
        
        owner2.getPets().add(hknpet);

        System.out.println("Loaded Owners........");


        Vet vet1 = new Vet();
        vet1.setFirstName("Meryem");
        vet1.setLastName("BULBUL");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mustafa");
        vet2.setLastName("BULBUL");
        vet2.getSpecialties().add(savedDentistry);      
        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
	}
}
