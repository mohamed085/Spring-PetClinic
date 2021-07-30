package com.demo.sfgpetclinic.bootstrap;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.model.Pet;
import com.demo.sfgpetclinic.model.PetType;
import com.demo.sfgpetclinic.model.Vet;
import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.PetTypeServices;
import com.demo.sfgpetclinic.services.SpecialitiesServices;
import com.demo.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeServices petTypeServices;
    private final SpecialitiesServices specialitiesServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeServices petTypeServices, SpecialitiesServices specialitiesServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeServices = petTypeServices;
        this.specialitiesServices = specialitiesServices;
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
        owner1.setAddress("123 bii");
        owner1.setCity("asdas");
        owner1.setTelephone("13252321");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");

        owner1.getPets().add(pet1);
        ownerServices.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Ali");
        owner2.setLastName("Ahmed");
        owner2.setAddress("123 bisi");
        owner2.setCity("asdaass");
        owner2.setTelephone("1325232221");

        Pet pet2 = new Pet();
        pet2.setPetType(savedDogPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Tito");

        owner2.getPets().add(pet2);
        ownerServices.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Mohamed");
        vet1.setLastName("Emad");
        vetServices.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Ali");
        vet2.setLastName("Ahmed");
        vetServices.save(vet2);

    }
}
