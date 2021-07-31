package com.demo.sfgpetclinic.services.map;

import com.demo.sfgpetclinic.model.Specialty;
import com.demo.sfgpetclinic.services.SpecialtiesServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesServicesMap extends AbstractMapServices<Specialty , Long> implements SpecialtiesServices {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty t) {
        super.delete(t);
    }

    @Override
    public Specialty save(Specialty t) {
        return super.save(t);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
