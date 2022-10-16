package com.ciclo3.reto4.repositories.crudRepositories;

import com.ciclo3.reto4.entities.Doctors;
import org.springframework.data.repository.CrudRepository;

public interface DoctorsCrudRepository extends CrudRepository<Doctors,Integer> {
}
