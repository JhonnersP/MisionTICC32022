package com.ciclo3.reto4.repositories;

import com.ciclo3.reto4.entities.Specialties;
import com.ciclo3.reto4.repositories.crudRepositories.SpecialtiesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtiesRepository {

    @Autowired
    private SpecialtiesCrudRepository specialtiesCrudRepository;

    public List<Specialties> getAll(){

        return (List<Specialties>) specialtiesCrudRepository.findAll();
    }

    public Optional<Specialties> getSpecialty(int id){

        return specialtiesCrudRepository.findById(id);
    }

    public Specialties save(Specialties sp){

        return specialtiesCrudRepository.save(sp);
    }

    public void delete(Specialties sp){

        specialtiesCrudRepository.delete(sp);
    }
}
