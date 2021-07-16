package com.demo.sfgpetclinic.bootstrap;

import com.demo.sfgpetclinic.services.OwnerServices;
import com.demo.sfgpetclinic.services.VetServices;
import com.demo.sfgpetclinic.services.map.OwnerServicesMap;
import com.demo.sfgpetclinic.services.map.VetServicesMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    public DataLoader() {
        ownerServices = new OwnerServicesMap();
        vetServices = new VetServicesMap();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
