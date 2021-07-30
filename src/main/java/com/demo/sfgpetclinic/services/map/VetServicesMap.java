package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Speciality;
import com.demo.sfgpetclinic.model.Vet;
import com.demo.sfgpetclinic.services.SpecialitiesServices;
import com.demo.sfgpetclinic.services.VetServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServicesMap extends AbstractMapServices<Vet, Long> implements VetServices {

    private final SpecialitiesServices specialitiesServices;

    public VetServicesMap(SpecialitiesServices specialitiesServices) {
        this.specialitiesServices = specialitiesServices;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet t) {
        super.delete(t);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet t) {

        if (t != null) {
            if (t.getSpecialities().size() > 0) {
                t.getSpecialities().forEach(speciality -> {
                    if (speciality != null) {
                        if (speciality.getId() == null) {
                            Speciality savedSpeciality = specialitiesServices.save(speciality);
                            speciality.setId(savedSpeciality.getId());
                        }
                    }
                });
            }
            return super.save(t);
        }
        else {
            return null;
        }
    }
}