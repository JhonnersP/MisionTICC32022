package com.ciclo3.reto3a.repositories.crudRepositories;

import com.ciclo3.reto3a.entities.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesCrudRepository extends CrudRepository<Messages,Integer> {
}
