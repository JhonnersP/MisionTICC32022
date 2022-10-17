package com.ciclo3.reto5.repositories;

import com.ciclo3.reto5.entities.Clients;
import com.ciclo3.reto5.entities.Reservations;
import com.ciclo3.reto5.entities.custom.CountClient;
import com.ciclo3.reto5.repositories.crudRepositories.ReservationsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationsRepository {

    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getAll(){

        return (List<Reservations>) reservationsCrudRepository.findAll();
    }

    public Optional<Reservations> getReservation(int id){

        return reservationsCrudRepository.findById(id);
    }

    public Reservations save(Reservations r){

        return reservationsCrudRepository.save(r);
    }

    public void delete(Reservations r){

        reservationsCrudRepository.delete(r);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> res= new ArrayList<>();
        List<Object[]> report=reservationsCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){

            res.add(new CountClient((Long)report.get(i) [1],(Clients) report.get(i) [0]));
        }

        return res;
    }

    public List<Reservations> getReservationPeriod(Date a, Date b){

        return reservationsCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservations> getReservationByStatus(String status){

        return reservationsCrudRepository.findAllByStatus(status);
    }
}
