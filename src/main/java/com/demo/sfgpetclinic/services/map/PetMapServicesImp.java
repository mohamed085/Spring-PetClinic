package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Pet;
import com.demo.sfgpetclinic.services.PetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetMapServicesImp extends AbstractMapServices<Pet, Long> implements PetServices {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet t) {
        super.delete(t);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet t) {
        return super.save(t);
    }
}