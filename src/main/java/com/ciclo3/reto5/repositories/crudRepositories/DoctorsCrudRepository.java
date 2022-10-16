package com.ciclo3.reto5.repositories.crudRepositories;

import com.ciclo3.reto5.entities.Doctors;
import org.springframework.data.repository.CrudRepository;

public interface DoctorsCrudRepository extends CrudRepository<Doctors,Integer> {
}
