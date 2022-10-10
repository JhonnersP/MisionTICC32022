package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Reservations;
import com.ciclo3.reto3a.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getAll(){
        return reservationsService.getAll();
    }

    @PostMapping("/save")
    public Reservations save(@RequestBody Reservations r){

        return reservationsService.save(r);
    }


}
