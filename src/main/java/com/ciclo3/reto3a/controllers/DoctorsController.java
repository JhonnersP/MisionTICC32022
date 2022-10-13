package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Doctors;
import com.ciclo3.reto3a.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Doctors> getAll(){

        return doctorsService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctors save(@RequestBody Doctors doc){

        return doctorsService.save(doc);
    }
}
