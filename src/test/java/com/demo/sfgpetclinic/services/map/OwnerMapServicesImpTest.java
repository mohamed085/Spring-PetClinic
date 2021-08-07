package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServicesImpTest {

    OwnerMapServicesImp ownerMapServicesImp;

    final Long ownerId = 1L;
    final String firstName = "Mohamed";
    final String lastName = "Emad";

    @BeforeEach
    void setUp() {
        ownerMapServicesImp = new OwnerMapServicesImp(new PetTypeMapServicesImp(), new PetMapServicesImp());
        ownerMapServicesImp.save(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapServicesImp.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapServicesImp.deleteById(ownerId);
        assertEquals(0, ownerMapServicesImp.findAll().size());
    }

    @Test
    void delete() {
        ownerMapServicesImp.delete(ownerMapServicesImp.findById(ownerId));
        assertEquals(0, ownerMapServicesImp.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapServicesImp.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner = ownerMapServicesImp.save(new Owner().builder().id(ownerId).build());
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveNotId() {
        Owner owner = ownerMapServicesImp.save(new Owner().builder().build());
        assertNotNull(owner.getId());
        assertNotNull(owner);
    }

    @Test
    void findByFirstName() {
        Owner mohamed = ownerMapServicesImp.findByFirstName(firstName);
        assertNotNull(mohamed);
        assertEquals(ownerId, mohamed.getId());
    }

    @Test
    void findByLastName() {
        Owner mohamed = ownerMapServicesImp.findByLastName(lastName);
        assertNotNull(mohamed);
        assertEquals(ownerId, mohamed.getId());
    }
}