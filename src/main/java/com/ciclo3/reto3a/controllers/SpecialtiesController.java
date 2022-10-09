package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Specialties;
import com.ciclo3.reto3a.services.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Specialty")
public class SpecialtiesController {

    @Autowired
    private SpecialtiesService specialtiesService;

    @GetMapping("/all")
    public List<Specialties> getAll(){
        return specialtiesService.getAll();
    }

    @PostMapping("/all")
    public Specialties save(@RequestBody Specialties sp){

        return specialtiesService.save(sp);
    }


}
