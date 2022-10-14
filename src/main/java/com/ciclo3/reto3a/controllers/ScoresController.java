package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Reservations;
import com.ciclo3.reto3a.entities.Scores;
import com.ciclo3.reto3a.services.ReservationsService;
import com.ciclo3.reto3a.services.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoresController {

    @Autowired
    private ScoresService scoresService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Scores> getAll(){
        return scoresService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Scores save(@RequestBody Scores s){

        return scoresService.save(s);
    }


}
