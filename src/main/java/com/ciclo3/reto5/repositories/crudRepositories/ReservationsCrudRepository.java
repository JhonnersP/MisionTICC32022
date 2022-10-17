package com.ciclo3.reto5.repositories.crudRepositories;

import com.ciclo3.reto5.entities.Reservations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationsCrudRepository extends CrudRepository<Reservations,Integer> {

    @Query("SELECT c.client, COUNT (c.client) from Reservations as c group by c.client order by COUNT(c.client) DESC ")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservations> findAllByStatus(String status);

}