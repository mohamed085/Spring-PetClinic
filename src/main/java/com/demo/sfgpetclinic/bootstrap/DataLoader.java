package com.demo.sfgpetclinic.bootstrap;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.model.PetType;
import com.demo.sfgpetclinic.model.Vet;
import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.PetTypeServices;
import com.demo.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeServices petTypeServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeServices petTypeServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeServices = petTypeServices;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeServices.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeServices.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mohamed");
        owner1.setLastName("Emad");

        Owner owner2 = new Owner();
        owner2.setFirstName("Ali");
        owner2.setLastName("Ahmed");

        ownerServices.save(owner1);
        ownerServices.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Mohamed");
        vet1.setLastName("Emad");

        Vet vet2 = new Vet();
        vet2.setFirstName("Ali");
        vet2.setLastName("Ahmed");

        vetServices.save(vet1);
        vetServices.save(vet2);

    }
}
