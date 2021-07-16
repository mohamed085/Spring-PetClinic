package com.demo.sfgpetclinic.services;

import com.demo.sfgpetclinic.model.Owner;

public interface OwnerServices extends CRUDServices<Owner, Long> {
    Owner findByFirstName(String firstName);
    Owner findByLastName(String lastName);
}
