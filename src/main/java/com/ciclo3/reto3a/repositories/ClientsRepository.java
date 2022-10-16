package com.ciclo3.reto3a.repositories;

import com.ciclo3.reto3a.entities.Clients;
import com.ciclo3.reto3a.repositories.crudRepositories.ClientsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientsRepository {

    @Autowired
    private ClientsCrudRepository clientsCrudRepository;

    public List<Clients> getAll(){

        return (List<Clients>) clientsCrudRepository.findAll();
    }

    public Optional<Clients> getClient(int id){

        return clientsCrudRepository.findById(id);
    }

    public Clients save(Clients cl){

        return clientsCrudRepository.save(cl);
    }

    public void delete(Clients cl){

        clientsCrudRepository.delete(cl);
    }
}
