package com.demo.sfgpetclinic.bootstrap;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.model.Vet;
import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mohamed");
        owner1.setLastName("Emad");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ali");
        owner2.setLastName("Ahmed");

        ownerServices.save(owner1);
        ownerServices.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mohamed");
        vet1.setLastName("Emad");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ali");
        vet2.setLastName("Ahmed");

        vetServices.save(vet1);
        vetServices.save(vet2);

    }
}
