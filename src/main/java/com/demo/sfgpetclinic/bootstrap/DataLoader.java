package com.demo.sfgpetclinic.bootstrap;

import com.demo.sfgpetclinic.model.*;
import com.demo.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeServices petTypeServices;
    private final SpecialtyServices specialtyServices;
    private final VisitServices visitServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeServices petTypeServices, SpecialtyServices specialtyServices, VisitServices visitServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeServices = petTypeServices;
        this.specialtyServices = specialtyServices;
        this.visitServices = visitServices;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeServices.findAll().size() == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeServices.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeServices.save(dog);

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("Radiology");
        Specialty savedSpecialty1 = specialtyServices.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Surgery");
        Specialty savedSpecialty2 = specialtyServices.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("Dentistry");
        Specialty savedSpecialty3 = specialtyServices.save(specialty3);

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
        pet1.setOwner(owner1);

        owner1.getPets().add(pet1);
        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ali");
        owner2.setLastName("Ahmed");
        owner2.setAddress("123 bisi");
        owner2.setCity("asdaass");
        owner2.setTelephone("1325232221");

        ownerServices.save(owner1);
        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Tito");
        pet2.setOwner(owner2);

        owner2.getPets().add(pet2);
        ownerServices.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(pet2);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneeze Kitty");
        visitServices.save(visit1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Mohamed");
        vet1.setLastName("Emad");
        vet1.getSpecialties().add(savedSpecialty1);
        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ali");
        vet2.setLastName("Ahmed");
        vet2.getSpecialties().add(savedSpecialty2);
        vet2.getSpecialties().add(savedSpecialty3);
        vetServices.save(vet2);
    }
}