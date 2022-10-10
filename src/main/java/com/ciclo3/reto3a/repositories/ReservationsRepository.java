package com.ciclo3.reto3a.repositories;

import com.ciclo3.reto3a.entities.Reservations;
import com.ciclo3.reto3a.repositories.crudRepositories.ReservationsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
