package com.goit.productstore.models.manufacturer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public Manufacturer save(Manufacturer manufacturer){

        return manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer getByUuid(UUID uuid){
        return manufacturerRepository.findById(uuid).get();
    }

    public void deleteById(UUID uuid){
        manufacturerRepository.deleteById(uuid);
    }

}
