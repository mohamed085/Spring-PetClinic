package com.demo.sfgpetclinic.services.springDataJPA;

import com.demo.sfgpetclinic.model.Specialty;
import com.demo.sfgpetclinic.repositories.SpecialtyRepository;
import com.demo.sfgpetclinic.services.SpecialtyServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class SpecialtyServicesImp implements SpecialtyServices {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServicesImp(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
