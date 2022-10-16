package com.ciclo3.reto4.controllers;


import com.ciclo3.reto4.entities.Scores;
import com.ciclo3.reto4.services.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoresController {

    @Autowired
    private ScoresService scoresService;

    @GetMapping("/all")
    public List<Scores> getAll(){
        return scoresService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Scores> get(@PathVariable("id") int Id) {
        return scoresService.getScore(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Scores save(@RequestBody Scores s){

        return scoresService.save(s);
    }


}
