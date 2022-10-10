package com.ciclo3.reto3a.repositories;

import com.ciclo3.reto3a.entities.Messages;
import com.ciclo3.reto3a.repositories.crudRepositories.MessagesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessagesRepository {

    @Autowired
    private MessagesCrudRepository messagesCrudRepository;

    public List<Messages> getAll(){

        return (List<Messages>) messagesCrudRepository.findAll();
    }

    public Optional<Messages> getMessage(int id){

        return messagesCrudRepository.findById(id);
    }

    public Messages save(Messages sp){

        return messagesCrudRepository.save(sp);
    }

    public void delete(Messages sp){

        messagesCrudRepository.delete(sp);
    }
}
