package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Speciality;
import com.demo.sfgpetclinic.services.SpecialitiesServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesServicesMap extends AbstractMapServices<Speciality, Long> implements SpecialitiesServices {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality t) {
        super.delete(t);
    }

    @Override
    public Speciality save(Speciality t) {
        return super.save(t);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
