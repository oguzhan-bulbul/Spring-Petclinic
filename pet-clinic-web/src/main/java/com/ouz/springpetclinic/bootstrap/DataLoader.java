package com.ouz.springpetclinic.bootstrap;

import com.ouz.springpetclinic.model.Owner;
import com.ouz.springpetclinic.model.PetType;
import com.ouz.springpetclinic.model.Vet;
import com.ouz.springpetclinic.services.OwnerService;
import com.ouz.springpetclinic.services.PetTypeService;
import com.ouz.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
		this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	PetType dog = new PetType();
    	dog.setName("Dog John");
    	PetType savedDogPetType = petTypeService.save(dog);
    	
    	PetType cat = new PetType();
    	cat.setName("Cat John");
    	PetType savedCatPetType = petTypeService.save(cat);
    	
        Owner owner1 =  new Owner();
        owner1.setFirstName("Oguzhan");
        owner1.setLastName("BULBUL");
        ownerService.save(owner1);


        Owner owner2 =  new Owner();
        owner2.setFirstName("Hakan");
        owner2.setLastName("BULBUL");
        ownerService.save(owner2);

        System.out.println("Loaded Owners........");


        Vet vet1 = new Vet();
        vet1.setFirstName("Meryem");
        vet1.setLastName("BULBUL");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mustafa");
        vet2.setLastName("BULBUL");
        vetService.save(vet2);

        System.out.println("Loaded Vets.....");










    }
}
