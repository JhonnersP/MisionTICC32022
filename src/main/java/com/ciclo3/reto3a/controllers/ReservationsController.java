package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Reservations;
import com.ciclo3.reto3a.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservations> getAll(){
        return reservationsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> get(@PathVariable("id") int Id) {
        return reservationsService.getReservation(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations r){

        return reservationsService.save(r);
    }


}
