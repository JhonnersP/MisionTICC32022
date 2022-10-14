package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Specialties;
import com.ciclo3.reto3a.services.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SpecialtiesController {

    @Autowired
    private SpecialtiesService specialtiesService;

    @GetMapping("/all")
    public List<Specialties> getAll(){
        return specialtiesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Specialties> get(@PathVariable("id") int Id) {
        return specialtiesService.getSpecialty(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialties save(@RequestBody Specialties sp){

        return specialtiesService.save(sp);
    }


}
