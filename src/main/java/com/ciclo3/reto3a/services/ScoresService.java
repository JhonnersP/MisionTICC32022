package com.ciclo3.reto3a.services;


import com.ciclo3.reto3a.entities.Reservations;
import com.ciclo3.reto3a.entities.Scores;
import com.ciclo3.reto3a.repositories.ReservationsRepository;
import com.ciclo3.reto3a.repositories.ScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoresService {

    @Autowired
    private ScoresRepository scoresRepository;

    public List<Scores> getAll(){

        return scoresRepository.getAll();
    }

    public Optional<Scores> getScore(int id){

        return scoresRepository.getScore(id);
    }

    public Scores save(Scores s){

        if(s.getIdScore()==null){

            return scoresRepository.save(s);
        }else{

            Optional<Scores> s2= scoresRepository.getScore(s.getIdScore());

            if(s2.isPresent()){
                return s;
            }else{
                return scoresRepository.save(s);
            }
        }
    }

    public Scores update(Scores s){

        if(s.getIdScore()!=null){

            Optional<Scores> s2 = scoresRepository.getScore(s.getIdScore());//Traer elemento BD con id de sp

            if(s2.isPresent()){

                if(s.getReservation()!=null){

                    s2.get().setReservation(s.getReservation());

                }
                if(s.getMessageText()!=null){

                    s2.get().setMessageText(s.getMessageText());

                }
                if(s.getStars()!=null){

                    s2.get().setStars(s.getStars());

                }

                scoresRepository.save(s2.get());
                return s2.get();

            }else{
                return s;
            }

        }
        return s;
    }

    public boolean delete(Scores s){

        boolean flag = false;

        Optional<Scores> s2 = scoresRepository.getScore(s.getIdScore());

        if(s2.isPresent()){

            scoresRepository.delete(s2.get());
            flag = true;
        }

        return flag;

    }




}
