package com.ciclo3.reto5.repositories;


import com.ciclo3.reto5.entities.Scores;
import com.ciclo3.reto5.repositories.crudRepositories.ScoresCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoresRepository {

    @Autowired
    private ScoresCrudRepository scoresCrudRepository;

    public List<Scores> getAll(){

        return (List<Scores>) scoresCrudRepository.findAll();
    }

    public Optional<Scores> getScore(int id){

        return scoresCrudRepository.findById(id);
    }

    public Scores save(Scores s){

        return scoresCrudRepository.save(s);
    }

    public void delete(Scores s){

        scoresCrudRepository.delete(s);
    }
}
