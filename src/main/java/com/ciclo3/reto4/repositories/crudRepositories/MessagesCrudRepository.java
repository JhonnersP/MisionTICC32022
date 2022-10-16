package com.ciclo3.reto4.repositories.crudRepositories;

import com.ciclo3.reto4.entities.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesCrudRepository extends CrudRepository<Messages,Integer> {
}
