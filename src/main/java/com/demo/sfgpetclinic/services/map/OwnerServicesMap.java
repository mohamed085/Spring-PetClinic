package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.services.CRUDServices;

import java.util.Set;

public class OwnerServicesMap extends AbstractMapServices<Owner, Long> implements CRUDServices<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner t) {
        super.delete(t);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner t) {
        return super.save(t.getId(), t);
    }
}
