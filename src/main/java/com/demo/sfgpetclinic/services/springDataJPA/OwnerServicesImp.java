package com.demo.sfgpetclinic.services.springDataJPA;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.repositories.OwnerRepository;
import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.PetServices;
import com.demo.sfgpetclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class OwnerServicesImp implements OwnerServices {

    private final OwnerRepository ownerRepository;
    private final PetTypeServices petTypeServices;
    private final PetServices petServices;

    public OwnerServicesImp(OwnerRepository ownerRepository, PetTypeServices petTypeServices, PetServices petServices) {
        this.ownerRepository = ownerRepository;
        this.petTypeServices = petTypeServices;
        this.petServices = petServices;
    }

    @Override
    public Owner findByFirstName(String firstName) {
        return ownerRepository.findByFirstName(firstName);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
