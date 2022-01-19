package com.demo.sfgpetclinic.services.springDataJPA;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.repositories.OwnerRepository;
import com.demo.sfgpetclinic.services.PetServices;
import com.demo.sfgpetclinic.services.PetTypeServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServicesImpTest {

    Owner returnOwner;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeServices petTypeServices;

    @Mock
    PetServices petServices;

    @InjectMocks
    OwnerServicesImp service;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).firstName("Mohamed").lastName("Emad").build();
    }

    @Test
    void findByFirstName() {
        when(ownerRepository.findByFirstName(any())).thenReturn(returnOwner);

        Owner owner = service.findByFirstName("Mohamed");
        assertEquals(owner.getFirstName(), returnOwner.getFirstName());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName("Emad");
        assertEquals(owner.getLastName(), returnOwner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(owners.size(), 1);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);
        assertEquals(owner.getId(), returnOwner.getId());
    }

}