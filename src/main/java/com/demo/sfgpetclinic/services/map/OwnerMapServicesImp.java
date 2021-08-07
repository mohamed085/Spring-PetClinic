package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Owner;
import com.demo.sfgpetclinic.model.Pet;
import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.PetServices;
import com.demo.sfgpetclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapServicesImp extends AbstractMapServices<Owner, Long> implements OwnerServices {

    private final PetTypeServices petTypeServices;
    private final PetServices petServices;

    public OwnerMapServicesImp(PetTypeServices petTypeServices, PetServices petServices) {
        this.petTypeServices = petTypeServices;
        this.petServices = petServices;
    }

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

        if (t != null) {
            if (t.getPets() != null) {
                t.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeServices.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petServices.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(t);
        } else {
            return null;
        }
    }

    @Override
    public Owner findByFirstName(String firstName) {
//        for (Map.Entry<Long, Owner> entry : super.map.entrySet()) {
//            Long aLong = entry.getKey();
//            Owner owner = entry.getValue();
//            if (owner.getFirstName().equals(firstName)) {
//                return owner;
//            }
//        }
//        return null;

        return this.findAll()
                .stream()
                .filter(owner -> owner.getFirstName().equalsIgnoreCase(firstName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);    }
}
