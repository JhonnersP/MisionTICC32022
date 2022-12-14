package com.ciclo3.reto3a.repositories;

import com.ciclo3.reto3a.entities.Doctors;
import com.ciclo3.reto3a.repositories.crudRepositories.DoctorsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorsRepository {

    @Autowired
    private DoctorsCrudRepository doctorsCrudRepository;

    public List<Doctors> getAll(){

        return (List<Doctors>) doctorsCrudRepository.findAll();
    }

    public Optional<Doctors> getDoctor(int id){

        return doctorsCrudRepository.findById(id);

    }

    public Doctors save(Doctors doc){
        return doctorsCrudRepository.save(doc);
    }

    public void delete(Doctors doc){

        doctorsCrudRepository.delete(doc);
    }

}
